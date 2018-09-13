/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maha
 */
@MultipartConfig 
public class AjouterEmployee extends HttpServlet {

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
            out.println("<title>Servlet AjouterEmployee</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjouterEmployee at " + request.getContextPath() + "</h1>");
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
        this.getServletContext().getRequestDispatcher("/AjouterEmployee.jsp").forward(request, response); 
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
        String cin=request.getParameter("cin");
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String adresse=request.getParameter("adresse");
        String dateEmb=request.getParameter("dateEmb");
        String dateNai=request.getParameter("dateNai");
        String photo=request.getParameter("photo");
        String mp=request.getParameter("mp");
        String confirmation=request.getParameter("confirmation");
           
            
           
        //request.setAttribute("res3","llll");
        request.setAttribute("res2","ll"+nom+prenom+adresse+cin+dateEmb +dateNai+photo);
      
        
        try{
            Employee emp =new Employee();
            
            
        emp.AjouterEmployee (Integer.parseInt(cin), nom, prenom, dateNai, adresse, dateEmb,mp , photo, request, response);
        request.setAttribute("res1", "l'employee  "+nom+" "+prenom+" est ajouté avec succee");
            System.out.println("l'emp"+ cin +nom + prenom);
        }
        catch(Exception e){
                 request.setAttribute("res1",  "erreur");
            }
        this.getServletContext().getRequestDispatcher("/AjouterEmployee.jsp").forward(request, response);
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
