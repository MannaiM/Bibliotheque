/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.These;
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

public class ModifierThese extends HttpServlet {

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
            out.println("<title>Servlet ModifierThese</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifierThese at " + request.getContextPath() + "</h1>");
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
        //request.setAttribute("k", id);
        System.out.println(id);
        These liv=new These();
        These monliv= liv.maThese(Integer.parseInt(id));
        request.setAttribute("these", monliv);
       this.getServletContext().getRequestDispatcher("/modifierThese.jsp").forward(request, response);
      
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
        String id=request.getParameter("id");
         String sujet=request.getParameter("sujet");
          String enc=request.getParameter("enc");
           String fait=request.getParameter("fait");
            String qt=request.getParameter("qt");
        //request.setAttribute("k", id);
        System.out.println(id);
        These liv=new These();
        
        System.out.println("id= "+id+" sujet "+sujet+" enc " +enc+"ff "+fait +qt);
        try{ 
        liv.modifierThese(Integer.parseInt(id), sujet, enc, fait, Integer.parseInt(qt));
        request.setAttribute("res", "Modification avec succes");
        }
        catch(Exception e){
            request.setAttribute("res", "Modification echouee");
        }
        
       this.getServletContext().getRequestDispatcher("/modifierThese.jsp").forward(request, response);
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
