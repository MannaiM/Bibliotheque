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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maha
 */
public class getThese extends HttpServlet {

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
            out.println("<title>Servlet getThese</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet getThese at " + request.getContextPath() + "</h1>");
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
        
        These liv=new These();
        These monliv= liv.maThese(Integer.parseInt(id));
        System.out.println("monid= "+id +"moncc  "+monliv.getIdThese());
        request.setAttribute("these", monliv);
       this.getServletContext().getRequestDispatcher("/detailThese.jsp").forward(request, response);
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
    /*
   System.out.println("hi debut servlet ");
        These liv=new These();
       These monliv= liv.maThese(Integer.parseInt(idliv));
        System.out.println(monliv.getIdThese());
        request.setAttribute("these", monliv);
   HttpSession session = request.getSession();    
     Etudiant etud= (Etudiant) session.getAttribute("etud");
     int idEtud=etud.getMatricule();
        
        //int idRes =res.getcleidRes(Integer.parseInt(idEtud));
        //res.ReserverLivre( idRes,Integer.parseInt(idEtud),Integer.parseInt( id));
        // a partir de session
        //int idRes =res.getcleidRes(etud.getMatricule());
        //System.out.println("monidREs="+idRes);
           //idLivre     

     
        System.out.println("mon id etudin"+idEtud);
        */
    String idliv=request.getParameter("id");
    
    HttpSession session = request.getSession();    
     Etudiant etud= (Etudiant) session.getAttribute("etud");
     int idEtud=etud.getMatricule();
        System.out.println("idthese"+idliv+"  mn id etud "+idEtud);//ychouf feha null livre
        
        
    Reservation res = new Reservation() ;
    
        System.out.println("mn id these servlet"+idliv);
        try {
            res.ReserverThese(idEtud,12,request);
            System.out.println("c bon rser these servlet");
        } catch (Exception ex) {
            System.out.println("Erreur est survenu");
        }
    
   
    
        
        this.getServletContext().getRequestDispatcher("/detailThese.jsp").forward(request, response);
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
