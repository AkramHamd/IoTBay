package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import uts.isd.model.User;
import uts.isd.model.Product;

public class UserDAO {
	private Connection con;
	private PreparedStatement userFetchReadSt;
	private PreparedStatement productFetchReadSt;

	public UserDAO(Connection connection) throws SQLException {
		//initiates connection to db
		this.con = connection;
		//prevents needing confirmation before making changes to db
		connection.setAutoCommit(true);
		//preparing predetermined statement
		userFetchReadSt = connection.prepareStatement("SELECT given_name, family_name, Password, Phone_number, Email FROM user");
		productFetchReadSt = connection.prepareStatement("SELECT product_name, product_brand, product_description, product_img, product_price, product_special_price, product_on_special, product_stock, product_order_qty FROM PRODUCT");
	}

	public void createUser(String email, String firstname, String lastname, String password, String dob, String phone) throws SQLException {
		PreparedStatement st = con.prepareStatement("INSERT INTO USER(given_name, family_name, password, email, dob, phone_number) VALUES(?,?,?,?,?,?)");
		st.setString(1, firstname); //replacing ? with variables
		st.setString(2, lastname);
		st.setString(3, password);
		st.setString(4, email);
		st.setString(5, dob);
		st.setString(6, phone);

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
	
	//product fetch
	public ArrayList<Product> fetchProducts() throws SQLException {
		ResultSet rs = productFetchReadSt.executeQuery();

		ArrayList<Product> products = new ArrayList<Product>();
		while (rs.next()) { //loop through every row in the rs variable
			String productName = rs.getString(1);
			String productBrand = rs.getString(2);
			String productDescription = rs.getString(3);
			String productImage = rs.getString(4);
			Integer productPrice = rs.getInt(5);
			Integer specialPrice = rs.getInt(6);
			Boolean productOnSpecial = rs.getBoolean(7);
			Integer productStock = rs.getInt(8);
			//setting every product value to match the data base
			//all of these objects being created can be accessed through the array "products"
			Product p = new Product();
			p.setProductName(productName);
			p.setProductBrand(productBrand);
			p.setProductDescription(productDescription);
			p.setProductImg(productImage);
			p.setProductPrice(productPrice);
			p.setProductSpecialPrice(specialPrice);
			p.setProductOnSpecial(productOnSpecial);
			p.setProductStock(productStock);

			System.out.println(p.getProductName());
			//adding the just set up product (p) to the list products.
			products.add(p);
		}
		return products;
	}
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
