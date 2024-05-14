/*                                                      */

//          Created for ISD 41025 Assignment Two        //
//          This file is a part of feature Two          //
//          Authored by Bradley Madgwick 14249522       //

/*                                                      */
package uts.isd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.ProductDAO;

public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Integer product_id = Integer.parseInt(request.getParameter("product_id"));
        
        ProductDAO productDAO = (ProductDAO) session.getAttribute("productDAO");

        session.setAttribute("productDAO", productDAO);

        try {
            productDAO.deleteProduct(product_id);
            response.sendRedirect("DashboardServlet");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
