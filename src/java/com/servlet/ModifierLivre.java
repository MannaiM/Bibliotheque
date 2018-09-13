/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Livre;
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

public class ModifierLivre extends HttpServlet {

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
            out.println("<title>Servlet ModifierLivre</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifierLivre at " + request.getContextPath() + "</h1>");
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
       // id="24";
        
        Livre liv=new Livre();
        Livre monliv= liv.getLivre(Integer.parseInt(id));
        System.out.println(monliv.getIdLivre());
        request.setAttribute("livre", monliv);
       this.getServletContext().getRequestDispatcher("/modifierLivre.jsp").forward(request, response);
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
        String titre=request.getParameter("titre");
        String auteur=request.getParameter("auteur");
        String dateNai=request.getParameter("datePub");
        String genre=request.getParameter("genre");
         String qt=request.getParameter("qt");
        String categorie=request.getParameter("categorie");
        String photo=request.getParameter("photo");
        //request.setAttribute("res2", titre + auteur+ dateNai + genre+ qt +categorie);
        try{
            System.out.println("cc id"+id+"ttt"+titre +"cc "+ auteur+ "cc "+dateNai + "cc "+genre+ "cc "+qt +categorie);
            Livre liv = new Livre() ;
           
            liv.modifierLivre(Integer.parseInt(id),titre, auteur, dateNai, genre, Integer.parseInt(qt), categorie);
            //liv.modifierLivre(1, "neww", "mmn New", "03-02-1999", "educatif", 20, "article");
            request.setAttribute("res1",  "Modifier Livre succe");
        }
        catch(Exception e){
                 request.setAttribute("res1",  "Modif Livre erreur");
            }
        
        
        
         this.getServletContext().getRequestDispatcher("/modifierLivre.jsp").forward(request, response);

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
