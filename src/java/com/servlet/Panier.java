/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Etudiant;
import com.bean.Livre;
import com.bean.Reservation;
import com.bean.These;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
public class Panier extends HttpServlet {

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
            out.println("<title>Servlet Panier</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Panier at " + request.getContextPath() + "</h1>");
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
        Reservation res=new Reservation();
         HttpSession session = request.getSession();
        Etudiant nom=(Etudiant) session.getAttribute("etud");
         System.out.println("sssssssssssssssssssssssssssssssssssss");
         //select les id de reservation
        Reservation rs=res.monpanier(nom.getMatricule());
        Livre l=new Livre();
        These t=new These();
        System.out.println(rs.getIdThese());
        System.out.println(rs.getIdLivre());
        System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        Livre liv=l.getLivre(rs.getIdLivre());
        These te=t.maThese(rs.getIdThese());
        These Ma=t.maThese(rs.getIdMemoire());
        System.out.println(te.getSujet());
        System.out.println("**************************************************");
       
        System.out.println("0000");
        if(nom!=null){
           System.out.println(nom.getNom());
        System.out.println("0000");     
        request.setAttribute("nom", nom.getNom()); 
        }
        
        request.setAttribute("nomL", liv.getTitre());
        request.setAttribute("nomT", te.getSujet());
        request.setAttribute("nomM", Ma.getSujet());
        System.out.println(rs.getIdEtudiant());
        request.setAttribute("rs", rs);
        this.getServletContext().getRequestDispatcher( "/panier.jsp" ).forward( request, response );
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
         this.getServletContext().getRequestDispatcher( "/panier.jsp" ).forward( request, response );
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
