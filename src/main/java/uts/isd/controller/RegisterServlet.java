package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Customer;
import uts.isd.model.dao.CustomerDAO;
import uts.isd.model.dao.LogDAO;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;

public class RegisterServlet extends HttpServlet {

    // Generate random verification code
    Random random = new Random();
    String verificationCode = Integer.toString(1000 + random.nextInt(9000)); 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String given_name = request.getParameter("given_name");
        String family_name = request.getParameter("family_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String dob = request.getParameter("dob");

        CustomerDAO customerDAO = (CustomerDAO) session.getAttribute("customerDAO");
        LogDAO logDAO = (LogDAO) session.getAttribute("logDAO");

        if (given_name.length() <= 0) {
            session.setAttribute("register_givenNameErr", "First name can't be empty");
            request.getRequestDispatcher("register.jsp").include(request, response);

        } else if (family_name.length() <= 0) {
            session.setAttribute("register_familyNameErr", "First name can't be empty");
            request.getRequestDispatcher("register.jsp").include(request, response);

        } else if (email.length() <= 0) {
            session.setAttribute("register_emailErr", "Email can't be empty");
            request.getRequestDispatcher("register.jsp").include(request, response);

        } else if (password.length() <= 5) {
            session.setAttribute("register_passwordErr", "Password needs to be greater than 5 letters");
            request.getRequestDispatcher("register.jsp").include(request, response);

        } else if (phone.length() <= 0) {
            session.setAttribute("register_phoneErr", "Phone number can't be empty");
            request.getRequestDispatcher("register.jsp").include(request, response);

        } else if (dob.length() <= 0) {
            session.setAttribute("register_dobErr", "Date of birth can't be empty");
            request.getRequestDispatcher("register.jsp").include(request, response);

        } else {
            try {
                if (customerDAO.emailExists(email)) {
                    session.setAttribute("register_email_exists", "Email already exists");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } else {
                    Customer customer = customerDAO.addCustomer(given_name, family_name, email, password, phone, dob, verificationCode, "false");
                    logDAO.addLog(customer.getCustomer_id(), "register");
                    session.setAttribute("customer", customer);
                    sendRegistrationEmail(email);

                    response.sendRedirect("DashboardServlet");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    // Method to send email
    public void sendRegistrationEmail(String toEmail) {
        final String fromEmail = "iotbay35@gmail.com";
        final String password = "ryyg tski sebc cvxc";
    
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Registration Confirmation");
            msg.setText("Thank you for registering! \n\n Your verification code is: " + verificationCode + "\n\nPlease enter this code on your dashboard to verify your account.");
    
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
