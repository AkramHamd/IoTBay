package uts.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import uts.isd.model.Customer;
import uts.isd.model.Product;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.CustomerDAO;
import uts.isd.model.dao.ProductDAO;

public class DAOTest {
    private DBConnector connector;
    private Connection conn;
    private CustomerDAO customerDAO;
    private ProductDAO productDAO;

    public DAOTest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        customerDAO = new CustomerDAO(conn);
        productDAO = new ProductDAO(conn);
    }

    @Test
    public void testConnection() throws SQLException {
        assertNotNull(conn);
    }

    @Test
    public void testSelectUsers() throws SQLException {
        ArrayList<Customer> users = customerDAO.fetchAllCustomers();
        assertTrue(users.size() > 0);
    }
    @Test
    public void testCreateUsers() throws SQLException {
        customerDAO.addCustomer("test_given", "test_last", "test_give@email.comer", "123456", "0422 222 222", "1999-01-01", "1234", "false");	
    }
    //Feature 2 Tests

    //select products
    @Test
    public void testSelectProducts() throws SQLException {
        ArrayList<Product> products = productDAO.fetchProducts();
        assertTrue(products.size() > 0);
        // System.out.println("---------");
        // System.out.println(products.get(4).getProductId());
        // System.out.println(products.get(4).getProductName());
        // System.out.println("---------");
    }

    @Test
    public void testSpecificProduct() throws SQLException {
        Product gnest = productDAO.selectSpecificProduct(2);
        // System.out.println("Expecting 'Nest' but got: " + gnest.getProductName());
        assertEquals(gnest.getProductName(), "Nest");
    }

    //create product
    @Test
    public void testCreateProducts() throws SQLException {
        productDAO.createProduct("MVN Test product", "Testers", "This is a test description", null, 1.23d, 0.00d, false, 30, 10);
    }

    //delete product
    @Test
    public void testDeleteProducts() throws SQLException {
        ArrayList<Product> products;
        products = productDAO.fetchProducts();
        Integer productOriginalSize = products.size();
        // System.out.println("Old list size: " + products.size());
        productDAO.deleteProduct(products.get(products.size()-1).getProductId());
        products = productDAO.fetchProducts();
        // System.out.println("New list size: " + products.size());
        assertTrue(products.size() < productOriginalSize);
        for(Product product : productDAO.fetchProducts()) {
            if(product.getProductName() == "MVN Test product") {
                productDAO.deleteProduct(product.getProductId());
            }
            System.out.println(product.getProductId());
        }
    }

    //complex create/select/delete/truncate product test
    @Test
    public void testAllFunctionsProducts() throws SQLException {
        // productDAO.truncateTable(1212, "product");
        // ArrayList<Product> products;
        // productDAO.createProduct("TesterProduct", "Testers", "This is a description", "null", 1.25d, 0.00d, false, 10, 10);
        // products = productDAO.fetchProducts();
        // if(products.size()>0) {
        //     productDAO.deleteProduct(1);
        // } else {
        //     System.out.println("error");
        // }
        // products = productDAO.fetchProducts();
        // assertTrue(products.size() == 0);
    }

    //Setting up base products through test
    @Test
    public void productSetUp() throws SQLException {
    //    productDAO.setUpProduct();
    //    ArrayList<Product> products = productDAO.fetchProducts();
    //    assertTrue(products.size() == 2);
       
        // ArrayList<Product> products;
        // productDAO.truncateTable(1212, "product");
        // productDAO.createProduct(
        //     "Nest Mini Smart Speaker",
        //     "Google",
        //     "The Google Nest Mini Smart Speaker comes with powerful, rich bass for great sounding music. And with the Google Assistant it’s also helpful around the house, easily set timers, alarms or ask Google a question. Plus, control hundreds of compatible smart devices, like lights, smart plugs and TVs**. Google Nest Mini has also been designed with the environment in mind, with its fabric covering made from recycled plastic bottles.",
        //     "googlenest",
        //     69.99d,
        //     0.00d,
        //     false,
        //     5,
        //     1);
        // products = productDAO.fetchProducts();
        // assertTrue(products.size() == 1);
        // for(Product product : products) {
        //     System.out.println(product.getProductName());
        // }
    }
}