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
		private PreparedStatement userPreparedStatement;
		private PreparedStatement orderLineItemPreparedStatement;
		private PreparedStatement orderTablePreparedStatement;


		public 	OrderTableDAO(Connection connection) throws SQLException {
			//initiates connection to db
			this.con = connection;
			//prevents needing confirmation before making changes to db
			connection.setAutoCommit(true);
			//preparing predetermined statement
			userPreparedStatement = connection.prepareStatement("SELECT firstname, lastname, Password, Phone, Email FROM account");
			orderLineItemPreparedStatement = connection.prepareStatement("SELECT Order_ID, Product_ID, Quantity, OrderLineItem_Price FROM orderlineitem");
			orderTablePreparedStatement = connection.prepareStatement("SELECT Order_ID, Customer_ID, Order_Date, Status FROM ordertable");
		}


		// returns a list of the orderlineitems of active order // should be used in cart view
		public ArrayList<OrderLineItem> getCurrentItems(int customerID) throws SQLException {
    	ArrayList<OrderLineItem> orderLineItems = new ArrayList<>();

		PreparedStatement st = con.prepareStatement("SELECT Order_ID FROM ordertable WHERE Customer_ID = ? AND Status = ?");
		st.setInt(1, customerID); 
		st.setString(2, "active"); 
		ResultSet result = st.executeQuery();
		int orderID = result.getInt("Order_ID");

		PreparedStatement st2 = con.prepareStatement("SELECT Product_ID, Quantity, OrderLineItem_Price FROM orderlineitem WHERE Order_ID = ?");
        st2.setInt(1, orderID);
        ResultSet orderResult = st2.executeQuery();

		while (orderResult.next()) {
            int productID = orderResult.getInt("Product_ID");
            int quantity = orderResult.getInt("Quantity");
            double price = orderResult.getInt("OrderLineItem_Price");
            
            OrderLineItem orderLineItem = new OrderLineItem(0 ,orderID, productID, quantity, price);
            orderLineItems.add(orderLineItem);
        }
		return orderLineItems;
		}


		// generates order table when a user adds an item to their cart // this should be run after it is confirmed the user has no active orders
		public void generateOrderTable(int customerID) throws SQLException {
			PreparedStatement st = con.prepareStatement("INSERT INTO ordertable(Customer_ID, Order_Date, Status) VALUES(?,?,?)");
			st.setInt(1, customerID);
			st.setDate(2, java.sql.Date.valueOf("2024-05-05"));
			st.setString(3, "active");
			st.executeUpdate(); 
		}

		// returns true if user has an active order
		public boolean hasActiveOrder(int customerID) throws SQLException {
			PreparedStatement st = con.prepareStatement("SELECT Status FROM ordertable WHERE Customer_ID = ?");
			st.setInt(1, customerID);
			ResultSet result = st.executeQuery();
			
			while (result.next()) {
				String status = result.getString("Status");
				if (status.equals("active")) {
					return true; 
				}
			}
			return false; 
		}

		// creates orderlineitem and adds it to active order // this is always run when the user clicks add to cart
		public void generateOrderLineItem(int productID, int customerID, int price) throws SQLException {
			PreparedStatement st = con.prepareStatement("SELECT Order_ID FROM ordertable WHERE Customer_ID = ? AND Status = ?");
			st.setInt(1, customerID); 
			st.setString(2, "active"); 
			ResultSet result = st.executeQuery();
			int orderID = result.getInt("Order_ID"); // get customer's ordertableID (Order_ID) of their active order
		
			PreparedStatement st2 = con.prepareStatement("INSERT INTO orderlineitem(Order_ID, Product_ID, Quantity, OrderLineItem_Price) VALUES(?,?,?,?)");
			st2.setInt(1, orderID);
			st2.setInt(2, productID);
			st2.setInt(3, 1);
			st2.setDouble(4, price);
			st2.executeUpdate(); 
		}

		// use this method to increment quantity by 1 // this is used in cart view
		public void incrementQuantity(int productID, int customerID) throws SQLException {
			PreparedStatement st = con.prepareStatement("SELECT Order_ID FROM ordertable WHERE Customer_ID = ? AND Status = ?");
			st.setInt(1, customerID); 
			st.setString(2, "active"); 
			ResultSet result = st.executeQuery();
			int orderID = result.getInt("Order_ID"); // get customer's ordertableID (Order_ID)


			PreparedStatement st2 = con.prepareStatement("UPDATE orderlineitem SET Quantity = Quantity + 1 WHERE Order_ID = ? AND Product_ID = ?");
        	st2.setInt(1, orderID);
        	st2.setInt(2, productID);
        	st2.executeUpdate();
		} 

		// decrease quantity by 1 (as long as its not 0) // this is used in cart view
		public void decrementQuantity(int productID, int customerID) throws SQLException {
			PreparedStatement st = con.prepareStatement("SELECT Order_ID FROM ordertable WHERE Customer_ID = ? AND Status = ?");
			st.setInt(1, customerID);
			st.setString(2, "active");
			ResultSet result = st.executeQuery();
			if (result.next()) {
				int orderID = result.getInt("Order_ID"); 
		
				// Update quantity
				PreparedStatement st2 = con.prepareStatement("UPDATE orderlineitem SET Quantity = CASE WHEN Quantity > 0 THEN Quantity - 1 ELSE 0 END WHERE Order_ID = ? AND Product_ID = ?");
				st2.setInt(1, orderID);
				st2.setInt(2, productID);
				st2.executeUpdate();
			}
		}

		// sets orderstatus to ordered // this should be run once the user clicks order in cart view
		public void completeOrder(int customerID) throws SQLException {
			PreparedStatement st = con.prepareStatement("SELECT Order_ID FROM ordertable WHERE Customer_ID = ? AND Status = ?");
			st.setInt(1, customerID); 
			st.setString(2, "active"); 
			ResultSet result = st.executeQuery();
			int orderID = result.getInt("Order_ID");

			PreparedStatement st2 = con.prepareStatement("UPDATE ordertable SET Status = ? WHERE Order_ID = ?");
			st2.setString(1, "ordered");
			st2.setInt(2, orderID);
			st2.executeUpdate();
		} 

		// deletes order // this should be run when user clicks delete button in cart view
		public void deleteOrder(int customerID) throws SQLException {
			PreparedStatement st = con.prepareStatement("SELECT Order_ID FROM ordertable WHERE Customer_ID = ? AND Status = ?");
			st.setInt(1, customerID); 
			st.setString(2, "active"); 
			ResultSet result = st.executeQuery();
			int orderID = result.getInt("Order_ID");

			// delete item from table 
			PreparedStatement deleteSt = con.prepareStatement("DELETE FROM orderlineitem WHERE Order_ID = ?");
			deleteSt.setInt(1, orderID);
			deleteSt.executeUpdate();

			// delete entire order
			PreparedStatement deleteOrderSt = con.prepareStatement("DELETE FROM ordertable WHERE Order_ID = ?");
			deleteOrderSt.setInt(1, orderID);
			deleteOrderSt.executeUpdate();
		} 

		// todo: implement list functionality // double check methods sync up with the "Order.java" file as its just called order and not ordertable (and has different categories to database) 
		// check orderlineitem database syncs up with "orderlineitem.java" //  add two item pages and order history page // complete cart page
	}
