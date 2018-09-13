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
public class Etudiant implements Serializable {
    
    private int matricule;
    private String nom;
    private String prenom;
    private String classe;
    private String filiaire;
    private String dateNai;
 private String path;
    private String motPasse;
    private int accept;

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }
    

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }
    
    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getFiliaire() {
        return filiaire;
    }

    public void setFiliaire(String filiaire) {
        this.filiaire = filiaire;
    }

    public String getDateNai() {
        return dateNai;
    }

    public void setDateNai(String dateNai) {
        this.dateNai = dateNai;
    }

    public Etudiant() {
    }
    
    //Ajouter un etudiant
    public void addEtudiant(int matricule,String nom, String prenom, String dateNai,String classe,String filiaire,String mp,String photo,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    
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
        }} catch (FileNotFoundException fne) {
        
        writer.println("<br/> ERROR: " + fne.getMessage());
}
    System.out.println("hi avant");

         try {
               PreparedStatement q = cnx.connexion.prepareStatement("insert into etudiant values(?,?,?,?,?,?,?,?,?)");
               q.setInt(1,matricule);
               q.setString(2,nom);
               q.setString(3,prenom);
               q.setString(4,classe);
               q.setString(5,filiaire);
               q.setString(6,dateNai);
               q.setString(7,fileName);
               q.setString(8,mp);
               q.setInt(9,0);
            int  rs=q.executeUpdate();
            request.setAttribute("message", "enregistrée avec succes");
            
            } catch (SQLException ex) {
                
            } 
          



    
        
    }
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
       
            
          
            
    ///////Supprimer un Utudiant
    public void supprimerEtudiant(int matr){
        Connex cnx= new Connex();
        cnx.init();
        try {
               PreparedStatement q = cnx.connexion.prepareStatement
        ("delete  from etudiant where matricule=?");
                q.setInt(1,matr);  
            int  rs=q.executeUpdate();
           
            } catch (SQLException ex) {
                 System.out.println("Supression échouéé");
            } 
    }
        /////liste des etudiants
    
    public List<Etudiant>recupererC(){
        Connex cnx= new Connex();
        cnx.init();
        List<Etudiant> maListeEtud =new ArrayList<Etudiant>();
         try {int a=1;
                 String set="select * from etudiant where accept='"+ a+"'";
                 Statement commande=cnx.connexion.createStatement();
                 ResultSet  rs=commande.executeQuery(set);
                 while(rs.next()){
                     int Matricule=Integer.parseInt(rs.getString(1));
                     String Nom=rs.getString(2);
                     String Prenom=rs.getString(3);
                     String DateNai=rs.getString(4);
                     String Classe=rs.getString(5);
                      String Filiaire=rs.getString(6);
                      String Path=rs.getString(7);
                      String mootpass=rs.getString(8);
                     Etudiant etu=new Etudiant();
                     etu.setMatricule(Matricule);
                     etu.setNom(Nom);
                     etu.setPrenom(Prenom);
                    etu.setDateNai(DateNai);
                    etu.setClasse(Classe);
                    etu.setFiliaire(Filiaire);
                    etu.setPath(Path);
                    etu.setMotPasse(mootpass);
                    maListeEtud.add(etu);
                 }
                 
            
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }
         return maListeEtud;
    }
    //liste des demandes d'ajout etudiant
    public List<Etudiant>dmandeAjout(){
        Connex cnx= new Connex();
        cnx.init();
        List<Etudiant> maListeEtud =new ArrayList<Etudiant>();
         try {int a=0;
                 String set="select * from etudiant where accept='"+ a+"'";
                 Statement commande=cnx.connexion.createStatement();
                 ResultSet  rs=commande.executeQuery(set);
                 while(rs.next()){
                     int Matricule=Integer.parseInt(rs.getString(1));
                     String Nom=rs.getString(2);
                     String Prenom=rs.getString(3);
                     String DateNai=rs.getString(4);
                     String Classe=rs.getString(5);
                      String Filiaire=rs.getString(6);
                      String Path=rs.getString(7);
                      String mootpass=rs.getString(8);
                     Etudiant etu=new Etudiant();
                     etu.setMatricule(Matricule);
                     etu.setNom(Nom);
                     etu.setPrenom(Prenom);
                    etu.setDateNai(DateNai);
                    etu.setClasse(Classe);
                    etu.setFiliaire(Filiaire);
                    etu.setPath(Path);
                    etu.setMotPasse(mootpass);
                    maListeEtud.add(etu);
                 }
                 
            
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }
         return maListeEtud;
    }
    //Accepter Etudiant
    public void accepterEtudiant(int matricule){
        Connex cnx = new Connex();
        cnx.init();
  try {System.out.println("av nt");
               //PreparedStatement q = cnx.connexion.prepareStatement("update into etudiant values(?) where matricule=?");
               PreparedStatement q = cnx.connexion.prepareStatement("update  etudiant  SET  accept=? WHERE matricule=?");
               System.out.println("apre");
               q.setInt(1,1);
               
               q.setInt(2,matricule);
               
               
               
            int  rs=q.executeUpdate();
                           System.out.println("apre"+ rs);

            if(rs==1){
                System.out.println(" Accepter avec succee");
            }
            
            
            } catch (SQLException ex) {
                 System.out.println("refuser échouéé");
            } 
          
                 
                 
    
}
    /////modifier Etudiant
    public void modifirEtudiant(int matricule,String Nom,String Prenom ,String motP){
        Connex cnx = new Connex();
        cnx.init();
  try {
               PreparedStatement q = cnx.connexion.prepareStatement("update into etudiant set nomEtud=? ,prenomEtud=? , motpasse=? where matricule=?");
               
              
               q.setString(1,Nom);
               q.setString(2,Prenom);
               
               q.setString(3,motP);
               q.setInt(9,matricule);
               
               
               
            int  rs=q.executeUpdate();
            if(rs==1){
                System.out.println(" Modifier avec succee");
            }
            
            
            } catch (SQLException ex) {
                 System.out.println("ajout échouéé");
            } 
          
                 
                 
    
}
    public Etudiant etud(int mat,String mp) throws SQLException{
             Connex cnx = new Connex();
        cnx.init();
         
         PreparedStatement q = cnx.connexion.prepareStatement("select * from etudiant where matricule=? and motpass=? and accept=1");
         q.setInt(1,mat);
                q.setString(2,mp);
               ResultSet rs=q.executeQuery();
                Etudiant admin=new Etudiant();

                  while(rs.next()){
                admin.setMatricule(rs.getInt(1));
                admin.setNom(rs.getString(2));
                admin.setPrenom(rs.getString(3));
                admin.setClasse(rs.getString(4));
                admin.setFiliaire(rs.getString(5));
                admin.setDateNai(rs.getString(6));
                admin.setPath(rs.getString(7));
                admin.setMotPasse(rs.getString(8));
               }

                return admin;
                
     } 
    public void validationMotsDePasse( String motDePasse, String confirmation , HttpServletRequest request ) throws Exception{
    if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
        if (!motDePasse.equals(confirmation)) {
              request.setAttribute("mes1","Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
        } else if (motDePasse.trim().length() < 4) {
              request.setAttribute("mes1","Les mots de passe doivent contenir au moins 4 caractères.");
        }
    } else {
          request.setAttribute("mes1","confirmer votre motdepasse.");
    }
}
     public void validationMatricule( int Mat, HttpServletRequest request ) throws Exception {
        
        
    if ( nom != null && nom.trim().length() < 3) {
        request.setAttribute("mes3","Le nom d'utilisateur doit contenir au moins 3 caractères." );
    }
    }
}