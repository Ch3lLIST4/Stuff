/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.servlets;

import haway.tbl_user.Tbl_UserDAO;
import haway.tbl_user.Tbl_UserInsertError;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

    private final String ERROR = "createNewAccount.jsp";
    private final String SUCCESS = "index.html";
    
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
        
        String url = ERROR;
        
        String userID = request.getParameter("txtUserID");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullName = request.getParameter("txtFullName");
        
        Tbl_UserInsertError errors = new Tbl_UserInsertError();
        boolean bErr = false;
        
        try {                     
            if (userID.trim().length() < 3 || userID.trim().length() >20) {
                bErr = true;
                errors.setUserIDLengthErr("User ID length requires 3-20 chars");    
            }
            
            if (password.trim().length() < 3 || password.trim().length() >24) {
                bErr = true;
                errors.setPasswordLengthErr("Password length requires 3-24 chars");    
            } else if (!confirm.trim().equals(password.trim())) {
                bErr = true;
                errors.setConfirmNotMatch("Confirm must match password");    
            }
            
            if (fullName.trim().length() < 2 || fullName.trim().length() >50) {
                bErr = true;
                errors.setFullNameLengthErr("Full name length requires 2-50 chars");    
            }
            
            if (bErr) {
                request.setAttribute("INSERTERR", errors);
            } else {
                Tbl_UserDAO dao = new Tbl_UserDAO();
                boolean result = dao.insertRecord(userID, password, fullName, "User");
            
                if (result) {
                    url = SUCCESS;
                }
            }
        } catch (SQLException e) {  
            log("SQL Error at CreateAccountServlet " + e.toString()); 
            
            errors.setUserIDisExisted(userID + " is Existed in System");
            request.setAttribute("INSERTERR", errors);
            
        } catch (Exception e) {
            log("Error at CreateAccountServlet " + e.toString()); 
        }
        finally {
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
