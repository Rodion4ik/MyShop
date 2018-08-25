/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//  servlet dlya vybora iz bazy produktov zadannoi po ID categorii
package com.eshop.servlet;

import com.eshop.MyShopService;
import com.eshop.model.Product;
import com.eshop.model.ProductCategory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samsung
 */
@WebServlet(name = "ProductsServlet", urlPatterns = {"/ProductSrv"})
public class ProductsServlet extends HttpServlet {

    MyShopService mshs2 = new MyShopService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String param = request.getParameter("id");
            if (param != null) {
                ProductCategory prodCat = mshs2.getCategoryWithProducts(Integer.parseInt(param));

               // System.out.println("kolProd=" + prod.size());
                
                request.setAttribute("id", param);
                request.setAttribute("prodCat", prodCat);
            } else {
                System.out.println("id kategorii otsutstvuet");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("products.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
//dz - dodelat i prichesat 
