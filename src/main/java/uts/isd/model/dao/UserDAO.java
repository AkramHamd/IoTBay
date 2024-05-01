package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import uts.isd.model.User;

public class UserDAO {
	private PreparedStatement readSt;
	private String readQuery = "SELECT id, FirstName, LastName FROM account";

	public UserDAO(Connection connection) throws SQLException {
		connection.setAutoCommit(true);
		readSt = connection.prepareStatement(readQuery);
	}

	public ArrayList<User> fetchUsers() throws SQLException {
		ResultSet rs = readSt.executeQuery();

		ArrayList<User> users = new ArrayList<User>();
		while (rs.next()) { //loop through every row in the rs variable
			String firstName = rs.getString(2); //column 1 is id, fn is 2, ln is 3
			String lastName = rs.getString(3);
			User u = new User();
			u.setFirstName(firstName);
			u.setLastName(lastName);


			System.out.println(u.getFirstName());

			users.add(u);
		}

		return users;
	}
}