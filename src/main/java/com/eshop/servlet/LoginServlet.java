package com.eshop.servlet;

import com.eshop.UserService;
import com.eshop.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us = new UserService();
        response.setContentType("text/html;charset=UTF-8");
        String s1 = request.getParameter("login");
        String s2 = request.getParameter("password");
        System.out.println(s1 + " " + s2);
        try {
//login = email???
            User realUser = us.getUserInformation(s1);
            System.out.println("realUser=" + realUser);
            if (realUser != null) {
                System.out.println("VOt:" + realUser.getPassword());
            }
            if (realUser != null && realUser.getPassword().equals(s2)) {
                HttpSession session = request.getSession();
                System.out.println("IdSessii="+session.getId());
                session.setAttribute("user", realUser);
                System.out.println("Login uspeshen");
                System.out.println(session.getAttribute("user").getClass());
                response.sendRedirect("/MyShop/service");
            } else {
                response.sendRedirect("/MyShop/login.jsp?error=1");
                System.out.println("login ne vypolnen");
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

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
