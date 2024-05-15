package uts.isd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.ProductDAO;

public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Integer product_id = Integer.parseInt(request.getParameter("product_id"));
        String product_name = request.getParameter("product_name");
        String product_brand = request.getParameter("product_brand");
        String product_description = request.getParameter("product_description");
        String product_img = request.getParameter("product_img");
        Double product_price = Double.valueOf(request.getParameter("product_price"));
        Double product_special_price = Double.valueOf(request.getParameter("product_special_price"));
        Boolean product_on_special = Boolean.valueOf(request.getParameter("product_on_special"));
        int product_stock = Integer.parseInt(request.getParameter("product_stock"));
        int product_order_qty = Integer.parseInt(request.getParameter("product_order_qty"));
        String product_short_description = request.getParameter("product_short_description");

        ProductDAO productDAO = (ProductDAO) session.getAttribute("productDAO");

        session.setAttribute("productDAO", productDAO);

        try {
            productDAO.updateProduct(product_id, product_name, product_brand, product_description, product_img, product_price, product_special_price, product_on_special, product_stock, product_order_qty, product_short_description);
            response.sendRedirect("DashboardServlet");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
