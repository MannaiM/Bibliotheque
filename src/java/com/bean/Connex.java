/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Maha
 */
public class Connex extends HttpServlet {
    
    
      Connection connexion=null;
String user=null;
String pass=null;
public void init(){
    System.out.println("-------------------");
    System.out.println("init method has been called and servlet is initialized");
    System.out.println("-------------------");
    String url="jdbc:mysql://127.0.0.1:3306/maBiblio";
    String name="root";
    String pwd="";
    String  driver="com.mysql.jdbc.Driver";
    try{
        Class.forName(driver).newInstance();
        connexion=DriverManager.getConnection(url,name,pwd);
    }
    catch (Exception e){
        System.out.println("Error while loading...");
    }
System.out.println("fini");
}
public void destroy(){
    try{ 
        
        connexion.close();
    }
    catch(SQLException s){
        System.out.println(s.getMessage());
    }
    System.out.println("connection closed");
}

}
