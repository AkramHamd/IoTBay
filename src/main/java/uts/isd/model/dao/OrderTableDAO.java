package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import uts.isd.model.User;
import uts.isd.model.OrderLineItem;
import uts.isd.model.Product;

public class OrderTableDAO {
    private Connection con;
    public OrderTableDAO(Connection connection) throws SQLException {
        this.con = connection;
        con.setAutoCommit(true);
    }

    


    // returns a list of the orderlineitems of active order // should be used in cart view
    public ArrayList<OrderLineItem> getCurrentItems(int user_id) throws SQLException {
    ArrayList<OrderLineItem> orderLineItems = new ArrayList<>();

    PreparedStatement st = con.prepareStatement("SELECT order_id FROM ordertable WHERE user_id = ? AND Status = ?");
    st.setInt(1, user_id); 
    st.setString(2, "active"); 
    ResultSet result = st.executeQuery();
    int order_id = result.getInt("order_id");

    PreparedStatement st2 = con.prepareStatement("SELECT product_id, Quantity, OrderLineItem_Price FROM orderlineitem WHERE order_id = ?");
    st2.setInt(1, order_id);
    ResultSet orderResult = st2.executeQuery();

    while (orderResult.next()) {
        int product_id = orderResult.getInt("product_id");
        int quantity = orderResult.getInt("Quantity");
        double price = orderResult.getInt("OrderLineItem_Price");
        
        OrderLineItem orderLineItem = new OrderLineItem(0 ,order_id, product_id, quantity, price);
        orderLineItems.add(orderLineItem);
    }
    return orderLineItems;
    }


    // generates order table when a user adds an item to their cart // this should be run after it is confirmed the user has no active orders
    public void generateOrderTable(int user_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("INSERT INTO ordertable(user_id, Order_Date, Status) VALUES(?,?,?)");
        st.setInt(1, user_id);
        st.setDate(2, java.sql.Date.valueOf("2024-05-05"));
        st.setString(3, "active");
        st.executeUpdate(); 
    }

    // returns true if user has an active order
    public boolean hasActiveOrder(int user_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT Status FROM ordertable WHERE user_id = ?");
        st.setInt(1, user_id);
        ResultSet result = st.executeQuery();
        
        if (result.next()) {
            do {
            String status = result.getString("Status");
            if (status.equals("active")) {
                return true; 
                }
            } while (result.next());
        }
        return false; 
    }

    // creates orderlineitem and adds it to active order // this is always run when the user clicks add to cart
    public void generateOrderLineItem(int product_id, int user_id, int price) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT order_id FROM ordertable WHERE user_id = ? AND Status = ?");
        st.setInt(1, user_id); 
        st.setString(2, "active"); 
        ResultSet result = st.executeQuery();
        int order_id = result.getInt("order_id"); // get user's ordertableID (order_id) of their active order
    
        PreparedStatement st2 = con.prepareStatement("INSERT INTO orderlineitem(order_id, product_id, Quantity, OrderLineItem_Price) VALUES(?,?,?,?)");
        st2.setInt(1, order_id);
        st2.setInt(2, product_id);
        st2.setInt(3, 1);
        st2.setDouble(4, price);
        st2.executeUpdate(); 
    }

    // use this method to increment quantity by 1 // this is used in cart view
    public void incrementQuantity(int product_id, int user_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT order_id FROM ordertable WHERE user_id = ? AND Status = ?");
        st.setInt(1, user_id); 
        st.setString(2, "active"); 
        ResultSet result = st.executeQuery();
        int order_id = result.getInt("order_id"); // get user's ordertableID (order_id)


        PreparedStatement st2 = con.prepareStatement("UPDATE orderlineitem SET Quantity = Quantity + 1 WHERE order_id = ? AND product_id = ?");
        st2.setInt(1, order_id);
        st2.setInt(2, product_id);
        st2.executeUpdate();
    } 

    // decrease quantity by 1 (as long as its not 0) // this is used in cart view
    public void decrementQuantity(int product_id, int user_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT order_id FROM ordertable WHERE user_id = ? AND Status = ?");
        st.setInt(1, user_id);
        st.setString(2, "active");
        ResultSet result = st.executeQuery();
        if (result.next()) {
            int order_id = result.getInt("order_id"); 
    
            // Update quantity
            PreparedStatement st2 = con.prepareStatement("UPDATE orderlineitem SET Quantity = CASE WHEN Quantity > 0 THEN Quantity - 1 ELSE 0 END WHERE order_id = ? AND product_id = ?");
            st2.setInt(1, order_id);
            st2.setInt(2, product_id);
            st2.executeUpdate();
        }
    }

    // sets orderstatus to ordered // this should be run once the user clicks order in cart view
    public void completeOrder(int user_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT order_id FROM ordertable WHERE user_id = ? AND Status = ?");
        st.setInt(1, user_id); 
        st.setString(2, "active"); 
        ResultSet result = st.executeQuery();
        int order_id = result.getInt("order_id");

        PreparedStatement st2 = con.prepareStatement("UPDATE ordertable SET Status = ? WHERE order_id = ?");
        st2.setString(1, "ordered");
        st2.setInt(2, order_id);
        st2.executeUpdate();
    } 

    // deletes order // this should be run when user clicks delete button in cart view
    public void deleteOrder(int user_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT order_id FROM ordertable WHERE user_id = ? AND Status = ?");
        st.setInt(1, user_id); 
        st.setString(2, "active"); 
        ResultSet result = st.executeQuery();
        int order_id = result.getInt("order_id");

        // delete item from table 
        PreparedStatement deleteSt = con.prepareStatement("DELETE FROM orderlineitem WHERE order_id = ?");
        deleteSt.setInt(1, order_id);
        deleteSt.executeUpdate();

        // delete entire order
        PreparedStatement deleteOrderSt = con.prepareStatement("DELETE FROM ordertable WHERE order_id = ?");
        deleteOrderSt.setInt(1, order_id);
        deleteOrderSt.executeUpdate();
    } 

    // todo: implement list functionality // double check methods sync up with the "Order.java" file as its just called order and not ordertable (and has different categories to database) 
    // check orderlineitem database syncs up with "orderlineitem.java" //  add two item pages and order history page // complete cart page
}