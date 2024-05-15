/*                                                      */

//          Created for ISD 41025 Assignment Two        //
//          This file is a part of feature Two          //
//          Authored by Bradley Madgwick 14249522       //

/*                                                      */
// git push origin head:brad-fixing-his-fup
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import uts.isd.model.Product;

public class ProductDAO {
	private Connection con;
	private PreparedStatement productFetchReadSt;
	// private PreparedStatement productSelectSpecificStatement;

	public ProductDAO(Connection connection) throws SQLException {
		//initiates connection to db
		this.con = connection;
		//prevents needing confirmation before making changes to db
		connection.setAutoCommit(true);
		//preparing predetermined statement
		productFetchReadSt = connection.prepareStatement("SELECT product_id, product_name, product_brand, product_description, product_img, product_price, product_special_price, product_on_special, product_stock, product_order_qty, product_Short_Description FROM PRODUCT");
		
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
            Integer productOrderStock = rs.getInt(10);
            String productShortDesc = rs.getString(11);
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
            p.setProductOrderQty(productOrderStock);
            p.setProductShortDesc(productShortDesc);

			// System.out.println(p.getProductName());
			//adding the just set up product (p) to the list products.
			products.add(p);
		}
		return products;
	}

	//select specific product
	public Product selectSpecificProduct(Integer product_ID) throws SQLException {
		// Integer product_ID = Integer.parseInt(product_IDs);
		PreparedStatement st = con.prepareStatement("SELECT * FROM product WHERE product_id=?");
    st.setInt(1, product_ID); // Set product_ID as parameter
    ResultSet rs = st.executeQuery();
	if (rs.next()) { // Check if result set is not empty
        Integer productId = rs.getInt("product_id");
        String productName = rs.getString("product_name");
        String productBrand = rs.getString("product_brand");
        String productDescription = rs.getString("product_description");
        String productImage = rs.getString("product_img");
        Double productPrice = rs.getDouble("product_price");
        Double specialPrice = rs.getDouble("product_special_price");
        Boolean productOnSpecial = rs.getBoolean("product_on_special");
        Integer productStock = rs.getInt("product_stock");
		Integer productOnOrder = rs.getInt("product_order_qty");
        String productShortDesc = rs.getString("product_short_description");

        // Create and return Product object
        return new Product(productId, productName, productBrand, productDescription, productImage,
                productPrice, specialPrice, productOnSpecial, productStock, productOnOrder, productShortDesc);
		} 
		else {
			return null;
		}
	}
	//select specific product
	public ArrayList<Product> selectArrayProduct(ArrayList<Integer> productIDList) throws SQLException {
		ArrayList<Product> products = new ArrayList<>();
		for(Integer product_ID : productIDList) {
			PreparedStatement st = con.prepareStatement("SELECT * FROM product WHERE product_id=?");
			st.setInt(1, product_ID); // Set product_ID as parameter
			ResultSet rs = st.executeQuery();
			if (rs.next()) { // Check if result set is not empty
				Integer productId = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				String productBrand = rs.getString("product_brand");
				String productDescription = rs.getString("product_description");
				String productImage = rs.getString("product_img");
				Double productPrice = rs.getDouble("product_price");
				Double specialPrice = rs.getDouble("product_special_price");
				Boolean productOnSpecial = rs.getBoolean("product_on_special");
				Integer productStock = rs.getInt("product_stock");
				Integer productOnOrder = rs.getInt("product_order_qty");
				String productShortDesc = rs.getString("product_short_description");
				Product p = new Product(productId, productName, productBrand, productDescription, productImage,
				productPrice, specialPrice, productOnSpecial, productStock, productOnOrder, productShortDesc);
				products.add(p);
			} 
			else {
				products.add(null);
			}
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
		Integer product_order_qty,
        String productShortDesc
		) throws SQLException {
		PreparedStatement st = con.prepareStatement("INSERT INTO Product(product_name, product_brand, product_description, product_img, product_price, product_special_price, product_on_special, product_stock, product_order_qty, product_Short_Description) VALUES(?,?,?,?,?,?,?,?,?,?)");
		st.setString(1, product_name); //replacing ? with variables
		st.setString(2, product_brand);
		st.setString(3, product_description);
		st.setString(4, product_img);
		st.setDouble(5, product_price);
		st.setDouble(6, product_special_price);
		st.setBoolean(7, product_on_special);
		st.setInt(8, product_stock);
		st.setInt(9, product_order_qty);
        st.setString(10, productShortDesc);

		st.executeUpdate(); // executes the query
	}

	//update product
	public void updateProduct(
		Integer product_id,
		String product_name,
		String product_brand,
		String product_description,
		String product_img,
		Double product_price,
		Double product_special_price,
		Boolean product_on_special,
		Integer product_stock,
		Integer product_order_qty,
		String productShortDesc
	) throws SQLException {
		PreparedStatement st = con.prepareStatement("UPDATE Product SET product_name=?, product_brand=?, product_description=?, product_img=?, product_price=?, product_special_price=?, product_on_special=?, product_stock=?, product_order_qty=?, product_Short_Description=? WHERE product_id=?");
		st.setString(1, product_name);
		st.setString(2, product_brand);
		st.setString(3, product_description);
		st.setString(4, product_img);
		st.setDouble(5, product_price);
		st.setDouble(6, product_special_price);
		st.setBoolean(7, product_on_special);
		st.setInt(8, product_stock);
		st.setInt(9, product_order_qty);
		st.setString(10, productShortDesc);
		st.setInt(11, product_id);
	
		st.executeUpdate();
	}

	public void deleteProduct(Integer product_ID) throws SQLException {
		//needed to use string contactation here because ? and st.setint wasnt working.
		PreparedStatement st = con.prepareStatement("DELETE FROM Product WHERE product_id="+product_ID);

		st.executeUpdate(); // executes the query
	}
	// public void truncateTable(Integer passcode, String tableToBeTruncated) throws SQLException {
	// 	//Please be careful with this function and make sure it is only used to clear the table before populating it for
	// 	//'starting' the project
	// 	if(passcode == 1212) {
	// 		PreparedStatement st = con.prepareStatement("TRUNCATE TABLE " + tableToBeTruncated);
	// 		st.executeUpdate();
	// 	} else {
	// 		System.out.println("Passcode wrong, please contact Brad for help");
	// 	}
	// }
	
	// public void setUpProduct() throws SQLException {
    //     truncateTable(1212, "product");
    //     createProduct(
    //         "Nest Mini Saaamart Speaker",
    //         "Google",
    //         "The Google Nest Mini Smart Speaker comes with powerful, rich bass for great sounding music. And with the Google Assistant it’s also helpful around the house, easily set timers, alarms or ask Google a question. Plus, control hundreds of compatible smart devices, like lights, smart plugs and TVs**. Google Nest Mini has also been designed with the environment in mind, with its fabric covering made from recycled plastic bottles.",
    //         "googlenest",
    //         69.99d,
    //         0.00d,
    //         false,
    //         5,
    //         1);
	// 	createProduct(
    //         "Nesaat Mini Saaamart Speaker",
    //         "Google",
    //         "The Google Nest Mini Smart Speaker comes with powerful, rich bass for great sounding music. And with the Google Assistant it’s also helpful around the house, easily set timers, alarms or ask Google a question. Plus, control hundreds of compatible smart devices, like lights, smart plugs and TVs**. Google Nest Mini has also been designed with the environment in mind, with its fabric covering made from recycled plastic bottles.",
    //         "googlenest",
    //         69.99d,
    //         0.00d,
    //         false,
    //         5,
    //         1);
	// 	for(Product product : fetchProducts()) {
	// 		System.out.println("Product: " + product.getProductName());
	// 	}
	// }
}