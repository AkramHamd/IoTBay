package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import uts.isd.model.OrderLineItem;
import uts.isd.model.OrderTable;
import java.time.LocalDate;


public class OrderTableDAO {
    private Connection con;
    public OrderTableDAO(Connection connection) throws SQLException {
        this.con = connection;
        con.setAutoCommit(true);
    }

    // returns a list of the orderlineitems of active order // should be used in cart view
    public ArrayList<OrderLineItem> getCurrentItems(int user_id) throws SQLException {
        ArrayList<OrderLineItem> orderLineItems = new ArrayList<>();
    
        PreparedStatement st = con.prepareStatement("SELECT order_id FROM ordertable WHERE user_id = ? AND status = ?");
        st.setInt(1, user_id); 
        st.setString(2, "active"); 
        ResultSet result = st.executeQuery();
    
        while (result.next()) {
            int order_id = result.getInt("order_id");
    
            PreparedStatement st2 = con.prepareStatement("SELECT product_id, quantity, orderLineNumberPrice FROM orderlineitem WHERE order_id = ?");
            st2.setInt(1, order_id);
            ResultSet orderResult = st2.executeQuery();
    
            while (orderResult.next()) {
                int product_id = orderResult.getInt("product_id");
                int quantity = orderResult.getInt("quantity");
                double price = orderResult.getDouble("orderLineNumberPrice"); // Change getInt to getDouble for price
                
                OrderLineItem orderLineItem = new OrderLineItem(0 ,order_id, product_id, quantity, price);
                orderLineItems.add(orderLineItem);
            }
        }
    
        return orderLineItems;
    }

    // generates order table when a user adds an item to their cart // this should be run after it is confirmed the user has no active orders
    public void generateOrderTable(int user_id) throws SQLException {
        LocalDate currentDate = LocalDate.now();

        PreparedStatement st = con.prepareStatement("INSERT INTO ordertable(user_id, Order_Date, status) VALUES(?,?,?)");
        st.setInt(1, user_id);
        st.setDate(2, java.sql.Date.valueOf(currentDate));
        st.setString(3, "active");
        st.executeUpdate(); 
    }

    // returns true if user has an active order
    public boolean hasActiveOrder(int user_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT 1 FROM ordertable WHERE user_id = ? AND status = ? LIMIT 1");
        st.setInt(1, user_id);
        st.setString(2, "active");
        ResultSet result = st.executeQuery();
        
        return result.next(); 
    }

    public int getOrderId(int user_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT order_id FROM ordertable WHERE user_id = ? AND status = ?");
        st.setInt(1, user_id); 
        st.setString(2, "active"); 
        ResultSet result = st.executeQuery();
        int order_id = 0;
        if (result.next()) {
            order_id = result.getInt("order_id"); 
        }
    
        return order_id;
    }
    // creates orderlineitem and adds it to active order // this is always run when the user clicks add to cart
    public void generateOrderLineItem(int order_id, int product_id, double price) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT * FROM orderlineitem WHERE order_id = ? AND product_id = ?");
        st.setInt(1, order_id);
        st.setInt(2, product_id);
        ResultSet result = st.executeQuery();
        
        if (result.next()) { 
            updateQuantity(order_id, product_id, result.getInt("quantity") + 1);
        } else { 
            PreparedStatement insertSt = con.prepareStatement("INSERT INTO orderlineitem(order_id, product_id, quantity, orderLineNumberPrice) VALUES(?,?,?,?)");
            insertSt.setInt(1, order_id);
            insertSt.setInt(2, product_id);
            insertSt.setInt(3, 1); // Initial quantity is 1
            insertSt.setDouble(4, price);
            insertSt.executeUpdate();
        }
    }
    
    // Method to update the quantity of an existing order line item
    private void updateQuantity(int order_id, int product_id, int newQuantity) throws SQLException {
        PreparedStatement st = con.prepareStatement("UPDATE orderlineitem SET quantity = ? WHERE order_id = ? AND product_id = ?");
        st.setInt(1, newQuantity);
        st.setInt(2, order_id);
        st.setInt(3, product_id);
        st.executeUpdate();
    }

    // use this method to increment quantity by 1 // this is used in cart view
    public void incrementQuantity(int product_id, int user_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT order_id FROM ordertable WHERE user_id = ? AND status = ?");
        st.setInt(1, user_id); 
        st.setString(2, "active"); 
        ResultSet result = st.executeQuery();
        if (result.next()) { 
            int order_id = result.getInt("order_id"); 
    
            PreparedStatement st2 = con.prepareStatement("UPDATE orderlineitem SET quantity = quantity + 1 WHERE order_id = ? AND product_id = ?");
            st2.setInt(1, order_id);
            st2.setInt(2, product_id);
            st2.executeUpdate();
        }
    }

    public void decrementQuantity(int product_id, int user_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT order_id FROM ordertable WHERE user_id = ? AND status = ?");
        st.setInt(1, user_id);
        st.setString(2, "active");
        ResultSet result = st.executeQuery();
        if (result.next()) {
            int order_id = result.getInt("order_id"); 
    
            PreparedStatement st2 = con.prepareStatement("UPDATE orderlineitem SET quantity = CASE WHEN quantity > 0 THEN quantity - 1 ELSE 0 END WHERE order_id = ? AND product_id = ?");
            st2.setInt(1, order_id);
            st2.setInt(2, product_id);
            st2.executeUpdate();
    
            if (hasQuantityReachedZero(order_id, product_id)) {
                deleteOrderLineItem(order_id, product_id);
            }
        }
    }
    
    private boolean hasQuantityReachedZero(int order_id, int product_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT quantity FROM orderlineitem WHERE order_id = ? AND product_id = ?");
        st.setInt(1, order_id);
        st.setInt(2, product_id);
        ResultSet result = st.executeQuery();
        return result.next() && result.getInt("quantity") == 0;
    }
    
    private void deleteOrderLineItem(int order_id, int product_id) throws SQLException {
        PreparedStatement deleteSt = con.prepareStatement("DELETE FROM orderlineitem WHERE order_id = ? AND product_id = ?");
        deleteSt.setInt(1, order_id);
        deleteSt.setInt(2, product_id);
        deleteSt.executeUpdate();
    }

    // sets orderstatus to ordered // this should be run once the user clicks order in cart view
    public void completeOrder(int user_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT order_id FROM ordertable WHERE user_id = ? AND status = ?");
        st.setInt(1, user_id); 
        st.setString(2, "active"); 
        ResultSet result = st.executeQuery();
        if (result.next()) {
            int order_id = result.getInt("order_id");
    
            PreparedStatement st2 = con.prepareStatement("UPDATE ordertable SET status = ? WHERE order_id = ?");
            st2.setString(1, "ordered"); 
            st2.setInt(2, order_id);
            st2.executeUpdate();
        }
    }

    // deletes order // this should be run when user clicks delete button in cart view
    public void deleteOrder(int user_id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT order_id FROM ordertable WHERE user_id = ? AND status = ?");
        st.setInt(1, user_id); 
        st.setString(2, "active"); 
        ResultSet result = st.executeQuery();
        
        if (result.next()) {
            int order_id = result.getInt("order_id");
    
            // First, delete all items from the order
            PreparedStatement deleteItemsSt = con.prepareStatement("DELETE FROM orderlineitem WHERE order_id = ?");
            deleteItemsSt.setInt(1, order_id);
            deleteItemsSt.executeUpdate();
    
            // Then, delete the order itself
            PreparedStatement deleteOrderSt = con.prepareStatement("DELETE FROM ordertable WHERE order_id = ?");
            deleteOrderSt.setInt(1, order_id);
            deleteOrderSt.executeUpdate();
        }
    }

    // returns orders that are inactive (used to list "ordered" carts)
    public ArrayList<OrderTable> getInactiveOrders(int user_id) throws SQLException {
    ArrayList<OrderTable> inactiveOrders = new ArrayList<>();

    PreparedStatement st = con.prepareStatement("SELECT * FROM ordertable WHERE user_id = ? AND status <> ?");
    st.setInt(1, user_id);
    st.setString(2, "active");
    ResultSet result = st.executeQuery();

    while (result.next()) {
        int order_id = result.getInt("order_id");
        String orderDate = result.getString("Order_Date");
        String status = result.getString("status");
        
        OrderTable orderTable = new OrderTable(order_id, user_id, orderDate, status);
        inactiveOrders.add(orderTable);
    }

    return inactiveOrders;
}

// returns ordertable when given specific order_id
public OrderTable getOrder(int user_id, int order_id) throws SQLException {
    OrderTable order = null;

    PreparedStatement st = con.prepareStatement("SELECT * FROM ordertable WHERE user_id = ? AND order_id = ?");
    st.setInt(1, user_id);
    st.setInt(2, order_id);
    ResultSet result = st.executeQuery();

    if (result.next()) {
        String orderDate = result.getString("Order_Date");
        String status = result.getString("status");

        order = new OrderTable(order_id, user_id, orderDate, status);
    }

    return order;
}


    public boolean testFunction() throws SQLException {
        return true;
    }

}