/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haway.servlets_user;

import haway.cart.CartDTO;
import haway.tbl_order.Tbl_OrderDAO;
import haway.tbl_orderDetail.Tbl_OrderDetailDAO;
import haway.tbl_tea.Tbl_TeaDTO;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author haway
 */
@WebServlet(name = "BuyCartServlet", urlPatterns = {"/BuyCartServlet"})
public class BuyCartServlet extends HttpServlet {

    private final String ERROR = "error.html";
    private final String SUCCESS = "thanks.html";
    
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
        try {   
            // order: orderDate, custID, total, address, phone
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();  
            String orderDate = dtf.format(now);
            float total = Float.parseFloat(request.getParameter("total"));
            String address = request.getParameter("txtAddress");
            String phone = request.getParameter("txtPhone");
            HttpSession session = request.getSession();
            String custID = (String)session.getAttribute("USERID");
            
            Tbl_OrderDAO orderdao = new Tbl_OrderDAO();
            boolean result1 = orderdao.insertRecord(orderDate, custID, total, address, phone);
            
            // orderDetail: productID, quantity, unitPrice, total, orderID
            boolean result2 = false;
            CartDTO cart = (CartDTO)session.getAttribute("CART");
            Map<String,Tbl_TeaDTO> list = cart.getCart();     
            for (Map.Entry<String,Tbl_TeaDTO> entry : list.entrySet()) {
                String productID = entry.getKey();
                int quantity = entry.getValue().getQuantity();
                float price = entry.getValue().getPrice();
                float totalOfType = price * quantity;
                int orderID = orderdao.getOrderIDfromOrderID();
                
                Tbl_OrderDetailDAO orderdetaildao = new Tbl_OrderDetailDAO();
                result2 = orderdetaildao.insertRecord(productID, quantity, price, totalOfType, orderID);
            }
            
            if (result1 && result2) {
                url = SUCCESS;
                session.removeAttribute("CART");
            }    
        } catch (Exception e) {
            log("Error at BuyCartServlet " + e.toString());
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
