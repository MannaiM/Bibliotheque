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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maha
 */
public class Adminindex extends HttpServlet {

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
            out.println("<title>Servlet Adminindex</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Adminindex at " + request.getContextPath() + "</h1>");
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
        this.getServletContext().getRequestDispatcher( "/adminlogin.jsp" ).forward( request, response );
        
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
        try {
            Employee login=new Employee();
            String cin=request.getParameter("mail");
            String Password=request.getParameter("Password");
            System.out.println(cin);
            System.out.println(Password);
            /* Création ou récupération de la session */
HttpSession session = request.getSession();

/* Mise en session d'une chaîne de caractères */



            Employee rs;
            
                rs = login.user(Integer.parseInt(cin), Password);
                session.setAttribute("SESSION_USER", rs);
                
                //Employee etud=new Employee();
               
                //request.setAttribute("etud",rs.listeEmp());
                
                System.out.println(rs.getCin());
                if(rs.getCin()>0){
                    System.out.println("sssssssss");
                    this.getServletContext().getRequestDispatcher( "/menu.jsp" ).forward( request, response );
                }else{
                    System.out.println("qqqqqqqqqq");
                    this.getServletContext().getRequestDispatcher( "/adminlogin.jsp" ).forward( request, response );
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(Adminindex.class.getName()).log(Level.SEVERE, null, ex);
            }
            //boolean rs1=login.verif(mail, Password);
            
            /*if(rs){
               

/* Récupération de l'objet depuis la session */

                
         /*   }else{
                request.setAttribute("mes","erreur");
               this.getServletContext().getRequestDispatcher( "/adminindex.jsp" ).forward( request, response ); 
            }*/
            
       /* } catch (SQLException ex) {
            Logger.getLogger(Adminindex.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    
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
