/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filtre;


import com.bean.Employee;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maha
 */
public class MonFiltre implements Filter {
    
    private FilterConfig filterConfig = null;
    
    public MonFiltre() {
    }     


    public void  init(FilterConfig config) throws ServletException{
      //This method is called by the web container to indicate to a filter that it is being placed into service.
      System.out.println("----------------------------------------------------");
      System.out.println("init method is called in "+ this.getClass().getName());
      System.out.println("----------------------------------------------------");
   }
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
          
       HttpSession session = req.getSession();
       Employee user=(Employee) session.getAttribute("SESSION_USER");
       //System.out.println(user.equals(null));
       if(user ==null){
          
           res.sendRedirect("Adminindex");
       }else{
          
           chain.doFilter(request, response);
        }
        }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

       
    