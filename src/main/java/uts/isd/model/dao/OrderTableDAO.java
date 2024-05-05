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


/* 
	// this method will get the ordertableID of the ordertable that matches the product page and the signed in user
	public int fetchOrderTableID(int ProductID, int UserID) throws SQLException {
		// initiate all dbs 
		// from productid get all the orderlineitems with that product inside, from that list get a list of all the ordertables with the orderlineitems inside, 
		// then return an orderlineitem that 
	}
	// check if obtained ordertable has an orderline item with pages product_ID if it doesn't generate an orderline item:

	public void generateOrderLineItem(int orderID, int productID, int quantity, int price) throws SQLException {
		PreparedStatement st = con.prepareStatement("INSERT INTO ordertable(Customer_ID, Order_Date, Status) VALUES(?,?,?)");
		st.setInt(1, customerID);
		st.setDate(2, java.sql.Date.valueOf("2024-05-05"));
		st.setString(3, status);
		st.executeUpdate(); 
	}	

	// if it does increment the orderline item quantity by 1:

*/
}
