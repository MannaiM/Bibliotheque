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
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Maha
 */
public class Livre implements Serializable{
    private int idLivre;
      private String titre;
    private String auteur;
    private String datePub;
      private String genre;
        private int quantiteLiv;
          private String categorie;
          private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
          

    public int getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDatePub() {
        return datePub;
    }

    public void setDatePub(String datePub) {
        this.datePub = datePub;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantiteLiv() {
        return quantiteLiv;
    }

    public void setQuantiteLiv(int quantiteLiv) {
        this.quantiteLiv = quantiteLiv;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    
          
  

    public Livre() {
    }

    
    
    public void insert (int id,String titre ,String auteur ,String datePub,String genre,int quantiteLiv,String categorie,String photo,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
       Connex cnx = new Connex();
        cnx.init();
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
        System.out.println("hi avant");

         try {
               PreparedStatement q = cnx.connexion.prepareStatement("insert into livre values(?,?,?,?,?,?,?,?)");
               q.setInt(1,id);
               q.setString(2,titre);
               q.setString(3,auteur);
               q.setString(4,datePub);
               q.setString(5,genre);
               q.setInt(6,quantiteLiv);
               q.setString(7,categorie);
               q.setString(8,fileName);
            int  rs=q.executeUpdate();
            request.setAttribute("message", "le livre est enregistrée avec succes");
            
            } catch (SQLException ex) {
                
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

   /* public void AjouterLivre(int id,String titre ,String auteur ,String datePub,String genre,int quantiteLiv,int categorie, String Path){
        Connex cnx = new Connex();
        cnx.init();

         try {
             System.out.println("avant");
               PreparedStatement q = cnx.connexion.prepareStatement("insert into livre values(?,?,?,?,?,?,?,?)");
               System.out.println("apres");
               q.setInt(1,id);
               q.setString(2,titre);
               q.setString(3,auteur);
               q.setString(4,datePub);
               q.setString(5,genre);
               q.setInt(6,quantiteLiv);
               q.setInt(7,categorie);
               q.setString(8,Path);
               
               
               
            int  rs=q.executeUpdate();
            System.out.println(rs);
            if(rs==1){
                System.out.println(" ajout avec succee");
            }
            
            
            } 
         catch (SQLException ex) {
                 System.out.println("ajout échouéé");
            } 
    
    }*/
    public void supprimerLivre(int idLiv){
         Connex cnx= new Connex();
        cnx.init();
        try {
               PreparedStatement q = cnx.connexion.prepareStatement
        ("delete  from livre where idLivre=?");
                q.setInt(1,idLiv);  
            int  rs=q.executeUpdate();
           System.out.println("Supression d'un Livre");
            } catch (SQLException ex) {
                 System.out.println("Supression échouéé");
            } 
    }
    public List<Livre> listeLivre(){
        Connex cnx= new Connex();
        cnx.init();
        List<Livre> maListeLivre =new ArrayList<Livre>();
         try {
                 String set="select * from livre";
                 Statement commande=cnx.connexion.createStatement();
                 ResultSet  rs=commande.executeQuery(set);
                 System.out.println("hi1");
                 while(rs.next()){
                     System.out.println("hi2");
                    int idLiv=Integer.parseInt(rs.getString(1));
                     String titr=rs.getString(2);
                     String Auteur=rs.getString(3);
                     String datePubl =rs.getString(4);
                     String Genre =rs.getString(5);
                     int QuantiteLiv =rs.getInt(6);
                    String Categorie =rs.getString(7);
                    String Path=rs.getString(8);
                     System.out.println("hi"+ titr+Auteur+datePubl);
                    
                     Livre liv=new Livre();
                     liv.setIdLivre(idLiv);
                     liv.setAuteur(Auteur);
                     liv.setDatePub(datePubl);
                     liv.setTitre(titr);
                     liv.setCategorie(Categorie);
                     liv.setGenre(Genre);
                     liv.setQuantiteLiv(QuantiteLiv);
                        liv.setPath(Path);
                     maListeLivre.add(liv);
                     
                 }
            
            } catch (SQLException ex) {
                System.err.println("pas de liste ivre erreer");
                
            }
         return maListeLivre;
    }
    public void modifierLivre(int idLivre,String titre ,String auteur ,String datePub,String genre,int quantiteLiv,String categorie){
       Connex cnx = new Connex();
        cnx.init();
        System.out.println("hi avant modifier livre");
     
  try {
               PreparedStatement q = cnx.connexion.prepareStatement("update  livre set titre=? ,auteur=? ,datePub=? ,genre=?,quantiteLiv=?,categorie=?where idLivre=?");
               System.out.println("hi apres modifier livre");
               q.setString(1,titre);
               q.setString(2,auteur);
               q.setString(3,datePub);
               q.setString(4,genre);
               q.setInt(5,quantiteLiv);
               q.setString(6,categorie);
               
               q.setInt(7,idLivre);
               System.out.println("hi apres les attri");
               
            int  rs=q.executeUpdate();
          System.out.println("mon res"+rs);
                    if(rs==1){
                System.out.println(" Modifier avec succee");
            }
            
            
            } catch (SQLException ex) {
                 System.out.println("ajout échouéé");
            } 
          
                 cnx.destroy();
                 
 
    }
    public List<Livre> livreByGenre (String genree){
        Connex cnx = new Connex();
        cnx.init();
        List<Livre> livByAut =new ArrayList<Livre>();
                 try {
                 String set="select * from livre where genre='"+genree+"'";
                Statement commande=cnx.connexion.createStatement();
                ResultSet  rs=commande.executeQuery(set);
                while(rs.next()){
                    int idLiv=Integer.parseInt(rs.getString(1));
                     String Titre=rs.getString(2);
                     String Auteur=rs.getString(3);
                     String DatePub =rs.getString(4);
                     String Genre =rs.getString(5);
                     int QuantiteLiv =rs.getInt(6);
                    String Categorie =rs.getString(7);
                     
                    
                     Livre liv=new Livre();
                     liv.setIdLivre(idLiv);
                     liv.setAuteur(Auteur);
                     liv.setDatePub(DatePub);
                     liv.setTitre(Titre);
                     liv.setCategorie(Categorie);
                     liv.setGenre(Genre);
                     liv.setQuantiteLiv(QuantiteLiv);
                     livByAut.add(liv);
                 }
            
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }

        return livByAut;
    }
     public List<Livre> livreBycategorie (int categori){
        Connex cnx = new Connex();
        cnx.init();
        List<Livre> livByCat =new ArrayList<Livre>();
                 try {
                 String set="select * from livre where categorie='"+categori+"'";
                Statement commande=cnx.connexion.createStatement();
                ResultSet  rs=commande.executeQuery(set);
                while(rs.next()){
                     int IdLivre=Integer.parseInt(rs.getString(1));
                     String Titre=rs.getString(2);
                     String Auteur=rs.getString(3);
                     String DatePub =rs.getString(4);
                     String Genre =rs.getString(5);
                     int QuantiteLiv =rs.getInt(6);
                     String Categorie =rs.getString(7);
                     
                    
                     Livre liv=new Livre();
                     liv.setIdLivre(IdLivre);
                     liv.setAuteur(Auteur);
                     liv.setDatePub(DatePub);
                     liv.setTitre(Titre);
                     liv.setCategorie(Categorie);
                     liv.setGenre(Genre);
                     liv.setQuantiteLiv(QuantiteLiv);
                     livByCat.add(liv);
                 }
            
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }

        return livByCat;
    }
     
    public Livre mnLivre (String titree){
        Connex cnx = new Connex();
        cnx.init();
        Livre mnLiv =new Livre();
                 try {
                 String set="select * from livre where titre="+titree+"";
                Statement commande=cnx.connexion.createStatement();
                ResultSet  rs=commande.executeQuery(set);
               
                     int IdLivre=Integer.parseInt(rs.getString(1));
                     String Titre=rs.getString(2);
                     String Auteur=rs.getString(3);
                     String DatePub =rs.getString(4);
                     String Genre =rs.getString(5);
                     int QuantiteLiv =rs.getInt(6);
                     String Categorie =rs.getString(7);
                     
                    
                     Livre liv=new Livre();
                     liv.setIdLivre(IdLivre);
                     liv.setAuteur(Auteur);
                     liv.setDatePub(DatePub);
                     liv.setTitre(Titre);
                     liv.setCategorie(Categorie);
                     liv.setGenre(Genre);
                     liv.setQuantiteLiv(QuantiteLiv);
            
            } catch (SQLException ex) {
                System.err.println("pas de livre mnliv erreer");
                
            }

        return mnLiv;
    }
    public Livre getLivre(int id){
        Connex cnx = new Connex();
        cnx.init();
        Livre liv=new Livre();
                 try {
                     
                 String set="select * from livre where idLivre='"+id+"'";
                Statement commande=cnx.connexion.createStatement();
                ResultSet  rs=commande.executeQuery(set);
                boolean rs1=rs.first();
                     System.out.println(rs1);
                     int IdLivre=Integer.parseInt(rs.getString(1));
                     System.out.println(IdLivre);
                     String Titre=rs.getString(2);
                     String Auteur=rs.getString(3);
                     String DatePub =rs.getString(4);
                     String Genre =rs.getString(5);
                     int QuantiteLiv =rs.getInt(6);
                     String Categorie =rs.getString(7);
                     String Path=rs.getString(8);
                     System.out.println(IdLivre);
                     System.out.println(Auteur);
                     System.out.println(QuantiteLiv );
                     
                     liv.setIdLivre(IdLivre);
                     liv.setAuteur(Auteur);
                     liv.setDatePub(DatePub);
                     liv.setTitre(Titre);
                     liv.setCategorie(Categorie);
                     liv.setGenre(Genre);
                     liv.setQuantiteLiv(QuantiteLiv);
                     liv.setPath(Path);
            
            } catch (SQLException ex) {
                System.err.println("pas de livre erreer getLivre");
                
            }

        return liv;
    }
    public List<Livre> Recherche(String nom){
        Connex cnx = new Connex();
        cnx.init();
        List<Livre> livre =new ArrayList<Livre>();
       
        try {
            
                     System.out.println(nom);
                 String set="select * from livre WHERE titre LIKE '%"+nom+"%'";
                Statement commande=cnx.connexion.createStatement();
                ResultSet  rs=commande.executeQuery(set);
                boolean rs1=rs.first();
                     System.out.println(rs1);
                     while(rs.next()){
                     int IdLivre=Integer.parseInt(rs.getString(1));
                     System.out.println(IdLivre);
                     String Titre=rs.getString(2);
                     String Auteur=rs.getString(3);
                     String DatePub =rs.getString(4);
                     String Genre =rs.getString(5);
                     int QuantiteLiv =rs.getInt(6);
                     String Categorie =rs.getString(7);
                     String Path=rs.getString(8);
                     System.out.println(IdLivre);
                     
                      Livre liv=new Livre();
                     liv.setIdLivre(IdLivre);
                     liv.setAuteur(Auteur);
                     liv.setDatePub(DatePub);
                     liv.setTitre(Titre);
                     liv.setCategorie(Categorie);
                     liv.setGenre(Genre);
                     liv.setQuantiteLiv(QuantiteLiv);
                     liv.setPath(Path);
                     livre.add(liv);
                     }
            } catch (SQLException ex) {
                System.err.println("pas de liste livre erreer");
                
            }

        return livre;
    }
 
    public List<Livre> Rechercheselect(String nom1){
        Connex cnx = new Connex();
        cnx.init();
        List<Livre> livre =new ArrayList<Livre>();
       
        try {
            
                     System.out.println(nom1);
                 String set="select * from livre WHERE genre like '%"+nom1+"%'";
                Statement commande=cnx.connexion.createStatement();
                ResultSet  rs=commande.executeQuery(set);
                boolean rs1=rs.first();
                     System.out.println(rs1);
                     while(rs.next()){
                     int IdLivre=Integer.parseInt(rs.getString(1));
                     System.out.println(IdLivre);
                     String Titre=rs.getString(2);
                     String Auteur=rs.getString(3);
                     String DatePub =rs.getString(4);
                     String Genre =rs.getString(5);
                     int QuantiteLiv =rs.getInt(6);
                     String Categorie =rs.getString(7);
                     String Path=rs.getString(8);
                     System.out.println(IdLivre);
                         System.out.println(Titre);
                      Livre liv=new Livre();
                     liv.setIdLivre(IdLivre);
                     liv.setAuteur(Auteur);
                     liv.setDatePub(DatePub);
                     liv.setTitre(Titre);
                     liv.setCategorie(Categorie);
                     liv.setGenre(Genre);
                     liv.setQuantiteLiv(QuantiteLiv);
                     liv.setPath(Path);
                     livre.add(liv);
                     }
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }

        return livre;
    }
    
}
