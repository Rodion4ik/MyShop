package com.eshop.servlet;

import com.eshop.MyShopService;
import com.eshop.model.Busket;
import com.eshop.model.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ViewBusket", urlPatterns = {"/ViewBusket"})
public class ViewBusket extends HttpServlet {

    MyShopService mshs = new MyShopService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        try {
            User user = (User)session.getAttribute("user");
            response.setContentType("text/html;charset=UTF-8");
           // Busket busket = mshs.getBusket(getUserId(request));
           
            Busket busket = mshs.getBusket(user.getId());
            //esli user null, to sozdaem korzinu v pamyati.
            request.setAttribute("busket", busket);
            System.out.println(busket.getBusketItems().size());
            request.getRequestDispatcher("korzina.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private int getUserId(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            User user = (User) request.getSession().getAttribute("user");
            System.out.println("user.getId" + user.getId());
            return user.getId();

        }
        return 1;
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
