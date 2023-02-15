/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tblOrder.OrderDAO;
import tblOrder.OrderDTO;
import tblOrderDetail.OrderDetailDAO;
import tblOrderDetail.OrderDetailDTO;

/**
 *
 * @author lehuuhieu
 */
@WebServlet(name = "HistoryOrderController", urlPatterns = {"/HistoryOrderController"})
public class HistoryOrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "error.jsp";
        try {
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
            OrderDAO orderDao = new OrderDAO();
            List<OrderDTO> list = orderDao.findByEmail(email);
            request.setAttribute("LIST", list);

            String orderIdTemp = request.getParameter("orderId");
            if (orderIdTemp != null) {
                if (orderIdTemp.length() != 0) {
                    int orderId = Integer.parseInt(orderIdTemp);
                    OrderDetailDAO dao = new OrderDetailDAO();
                    List<OrderDetailDTO> listDetail = dao.findByOrderId(orderId);
                    request.setAttribute("LIST_DETAIL", listDetail);
                }
            }
            url = "historyOrder.jsp";
        } catch (Exception e) {
            log("ERROR at HistoryOrderController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
