package uts.isd.model.dao;

import uts.isd.model.User;
import java.sql.*;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
*/

public class DBManager {

private Statement st;
   
public DBManager(Connection conn) throws SQLException {       
   st = conn.createStatement();   
}

// //Find user by email and password in the database   
// public User findUser(String email, String password) throws SQLException {       
//    //setup the select sql query string       
//    //execute this query using the statement field       
//    //add the results to a ResultSet       
//    //search the ResultSet for a user using the parameters               
//    return null;   
// }

// //Add a user-data into the database   
// public void addUser(String email, String name, String password, String gender, String favcol) throws SQLException {                   //code for add-operation       
//   st.executeUpdate("sql query");   

// }

// //update a user details in the database   
// public void updateUser( String email, String name, String password, String gender, String favcol) throws SQLException {       
//    //code for update-operation   

// }       

// //delete a user from the database   
// public void deleteUser(String email) throws SQLException{       
//    //code for delete-operation   

// }

// actively working prior to commit
// public void addCustomer(String firstName, String lastName, String email, String password, String DOB, String phoneNumber) {
//     st.executeUpdate("INSERT INTO IoTBay.Customer (Given_Name,Family_Name,Email,Password,DOB,Phone_Number) VALUES ('','h','h','h','100902',1);");
// }


 

}