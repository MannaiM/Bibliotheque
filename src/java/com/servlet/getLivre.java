/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.Etudiant;
import com.bean.Livre;
import com.bean.Reservation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maha
 */
@MultipartConfig 
public class getLivre extends HttpServlet {

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
            out.println("<title>Servlet getLivre</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet getLivre at " + request.getContextPath() + "</h1>");
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
        //id="24";
        
        Livre liv=new Livre();
        Livre monliv= liv.getLivre(Integer.parseInt(id));
        System.out.println(monliv.getIdLivre());
        request.setAttribute("livre", monliv);
       this.getServletContext().getRequestDispatcher("/detaillivre.jsp").forward(request, response);
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
        //String id=request.getParameter("id");
       // String idEtud=request.getParameter("session");
       String idliv=request.getParameter("id");
        Livre liv=new Livre();
        Livre monliv= liv.getLivre(Integer.parseInt(idliv));
        System.out.println(monliv.getIdLivre());
        request.setAttribute("livre", monliv);
   HttpSession session = request.getSession();    
     Etudiant etud= (Etudiant) session.getAttribute("etud");
     int idEtud=etud.getMatricule();
        Reservation res = new Reservation() ;
        //int idRes =res.getcleidRes(Integer.parseInt(idEtud));
        //res.ReserverLivre( idRes,Integer.parseInt(idEtud),Integer.parseInt( id));
        // a partir de session
        int idRes =res.getcleidRes(etud.getMatricule());
        System.out.println("monidREs="+idRes);
           //idLivre     
String idlivre=request.getParameter("id");
       // System.out.println("mon id res"+ idRes);
        System.out.println(idEtud);
        System.out.println(idlivre);
        try {
            res.ReserverLivre(idEtud,Integer.parseInt(idlivre),request);
        } catch (SQLException ex) {
            Logger.getLogger(getLivre.class.getName()).log(Level.SEVERE, null, ex);
        }
      this.getServletContext().getRequestDispatcher("/detaillivre.jsp").forward(request, response);
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
