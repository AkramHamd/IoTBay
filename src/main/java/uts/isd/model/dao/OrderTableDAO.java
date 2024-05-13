	package uts.isd.model.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.time.LocalDateTime;
	import java.util.ArrayList;

	import uts.isd.model.User;
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
		// get customerID from page
		public void generateOrderTable(int customerID, String status) throws SQLException {
			PreparedStatement st = con.prepareStatement("INSERT INTO ordertable(Customer_ID, Order_Date, Status) VALUES(?,?,?)");
			st.setInt(1, customerID);
			st.setDate(2, java.sql.Date.valueOf("2024-05-05"));
			st.setString(3, status);
			st.executeUpdate(); 
		}


		public void generateOrderLineItem(int productID, int customerID, int price) throws SQLException {
			PreparedStatement st = con.prepareStatement("SELECT Order_ID FROM ordertable WHERE Customer_ID = ? AND Status = ?");
			st.setInt(1, customerID); 
			st.setString(2, "pending"); 
			ResultSet result = st.executeQuery();
			int orderID = result.getInt("Order_ID"); // get customer's ordertableID (Order_ID)
		
			PreparedStatement st2 = con.prepareStatement("INSERT INTO orderlineitem(Order_ID, Product_ID, Quantity, OrderLineItem_Price) VALUES(?,?,?,?)");
			st2.setInt(1, orderID);
			st2.setInt(2, productID);
			st2.setInt(3, 1);
			st2.setInt(3, price);
			st2.executeUpdate(); 
		}

		/* use this method to increment quantity by 1
		public void incrementQuantity(int productID, int customerID) throws SQLException {
			PreparedStatement st = con.prepareStatement("SELECT Order_ID FROM ordertable WHERE Customer_ID = ? AND Status = ?");
			st.setInt(1, customerID); 
			st.setString(2, "pending"); 
			ResultSet result = st.executeQuery();
			int orderID = result.getInt("Order_ID"); // get customer's ordertableID (Order_ID)
			
		} */

		// need another method to decrease quantity by 1 and if it is at 0 leave at 0
	}
