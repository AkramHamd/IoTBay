package uts.isd.model.dao;

import java.sql.Connection;

/** 
* Super class of DAO classes that stores the database information 
*  
*/

public abstract class DB {   

protected String URL = "jdbc:mysql://localhost:3306/";//replace this string with your jdbc:derby local host url   
protected String db = "iotbay";//name of the database   
protected String dbuser = "root";//db root user   
protected String dbpass = "uts123"; //db root password   
protected String driver = "com.mysql.cj.jdbc.Driver"; //jdbc client driver - built in with NetBeans   
protected Connection conn; //connection null-instance to be initialized in sub-classes
}
