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
		productFetchReadSt = connection.prepareStatement("SELECT product_id, product_name, product_brand, product_description, product_img, product_price, product_special_price, product_on_special, product_stock, product_order_qty FROM PRODUCT");
	}
	//create user
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
	
	//fetch uesr
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
			Integer product_ID = rs.getInt(1);
			String productName = rs.getString(2);
			String productBrand = rs.getString(3);
			String productDescription = rs.getString(4);
			String productImage = rs.getString(5);
			Integer productPrice = rs.getInt(6);
			Integer specialPrice = rs.getInt(7);
			Boolean productOnSpecial = rs.getBoolean(8);
			Integer productStock = rs.getInt(9);
			//setting every product value to match the data base
			//all of these objects being created can be accessed through the array "products"
			Product p = new Product();
			p.setProductId(product_ID);
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

	//create product
	public void createProduct(
		String product_name,
		String product_brand,
		String product_description,
		String product_img,
		Double product_price,
		Double product_special_price,
		Boolean product_on_special,
		Integer product_stock,
		Integer product_order_qty
		) throws SQLException {
		PreparedStatement st = con.prepareStatement("INSERT INTO Product(product_name, product_brand, product_description, product_img, product_price, product_special_price, product_on_special, product_stock, product_order_qty ) VALUES(?,?,?,?,?,?,?,?,?)");
		st.setString(1, product_name); //replacing ? with variables
		st.setString(2, product_brand);
		st.setString(3, product_description);
		st.setString(4, product_img);
		st.setDouble(5, product_price);
		st.setDouble(6, product_special_price);
		st.setBoolean(7, product_on_special);
		st.setInt(8, product_stock);
		st.setInt(9, product_order_qty);

		st.executeUpdate(); // executes the query
	}
	public void deleteProduct(Integer product_ID) throws SQLException {
		//needed to use string contactation here because ? and st.setint wasnt working.
		PreparedStatement st = con.prepareStatement("DELETE FROM Product WHERE product_id="+product_ID);

		st.executeUpdate(); // executes the query
	}

	public void truncateTable(Integer passcode, String tableToBeTruncated) throws SQLException {
		//Please be careful witht his function and make sure it is only used to clear the table before populating it for
		//'starting' the project
		if(passcode == 1212) {
			PreparedStatement st = con.prepareStatement("TRUNCATE TABLE " + tableToBeTruncated);
			st.executeUpdate();
		} else {
			System.out.println("Passcode wrong, please contact Brad for help");
		}
	}
}
