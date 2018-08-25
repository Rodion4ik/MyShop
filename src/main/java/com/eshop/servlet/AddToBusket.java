package com.eshop.servlet;

import com.eshop.MyShopService;
import com.eshop.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author Samsung
 */
@WebServlet(name = "AddToBusket", urlPatterns = {"/AddToBusket"})
public class AddToBusket extends HttpServlet {

    private MyShopService mshs = new MyShopService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Kontroller AddToBusket.processRequest>>");
        String productId = request.getParameter("id");
         HttpSession sess = request.getSession();
       
        String idSessii  =sess.getId();
        try {

            mshs.addToBusket(Integer.parseInt(productId), getUserId(request), 1);

            response.sendRedirect("/MyShop/ProductSrv?id=" + request.getParameter("cid"));
        } catch (SQLException ex) {
            try {
                mshs.addToBusket(Integer.parseInt(productId), getUserId(request), 1);
            } catch (SQLException ex1) {
                Logger.getLogger(AddToBusket.class.getName()).log(Level.SEVERE, null, ex1);
                System.out.println("Oshibka dobavleniya v korzinu NoName");
            }
            ex.printStackTrace();
        }
    }

    private int getUserId(HttpServletRequest request) {

//    как получить объект из сесисии  
        HttpSession sess = request.getSession();
        User user = (User) sess.getAttribute("user");
        int user_id = user.getId();
        return user_id;
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
