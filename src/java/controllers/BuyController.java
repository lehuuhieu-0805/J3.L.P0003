/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tblDiscount.DiscountDAO;
import tblOrder.OrderDAO;
import tblOrder.OrderDTO;
import tblOrderDetail.OrderDetailDAO;
import tblOrderDetail.OrderDetailDTO;
import tblRoom.CartObj;
import tblRoom.RoomDTO;

/**
 *
 * @author lehuuhieu
 */
@WebServlet(name = "BuyController", urlPatterns = {"/BuyController"})
public class BuyController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "viewCart.jsp";
    private static final String SUCCESS = "noti.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        try {
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("CART");
            if (cart == null || cart.getCart().isEmpty()) {
                request.setAttribute("ERROR", "Cart is empty");
                url = INVALID;
            } else {
                int totalPrice = Integer.parseInt(request.getParameter("txtTotalPrice").replaceAll("\\.?0*$", ""));
                System.out.println(totalPrice);
                String email = (String) session.getAttribute("email");
                java.util.Date date = new java.util.Date();
                Timestamp currentDate = new Timestamp(date.getTime());
                OrderDAO orderDao = new OrderDAO();
                int orderId = orderDao.create(new OrderDTO(totalPrice, email, "active", currentDate));
                for (RoomDTO x : cart.getCart().values()) {
                    int roomId = x.getId();
                    int price = x.getPrice();
                    int amount = x.getAmount();
                    OrderDetailDAO orderDetailDao = new OrderDetailDAO();
                    orderDetailDao.create(new OrderDetailDTO(price, amount, orderId, roomId));
                }
                cart.getCart().clear();
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("ERROR at BuyController: " + e.getMessage());
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
