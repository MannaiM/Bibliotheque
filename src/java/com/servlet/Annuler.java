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
public class Annuler extends HttpServlet {

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
            out.println("<title>Servlet Annuler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Annuler at " + request.getContextPath() + "</h1>");
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
        String id1=request.getParameter("id1");
        String id2=request.getParameter("id2");
       // HttpSession session = request.getSession();
      //  session.getAttribute("user");
        
        HttpSession session = request.getSession();    
     Etudiant etud= (Etudiant) session.getAttribute("etud");
     int idEtud=etud.getMatricule();
         Reservation res=new Reservation();
        if(id !=null){
           
            res.annulerlivre(Integer.parseInt(id), idEtud);
        }else{
            if(id1 !=null){
                
            res.annulerThese(Integer.parseInt(id1), idEtud);
            }else{
                
            res.annulerMemoire( Integer.parseInt(id2), idEtud);
            }
        }
        
        Reservation rs=res.monpanier(66);
        Livre l=new Livre();
        These t=new These();
        Livre liv=l.getLivre(rs.getIdLivre());
        These te=t.maThese(rs.getIdThese());
        These Ma=t.maThese(rs.getIdMemoire());
        System.out.println(te.getSujet());
        System.out.println("**************************************************");
        request.setAttribute("nom", "khalil");
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
