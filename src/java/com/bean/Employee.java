/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Maha
 */
public class Employee implements Serializable{
    private int cin;
    private String nomEmp;
    private String prenomEmp;
    private String dateNais;
    private String adresse;
    private String dateEmbauche;
    private String path;
    private String motPasse;

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }
    

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    

    public Employee() {
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getPrenomEmp() {
        return prenomEmp;
    }

    public void setPrenomEmp(String prenomEmp) {
        this.prenomEmp = prenomEmp;
    }

    public String getDateNais() {
        return dateNais;
    }

    public void setDateNais(String dateNais) {
        this.dateNais = dateNais;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
    
    public void AjouterEmployee(int cin,String nomEmp ,String prenomEmp ,String dateNais,String adresse,String dateEmbauche,  String motpass, String photo,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
       
        Connex cnx = new Connex();
        cnx.init();
        System.out.println("hi img ");
       String path ="C:\\Users\\Maha\\Documents\\NetBeansProjects\\MaBibliotheque\\web\\image";
       Part filePart = request.getPart("photo");
       String fileName = getFileName(filePart);
      
    OutputStream out = null;
    InputStream filecontent = null;
    final PrintWriter writer = response.getWriter();
     try {
        out = new FileOutputStream(new File(path + File.separator
                + fileName));
        filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        
         
          
         
       
        
    } catch (FileNotFoundException fne) {
        
        writer.println("<br/> ERROR: " + fne.getMessage());

        
    }
    
         try {
               PreparedStatement q = cnx.connexion.prepareStatement("insert into employe values(?,?,?,?,?,?,?,?)");
               
               q.setInt(1,cin);
               q.setString(2,nomEmp);
               q.setString(3,prenomEmp);
               q.setString(4,dateNais);
               q.setString(5,adresse);
               q.setString(6,dateEmbauche);
               q.setString(7,fileName);
               q.setString(8,motpass);
               
               
               
               System.out.println("hi avant ");
            int  rs=q.executeUpdate();
            System.out.println("hi avant "+ rs);
            if(rs==1){
                System.out.println(" ajout avec succee employee");
            }
            
            
            } catch (SQLException ex) {
                 System.out.println("ajout échouéé d'un employeee");
            } 
    
    }
    /******************************************************************************/
    private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
}
/*********************************************************************************/

    /*public void AjouterEmployee(int cin,String nomEmp ,String prenomEmp ,String dateNais,String adresse,String dateEmbauche, String path, String motpass){
        Connex cnx = new Connex();
        cnx.init();

         try {
               PreparedStatement q = cnx.connexion.prepareStatement("insert into employe values(?,?,?,?,?,?,?,?)");
               
               q.setInt(1,cin);
               q.setString(2,nomEmp);
               q.setString(3,prenomEmp);
               q.setString(4,dateNais);
               q.setString(5,adresse);
               q.setString(6,dateEmbauche);
               q.setString(7,pathh);
               q.setString(8,motpass);
               
               
               
               
            int  rs=q.executeUpdate();
            
            if(rs==1){
                System.out.println(" ajout avec succee employee");
            }
            
            
            } catch (SQLException ex) {
                 System.out.println("ajout échouéé d'un employeee");
            } 
    
    }*/
    public void supprimerEmployee(int id){
         Connex cnx= new Connex();
        cnx.init();
        try {
               PreparedStatement q = cnx.connexion.prepareStatement
        ("delete  from employe where cin=?");
                q.setInt(1,id);  
            int  rs=q.executeUpdate();
           System.out.println("hi avant "+ rs);
            if(rs==1){
                System.out.println(" Suppression avec succee employee");
            }
            
            } catch (SQLException ex) {
                 System.out.println("Supression échouéé employee");
            } 
    }
    public List<Employee> listeEmp(){
        Connex cnx= new Connex();
        cnx.init();
        List<Employee> maListeEmpl =new ArrayList<Employee>();
         try {
                 String set="select * from employe";
                 Statement commande=cnx.connexion.createStatement();
                 ResultSet  rs=commande.executeQuery(set);
                 while(rs.next()){
                     
                    int Cin=Integer.parseInt(rs.getString(1));
                     String NomEmp=rs.getString(2);
                     String PrenomEmp=rs.getString(3);
                     String DateNais =rs.getString(4);
                     String Adresse =rs.getString(5);
                     
                     String DateEmbauche =rs.getString(6);
                      String Path =rs.getString(7);
                       String MotPass =rs.getString(8);
                     
                    
                    Employee emp=new Employee();
                     emp.setCin(Cin);
                    emp.setNomEmp(NomEmp);
                    emp.setPrenomEmp(PrenomEmp);
                    emp.setDateEmbauche(DateEmbauche);
                    emp.setDateNais(DateNais);
                    emp.setAdresse(Adresse);
                    emp.setMotPasse(MotPass);
                    emp.setPath(Path);
                     maListeEmpl.add (emp);               }
            
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }
         return maListeEmpl;
    }
    public void modifierEmployee(int  cin,String mp ,String adress){
        /* Connex cnx = new Connex();
        cnx.init();
         
  try {
               PreparedStatement q = cnx.connexion.prepareStatement("update employe set motpass=? , adresse=? where cin=?");
               
               
               q.setString(1,adress);
              
               q.setString(2,mp);
              
               q.setInt(3,cin);
               
               
            int  rs=q.executeUpdate();
            if(rs==1){
                System.out.println(" Modifier avec succee");
            }
            
            
            } catch (SQLException ex) {
                 System.out.println("Modfif échouéé");
            } 
          
                 cnx.destroy();
                 
 */
    }
     public Employee user(int cinn,String mp) throws SQLException{
             Connex cnx = new Connex();
        cnx.init();
         
         PreparedStatement q = cnx.connexion.prepareStatement("select * from employe where cin =? and motpass=? ");
         q.setInt(1,cinn);
                q.setString(2,mp);
               ResultSet rs=q.executeQuery();
                Employee admin=new Employee();

                  while(rs.next()){
                      System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
                admin.setCin(rs.getInt(1));
                admin.setNomEmp(rs.getString(2));
                admin.setPrenomEmp(rs.getString(3));
                admin.setAdresse(rs.getString(4));
                admin.setDateEmbauche(rs.getString(5));
                admin.setDateNais(rs.getString(6));
                admin.setPath(rs.getString(7));
               }

                return admin;
                
     } 
     
     
     public Employee getEmp(int cinn) throws SQLException{
             Connex cnx = new Connex();
        cnx.init();
         
         PreparedStatement q = cnx.connexion.prepareStatement("select * from employe where cin =? ");
         q.setInt(1,cinn);
               
               ResultSet rs=q.executeQuery();
                Employee admin=new Employee();

                  while(rs.next()){
                      System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
                admin.setCin(rs.getInt(1));
                admin.setNomEmp(rs.getString(2));
                admin.setPrenomEmp(rs.getString(3));
                admin.setDateEmbauche(rs.getString(4));
                admin.setAdresse(rs.getString(5));
                
                admin.setDateNais(rs.getString(6));
                admin.setPath(rs.getString(7));
                  admin.setMotPasse(rs.getString(8));
               }

                return admin;
                
     } 
}
