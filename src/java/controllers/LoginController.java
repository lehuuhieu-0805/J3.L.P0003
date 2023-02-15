/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tblUser.UserDAO;
import tblUser.UserDTO;
import tblUser.UserError;

/**
 *
 * @author lehuuhieu
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "login.jsp";
    private static final String SUCCESS = "SearchController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;
        try {
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");

            UserError errorObj = new UserError();

            boolean valid = true;

            if (email.length() == 0) {
                valid = false;
                errorObj.setEmailError("Email can't be blank");
                url = INVALID;
            }
            if (password.length() == 0) {
                valid = false;
                errorObj.setPasswordError("Password can't be blank");
                url = INVALID;
            }

            if (valid) {
                UserDAO dao = new UserDAO();
                UserDTO dto = dao.login(email, password);

                if (dto.getName() == null) {
                    errorObj.setUserError("Username or password not correct");
                    request.setAttribute("INVALID", errorObj);
                    url = INVALID;
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("email", dto.getEmail());
                    session.setAttribute("name", dto.getName());
                    session.setAttribute("role", dto.getRole());
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("INVALID", errorObj);
            }

        } catch (Exception e) {
            log("ERROR at LoginController: " + e.getMessage());
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
