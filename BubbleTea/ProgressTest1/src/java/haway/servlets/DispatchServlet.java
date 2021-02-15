/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author haway
 */
@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {
    
    private final String ERROR_PAGE = "error.html";
    private final String LOGIN_SERVLET = "LoginServlet";
    private final String SEARCH_USER_SERVLET = "SearchUserServlet";
    private final String SEARCH_STAFF_SERVLET = "SearchStaffServlet";    
    private final String SEARCH_MANAGER_SERVLET = "SearchManagerServlet";
    private final String DELETE_ACCOUNT_SERVLET = "DeleteAccountServlet";
    private final String UPDATE_ACCOUNT_SERVLET = "UpdateAccountServlet";
    private final String CREATE_ACCOUNT_SERVLET = "CreateAccountServlet";
    private final String ADD_TO_CART_SERVLET = "AddToCartServlet";
    private final String SHOW_CART_SERVLET = "viewCart.jsp";
    private final String DELETE_CART_SERVLET = "DeleteCartServlet";
    private final String UPDATE_CART_SERVLET = "UpdateCartServlet";
    private final String BUY_CART_SERVLET = "BuyCartServlet";
    private final String CREATE_PRODUCT_SERVLET = "CreateProductServlet";
    
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
        String url = ERROR_PAGE;
        try {
            String action = request.getParameter("btnAction");
            if (action.equals("Login")) {
                url = LOGIN_SERVLET;
            } else if (action.equals("Search User")) {
                url = SEARCH_USER_SERVLET;
            } else if (action.equals("Search Staff")) {
                url = SEARCH_STAFF_SERVLET;
            } else if (action.equals("Search Manager")) {
                url = SEARCH_MANAGER_SERVLET;
            } else if (action.equals("DeleteAccount")) {
                url = DELETE_ACCOUNT_SERVLET;
            } else if (action.equals("Update Account")) {
                url = UPDATE_ACCOUNT_SERVLET;
            } else if (action.equals("Create New Account")) {
                url = CREATE_ACCOUNT_SERVLET;
            } else if (action.equals("Add to Cart")) {
                url = ADD_TO_CART_SERVLET;
            } else if (action.equals("Show Cart")) {
                url = SHOW_CART_SERVLET;
            } else if (action.equals("Delete Item")) {
                url = DELETE_CART_SERVLET;
            } else if (action.equals("Update Item")) {
                url = UPDATE_CART_SERVLET;
            } else if (action.equals("Buy Cart!")) {
                url = BUY_CART_SERVLET;
            } else if (action.equals("Create New Product")) {
                url = CREATE_PRODUCT_SERVLET;
            }
        } catch (Exception e) {
            log("Error at DispatchServlet " + e.toString());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);            
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
