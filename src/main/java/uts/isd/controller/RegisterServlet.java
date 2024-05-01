package uts.isd.controller;

// import java.io.IOException;
// import java.sql.SQLException;

// import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;
// import javax.xml.registry.infomodel.User;

// import uts.isd.model.dao.UserDAO;

public class RegisterServlet extends HttpServlet {
    
    
    // // // tutor's code
    // @Override
    // public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 	HttpSession session = request.getSession();

	// 	String email = request.getParameter("email");
	// 	String name = request.getParameter("name");
	// 	String password = request.getParameter("password");
	// 	String phone = request.getParameter("phone");

	// 	UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

	// 	if (name.length() <= 5) {
	// 		session.setAttribute("nameErr", "The name provided was not long enough!");
	// 		request.getRequestDispatcher("register.jsp").include(request, response);
	// 	} else {
	// 		try {
	// 			userDAO.createUser(email, name, password, phone);

	// 			User user = new User();
	// 			user.setName(name);
	// 			user.setEmail(email);
	// 			user.setPassword(password);
	// 			user.setPhone(phone);
	// 			session.setAttribute("user", user);

	// 			request.getRequestDispatcher("account.jsp").include(request, response);
	// 		} catch (SQLException e) {
	// 			System.out.println(e);
	// 		}
	// 	}
	// }
}
