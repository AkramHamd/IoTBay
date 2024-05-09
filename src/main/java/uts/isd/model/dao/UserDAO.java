package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import uts.isd.model.User;
//import uts.isd.model.Product;

public class UserDAO {
	private Connection con;
	private PreparedStatement userFetchReadSt;
	//private PreparedStatement productFetchReadSt;

	public UserDAO(Connection connection) throws SQLException {
		//initiates connection to db
		this.con = connection;
		//prevents needing confirmation before making changes to db
		connection.setAutoCommit(true);
		//preparing predetermined statement
		userFetchReadSt = connection.prepareStatement("SELECT firstname, lastname, Password, Phone, Email FROM customer");
		productFetchReadSt = connection.prepareStatement("SELECT product_name, product_brand, product_description, product_image, product_price, product_special_price, product_on_special, product_stock, product_order_qty FROM PRODUCT");
	}

	public void createUser(String email, String firstname, String password) throws SQLException {
		PreparedStatement st = con.prepareStatement("INSERT INTO Customer(firstname, password, email) VALUES(?,?,?)");
		st.setString(1, firstname); //replacing ? with variables
		st.setString(2, password);
		st.setString(3, email);
		st.executeUpdate(); // executes the query
	}

	public ArrayList<User> fetchUsers() throws SQLException {
		ResultSet rs = userFetchReadSt.executeQuery();

		ArrayList<User> users = new ArrayList<User>();
		while (rs.next()) { //loop through every row in the rs variable
			String firstname = rs.getString(1);
			String password = rs.getString(2);
			// String phone = rs.getString(3);
			String email = rs.getString(4);

			User u = new User();
			u.setFirstName(firstname);
			u.setPassword1(password);
			// u.setPhone(phone);
			u.setEmail(email);


			System.out.println(u.getFirstName());

			users.add(u);
		}

		return users;
	}
	
// 	//product fetch
// 	public ArrayList<Product> fetchProducts() throws SQLException {
// 		ResultSet rs = productFetchReadSt.executeQuery();

// 		ArrayList<Product> products = new ArrayList<Product>();
// 		while (rs.next()) { //loop through every row in the rs variable
// 			String productName = rs.getString(1);
// 			String productBrand = rs.getString(2);
// 			String productDescription = rs.getString(3);
// 			String productImage = rs.getString(4);
// 			Integer productPrice = rs.getString(5);
// 			Integer specialPrice = rs.getString(6);
// 			Boolean productOnSpecial = rs.getString(7);
// 			Integer productStock = rs.getString(8);

// 			User u = new User();
// 			u.setFirstName(firstname);
// 			u.setPassword1(password);
// 			// u.setPhone(phone);
// 			u.setEmail(email);


// 			System.out.println(u.getFirstName());

// 			users.add(u);


// 			System.out.println(u.getFirstName());

// 			users.add(u);
// 		}

// 		return users;
// 	}
// 	public void createProduct(String email, String firstname, String password) throws SQLException {
// 		PreparedStatement st = con.prepareStatement("INSERT INTO ACCOUNT(firstname, password, email) VALUES(?,?,?)");
// 		st.setString(1, firstname); //replacing ? with variables
// 		st.setString(2, password);
// 		st.setString(3, email);
// 		st.executeUpdate(); // executes the query
// 	}
}
