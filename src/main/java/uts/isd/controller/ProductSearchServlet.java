/*                                                      */

//          Created for ISD 41025 Assignment Two        //
//          This file is a part of feature Two          //
//          Authored by Bradley Madgwick 14249522       //

/*                                                      */
package uts.isd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.Product;
import uts.isd.model.dao.ProductDAO;

public class ProductSearchServlet extends HttpServlet {
    public ArrayList<Integer> productID = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductDAO productDAO = (ProductDAO) session.getAttribute("productDAO");

        String searchQuery = request.getParameter("searchQuery");
        String[] searchQueryList = searchQuery.split(" ");
        try {
            ArrayList<Product> products = productDAO.fetchProducts();
            for(Product product : products) {
                for(String sQuery : searchQueryList) {
                    String pname = product.getProductName();
                    String bname = product.getProductBrand();
                    ArrayList<String> productsBrands = new ArrayList<>();
                    String[] pnameList = pname.split(" ");
                    String[] bnameList = bname.split(" ");
                    for(String pNames : pnameList) {
                        productsBrands.add(pNames);
                    }
                    for(String bNames : bnameList) {
                        productsBrands.add(bNames);
                    }
                    for(String pnameSplit : productsBrands) {
                        if(sQuery.toLowerCase().equals(pnameSplit.toLowerCase())) {
                            productID.add(product.getProductId());
                        }
                    }
                }
            }
            if (productID != null) {
                System.out.println("Product ids that match: " + productID);
                session.setAttribute("searchIDResult", productID);
                request.getRequestDispatcher("product_search_result.jsp").forward(request, response);
                productID.clear();
            } else {
                System.out.println("No matching id's");
                productID.add(0);
                session.setAttribute("searchIDResult", productID);
                request.getRequestDispatcher("product_search_result.jsp").forward(request, response);
                productID.clear();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}