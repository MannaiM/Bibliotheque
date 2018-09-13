/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maha
 */
public class ModifierEmployee extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModifierEmployee</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifierEmployee at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String id=request.getParameter("id");
     
        
        Employee emp=new Employee();
        
        try {
            emp = emp.getEmp(Integer.parseInt(id));
            request.setAttribute("employee", emp);
        } catch (SQLException ex) {
            Logger.getLogger(ModifierEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
       this.getServletContext().getRequestDispatcher("/modifierEmp.jsp").forward(request, response);
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
       String cin=request.getParameter("id");
          String id=request.getParameter("id");
       String adresse=request.getParameter("adressee");
       String mp=request.getParameter("mpp");
        System.out.println("cin="+id+ "mp="+mp +"adresse="+ adresse);
       try{
            
            Employee emp = new Employee() ;
           
            emp.modifierEmployee(Integer.parseInt(id), adresse, mp);
            request.setAttribute("res1",  "Modifier Employee succe cin ="+ cin);
            
        }
        catch(Exception e){
                 request.setAttribute("res1",  "Modification erreur");
            }
        
        
        
         this.getServletContext().getRequestDispatcher("/modifierEmp.jsp").forward(request, response);
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
