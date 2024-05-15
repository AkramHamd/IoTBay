    package uts.isd.controller;

    import java.io.IOException;
    import java.sql.SQLException;

    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;

    import uts.isd.model.dao.OrderTableDAO;

    public class AddToCartServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();  

            int product_id = Integer.parseInt(request.getParameter("product_id")); 
            Double productPrice = Double.valueOf(request.getParameter("productPrice")); 
            int user_id = (int) session.getAttribute("user_id"); 

            OrderTableDAO OrderTableDAO = (OrderTableDAO) session.getAttribute("OrderTableDAO"); 

            session.setAttribute("orderTableDAO", OrderTableDAO);
                    
            try {
                if (OrderTableDAO.hasActiveOrder(user_id)) {  //w
                    int order_id = OrderTableDAO.getOrderId(user_id); //w
                    //OrderTableDAO.generateOrderLineItem(order_id, 16, 29.99); //w
                    OrderTableDAO.generateOrderLineItem(order_id, product_id, productPrice); 
                } else {
                    OrderTableDAO.generateOrderTable(user_id); // w
                    int order_id = OrderTableDAO.getOrderId(user_id); //w
                    //OrderTableDAO.generateOrderLineItem(order_id, 14, 29.99); // generateOrderLineItem works perfectly when passed a delib unique product_id meaning addtocartservlet is not being passed a unique one .
                    OrderTableDAO.generateOrderLineItem(order_id, product_id, productPrice);  
                }
                response.sendRedirect("index.jsp"); 
            } catch (SQLException e) {
                e.printStackTrace(); 
            }   
        }
    }

