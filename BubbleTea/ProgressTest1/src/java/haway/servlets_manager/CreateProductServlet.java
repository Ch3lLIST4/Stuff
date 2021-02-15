/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.servlets_manager;

import haway.tbl_tea.Tbl_TeaDAO;
import haway.tbl_tea.Tbl_TeaInsertError;
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
@WebServlet(name = "CreateProductServlet", urlPatterns = {"/CreateProductServlet"})
public class CreateProductServlet extends HttpServlet {

    private final String ERROR = "createNewProduct.jsp";
    private final String SUCCESS = "createNewProduct.jsp";
    
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
        
        String teaID = request.getParameter("txtTeaID");
        String name = request.getParameter("txtName");
        String price = request.getParameter("txtPrice");
        
        Tbl_TeaInsertError errors = new Tbl_TeaInsertError();
        boolean bErr = false;
        
        try {
            if (teaID.trim().length() < 3 || teaID.trim().length() >10) {
                bErr = true;
                errors.setTeaIDLengthErr("Tea ID length requires 3-10 chars");
            }
            
            if (name.trim().length() < 3 || name.trim().length() > 20) {
                bErr = true;
                errors.setNameLengthErr("Name length requires 3-20 chars");
            }
            
            if (!price.matches("[0-9]+([,.][0-9]{1,2})?")) {
                bErr = true;
                errors.setPriceFormatErr("Price must be a float number");
            } 
            
            if (bErr) {
                request.setAttribute("TEAERR", errors);
            } else {
                Tbl_TeaDAO dao = new Tbl_TeaDAO();
                boolean result = dao.insertRecord(teaID, name, Float.parseFloat(price));
            
                if (result) {
                    url = SUCCESS;
                    errors.setTeaIDisExisted("Successfully added to the database!!!");
                    request.setAttribute("TEAERR", errors);
                }
            }           
        } catch (SQLException e) {
            log("SQL Error at CreateProductServlet " + e.toString()); 
            
            errors.setTeaIDisExisted(teaID + " is Existed in System");
            request.setAttribute("TEAERR", errors);
            
        } catch (Exception e) {
            log("Error at CreateProductServlet " + e.toString()); 
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
