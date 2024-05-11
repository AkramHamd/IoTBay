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
		//Please be careful with this function and make sure it is only used to clear the table before populating it for
		//'starting' the project
		if(passcode == 1212) {
			PreparedStatement st = con.prepareStatement("TRUNCATE TABLE " + tableToBeTruncated);
			st.executeUpdate();
		} else {
			System.out.println("Passcode wrong, please contact Brad for help");
		}
	}
}
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uts.isd.model.User;

public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) throws SQLException {
        this.connection = connection;
        connection.setAutoCommit(true);
    }

    public Integer createUser(String given_name, String family_name, String email, String password, String phone, String dob, String verification_code, String is_verified, String is_staff) throws SQLException {
        String query = "INSERT INTO users (given_name, family_name, email, password, phone, dob, verification_code, is_verified, is_staff) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, given_name);
        st.setString(2, family_name);
        st.setString(3, email);
        st.setString(4, password);
        st.setString(5, phone);
        st.setString(6, dob);
        st.setString(7, verification_code);
        st.setString(8, is_verified);
        st.setString(9, is_staff);
        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        if (rs.next()) {
            int user_id = rs.getInt(1);
            return user_id;
        } else {
            return null;
        }
    }

    public User readUser(int user_id) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = ?";
        PreparedStatement st = connection.prepareStatement(query);
        st.setInt(1, user_id);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            String given_name = rs.getString(2);
            String family_name = rs.getString(3);
            String email = rs.getString(4);
            String password = rs.getString(5);
            String dob = rs.getString(6);
            String phone = rs.getString(7);
            String created_at = rs.getString(8);
            String verification_code = rs.getString(9);
            String is_verified = rs.getString(10);
            String is_staff = rs.getString(11);


            User user = new User(user_id, given_name, family_name, email, password, dob, phone, created_at, verification_code, is_verified, is_staff);
            return user;
        } else {
            return null;
        }
    }

    public ArrayList<User> readAllUsers() throws SQLException {
        String query = "SELECT * FROM users";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        
        ArrayList<User> allUsers = new ArrayList<>();
    
        while (rs.next()) {
            int user_id = rs.getInt(1);
            String given_name = rs.getString(2);
            String family_name = rs.getString(3);
            String email = rs.getString(4);
            String password = rs.getString(5);
            String dob = rs.getString(6);
            String phone = rs.getString(7);
            String created_at = rs.getString(8);
            String verification_code = rs.getString(9);
            String is_verified = rs.getString(10);
            String is_staff = rs.getString(11);

            User user = new User(user_id, given_name, family_name, email, password, dob, phone, created_at, verification_code, is_verified, is_staff);
            allUsers.add(user);
        }
    
        return allUsers;
    }

    public void updateUser(int user_id, String given_name, String family_name, String email, String password, String phone, String dob) throws SQLException {
        String query = "UPDATE users SET given_name = ?, family_name = ?, email = ?, password = ?, phone = ?, dob = ? WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, given_name);
        statement.setString(2, family_name);
        statement.setString(3, email);
        statement.setString(4, password);
        statement.setString(5, phone);
        statement.setString(6, dob);
        statement.setInt(7, user_id);
        
        statement.executeUpdate();
    }

    public void deleteUser(int user_id) throws SQLException {
        String query = "DELETE FROM users WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, user_id);
        statement.executeUpdate();
    }

    public boolean emailExists(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";
        PreparedStatement st = connection.prepareStatement(query);
        st.setString(1, email);
        ResultSet rs = st.executeQuery();
       
        if (rs.next()) {
            return rs.getInt(1) > 0;
        } else {
            return false;
        }
    }

    public Integer validateUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            int user_id = rs.getInt(1);
            return user_id;
        } else {
            return null;
        }
    }
}
