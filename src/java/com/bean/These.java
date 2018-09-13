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
public class These implements Serializable{
    private int idThese;
    private String sujet;
    private String encadrePar;
    private String faitePar;
    private String THouM;
    private int quantite;
    private String categorie;
private String img;

    public String getCategorie() {
        return categorie;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getIdThese() {
        return idThese;
    }

    public void setIdThese(int idThese) {
        this.idThese = idThese;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getEncadrePar() {
        return encadrePar;
    }

    public void setEncadrePar(String encadrePar) {
        this.encadrePar = encadrePar;
    }

    public String getFaitePar() {
        return faitePar;
    }

    public void setFaitePar(String faitePar) {
        this.faitePar = faitePar;
    }

    public String getTHouM() {
        return THouM;
    }

    public void setTHouM(String THouM) {
        this.THouM = THouM;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public These() {
    }
    
    
    public void AjouterTheMem(int idThese,String sujet ,String encadrePar,String faitePar,String THouM,int quantite,String categorie, String photo,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
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
               PreparedStatement q = cnx.connexion.prepareStatement("insert into these values(?,?,?,?,?,?,?,?)");
               
               q.setInt(1,idThese);
               q.setString(2,sujet);
               q.setString(3,encadrePar);
               q.setString(4,faitePar);
                q.setInt(5,quantite);
               q.setString(6,THouM);
               q.setString(7,categorie);
               q.setString(8,fileName);
               
               
               
            int  rs=q.executeUpdate();
            if(rs==1){
                System.out.println(" ajout avec succee");
            }
            
            
            } catch (SQLException ex) {
                 System.out.println("ajout échouéé");
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

    public void supprimerTheMem(int idTh){
         Connex cnx= new Connex();
        cnx.init();
        try {
               PreparedStatement q = cnx.connexion.prepareStatement
        ("delete  from these where idThese=?");
                q.setInt(1,idTh);  
            int  rs=q.executeUpdate();
           
            } catch (SQLException ex) {
                 System.out.println("Supression échouéé");
            } 
    }
    public List<These> listeThese(String thh){
        Connex cnx= new Connex();
        cnx.init();
        List<These> maListeThese =new ArrayList<These>();
         try {
             
                 String set="select * from these where thouM='"+thh+"' ";
                 Statement commande=cnx.connexion.createStatement();
                 ResultSet  rs=commande.executeQuery(set);
               
                 while(rs.next()){
                     int IdThese=Integer.parseInt(rs.getString(1));
                     String Sujet=rs.getString(2);
                     String EncadrePar=rs.getString(3);
                     String FaitePar =rs.getString(4);
                     String tHouM =rs.getString(6);
                     int Quantite =rs.getInt(5);
                     String Categorie =rs.getString(7);
                     String Path =rs.getString(8);
                    
                     System.out.println(Categorie+"ListeThese"+tHouM); 
                    
                     These th=new These();
                     th.setIdThese(IdThese);
                     th.setSujet(Sujet);
                     th.setEncadrePar(EncadrePar);
                     th.setFaitePar(FaitePar);
                     th.setTHouM(tHouM);
                     th.setQuantite(Quantite);
                     th.setCategorie(Categorie);
                     th.setImg(Path);
                     maListeThese.add(th);
               
                     
                     
                 }
            
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }
         return maListeThese;
    }
    public void modifierThese(int idThese,String sujet ,String encadrePar,String faitePar,int quantite){
         Connex cnx = new Connex();
        cnx.init();
  try { System.out.println("avant");
               PreparedStatement q = cnx.connexion.prepareStatement("update  these set sujet=?, encadrePar=? ,faitePar=?, quantite=? where idThese=?");
               System.out.println("apppt");
               q.setString(1,sujet);
               q.setString(2,encadrePar);
               q.setString(3,faitePar);
              
              q.setInt(4,quantite);
               q.setInt(5,idThese);
               System.out.println("apres les attribut");
            int  rs=q.executeUpdate();
            System.out.println("mn rs ="+rs);
            if(rs==1){
                System.out.println(" Modifier avec succee la These");
            }
            
            
            } catch (SQLException ex) {
                 System.out.println("Mofdif errone these");
            } 
          
              
 
    }
     public List<These> theseBycategorie (String categori){
        Connex cnx = new Connex();
        cnx.init();
        List<These> these =new ArrayList<These>();
       
        try {
            
                     System.out.println(categori);
                 String set="select * from these WHERE thouM='These' and categorie='"+categori+"'";
                Statement commande=cnx.connexion.createStatement();
                ResultSet  rs=commande.executeQuery(set);
                boolean rs1=rs.first();
                     System.out.println(rs1);
                     while(rs.next()){
                     int IdThese=Integer.parseInt(rs.getString(1));
                     
                     String Sujet=rs.getString(2);
                     System.out.println("apreeeee");
                     String EncadrePar=rs.getString(3);
                     
                     String FaitePar =rs.getString(4);
                    
                     int Quantite =rs.getInt(5);
                      
                     String tHouM =rs.getString(6);
                    String Categorie =rs.getString(7);
                     String Path =rs.getString(8);
                     System.out.println(IdThese);
                     
                      These th=new These();
                     th.setIdThese(IdThese);
                     th.setSujet(Sujet);
                     th.setEncadrePar(EncadrePar);
                     th.setFaitePar(FaitePar);
                     th.setTHouM(tHouM);
                     th.setQuantite(Quantite);
                     th.setCategorie(Categorie);     
                     th.setImg(Path);
                     these.add(th);
                     }
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }

        return these;
    }
      public List<These> memBycategorie (String categori){
        Connex cnx = new Connex();
        cnx.init();
        List<These> these =new ArrayList<These>();
       
        try {
            
                     System.out.println(categori);
                 String set="select * from these WHERE thouM='memoire' and categorie='"+categori+"'";
                Statement commande=cnx.connexion.createStatement();
                ResultSet  rs=commande.executeQuery(set);
                boolean rs1=rs.first();
                     System.out.println(rs1);
                     while(rs.next()){
                     int IdThese=Integer.parseInt(rs.getString(1));
                     
                     String Sujet=rs.getString(2);
                     System.out.println("apreeeee");
                     String EncadrePar=rs.getString(3);
                     
                     String FaitePar =rs.getString(4);
                    
                     int Quantite =rs.getInt(5);
                      
                     String tHouM =rs.getString(6);
                    String Categorie =rs.getString(7);
                     String Path =rs.getString(8);
                     System.out.println(IdThese);
                     
                      These th=new These();
                     th.setIdThese(IdThese);
                     th.setSujet(Sujet);
                     th.setEncadrePar(EncadrePar);
                     th.setFaitePar(FaitePar);
                     th.setTHouM(tHouM);
                     th.setQuantite(Quantite);
                     th.setCategorie(Categorie);     
                     th.setImg(Path);
                     these.add(th);
                     }
            } catch (SQLException ex) {
                System.err.println("pas de liste Memoire erreer");
                
            }

        return these;
    }
    public These mThese (String sujett){
        Connex cnx = new Connex();
        cnx.init();
        These th=new These();
                 try {
                 String set="select * from these where sujet like %'"+sujett+"'%";
                Statement commande=cnx.connexion.createStatement();
                ResultSet  rs=commande.executeQuery(set);
               
                      int IdThese=Integer.parseInt(rs.getString(1));
                     String Sujet=rs.getString(2);
                     String EncadrePar=rs.getString(3);
                     String FaitePar =rs.getString(4);
                     String tHouM =rs.getString(5);
                     int Quantite =rs.getInt(6);
                     String Categorie =rs.getString(7);
                     
                    
                     
                     th.setIdThese(IdThese);
                     th.setSujet(Sujet);
                     th.setEncadrePar(EncadrePar);
                     th.setFaitePar(FaitePar);
                     th.setTHouM(tHouM);
                     th.setQuantite(Quantite);
                     th.setCategorie(Categorie);        
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }

        return th;
    }
    public These maThese (int idth){
        Connex cnx = new Connex();
        cnx.init();
        These th=new These();
                 try {
                     
                 String set="select * from these where idThese='"+idth+"'";
                Statement commande=cnx.connexion.createStatement();
                ResultSet  rs=commande.executeQuery(set);
                    System.out.println(rs.first());
               
                      int IdThese=Integer.parseInt(rs.getString(1));
                     
                     String Sujet=rs.getString(2);
                      //System.out.println("apreeeee");
                     String EncadrePar=rs.getString(3);
                     
                     String FaitePar =rs.getString(4);
                    
                     int Quantite =rs.getInt(5);
                      
                     String tHouM =rs.getString(6);
                    String Categorie =rs.getString(7);
                     String Path =rs.getString(8);
                      
                    
                     
                     th.setIdThese(IdThese);
                     th.setSujet(Sujet);
                     th.setEncadrePar(EncadrePar);
                     th.setFaitePar(FaitePar);
                     th.setTHouM(tHouM);
                     th.setQuantite(Quantite);
                     th.setCategorie(Categorie);     
                     th.setImg(Path);
            } catch (SQLException ex) {
                System.err.println("pas de These By Id");
                
            }

        return th;
    }
    public List<These> RechercheThese(String nom){
        Connex cnx = new Connex();
        cnx.init();
        List<These> these =new ArrayList<These>();
       
        try {
            
                     System.out.println(nom);
                 String set="select * from these WHERE thouM='These' and sujet LIKE '%"+nom+"%'";
                Statement commande=cnx.connexion.createStatement();
                ResultSet  rs=commande.executeQuery(set);
                boolean rs1=rs.first();
                     System.out.println(rs1);
                     while(rs.next()){
                     int IdThese=Integer.parseInt(rs.getString(1));
                     
                     String Sujet=rs.getString(2);
                     System.out.println("apreeeee");
                     String EncadrePar=rs.getString(3);
                     
                     String FaitePar =rs.getString(4);
                    
                     int Quantite =rs.getInt(5);
                      
                     String tHouM =rs.getString(6);
                    String Categorie =rs.getString(7);
                     String Path =rs.getString(8);
                     System.out.println(IdThese);
                     
                      These th=new These();
                     th.setIdThese(IdThese);
                     th.setSujet(Sujet);
                     th.setEncadrePar(EncadrePar);
                     th.setFaitePar(FaitePar);
                     th.setTHouM(tHouM);
                     th.setQuantite(Quantite);
                     th.setCategorie(Categorie);     
                     th.setImg(Path);
                     these.add(th);
                     }
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }

        return these;
    }
       public List<These> RechercheM(String nom){
        Connex cnx = new Connex();
        cnx.init();
        List<These> these =new ArrayList<These>();
       
        try {
            
                     System.out.println(nom);
                 String set="select * from these WHERE thouM='memoire' and sujet LIKE '%"+nom+"%'";
                Statement commande=cnx.connexion.createStatement();
                ResultSet  rs=commande.executeQuery(set);
                boolean rs1=rs.first();
                     System.out.println(rs1);
                     while(rs.next()){
                     int IdThese=Integer.parseInt(rs.getString(1));
                     
                     String Sujet=rs.getString(2);
                      //System.out.println("apreeeee");
                     String EncadrePar=rs.getString(3);
                     
                     String FaitePar =rs.getString(4);
                    
                     int Quantite =rs.getInt(5);
                      
                     String tHouM =rs.getString(6);
                    String Categorie =rs.getString(7);
                     String Path =rs.getString(8);
                     System.out.println(IdThese);
                     
                      These th=new These();
                     th.setIdThese(IdThese);
                     th.setSujet(Sujet);
                     th.setEncadrePar(EncadrePar);
                     th.setFaitePar(FaitePar);
                     th.setTHouM(tHouM);
                     th.setQuantite(Quantite);
                     th.setCategorie(Categorie);     
                     th.setImg(Path);
                     these.add(th);
                     }
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }

        return these;
    }

    
}
