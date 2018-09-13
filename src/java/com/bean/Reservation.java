/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maha
 */
public class Reservation implements Serializable{
    private int idReservation;
    private int idEtudiant;
    private int idLivre;
    private int idThese;
    private int idMemoire;
    private int accept;

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public int getIdThese() {
        return idThese;
    }

    public void setIdThese(int idThese) {
        this.idThese = idThese;
    }

    public int getIdMemoire() {
        return idMemoire;
    }

    public void setIdMemoire(int idMemoire) {
        this.idMemoire = idMemoire;
    }

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }

    public Reservation() {
    }
    
    
    public void Reserver(int idRes,int idEtud){
         Connex cnx = new Connex();
        cnx.init();
        System.out.println("hi avant");

         try {
               PreparedStatement q = cnx.connexion.prepareStatement("insert into reservation values(?,?,?,?,?,?)");
               q.setInt(1,idRes);
               q.setInt(2,idEtud);
               q.setInt(3,0);
               q.setInt(4,0);
               q.setInt(5,0);
               q.setInt(6,0);
               
            int  rs=q.executeUpdate();
             System.out.println("ajoutt ssucces");
            
            
            } catch (SQLException ex) {
                
            } 
        
        
    }
    //Reserver un livre
    public void ReserverLivre(int idEtud,int idLiv, HttpServletRequest request) throws SQLException{
        Connex cnx = new Connex();
        cnx.init();
         PreparedStatement sel = cnx.connexion.prepareStatement("select * from  livre WHERE 	idLivre=?");
            sel.setInt(1,idLiv);
            ResultSet select=sel.executeQuery();
            System.out.println("yejbed livre");
            
             int con=0;
            while(select.next()){
               con=select.getInt(6);
               System.out.println("yejbed livre "+con);
            }
            if (con>=2){
        try {System.out.println("avnt ajouterLivre");
              
               PreparedStatement q = cnx.connexion.prepareStatement("update  reservation  SET  idLivre=? WHERE  idEtudiant=? and idLivre=?");
               System.out.println("apre");
               q.setInt(1,idLiv);
              
               q.setInt(2,idEtud);
               q.setInt(3,0);
             
           int  rs=q.executeUpdate();
            
                           System.out.println("apres ajouter livre"+ rs);
            if(rs==1){
               
            
            int somme=con-1;
                System.out.println("avant modfiifer qt");
            PreparedStatement q1 = cnx.connexion.prepareStatement("update  livre  SET  	quantiteLiv=? WHERE idLivre=?");
            q1.setInt(1,somme);
            q1.setInt(2,idLiv);
            int  rs1=q1.executeUpdate();
            System.out.println("vrai si 1="+rs1);
                System.out.println(" Ajouter Au Panier");
                request.setAttribute("message", "Votre livre est ajouté");
            }
            else{request.setAttribute("message", "Vous Avez Deja un livre");}
           } catch (SQLException ex) {
                 System.out.println("Vous Avez Deja un livre");
            } 
            }
             else {
                request.setAttribute("message", "ce Livre n'existe pas pour le moment ");
            }
            
    }
    public void ReserverThese(int idEtud,int idTh , HttpServletRequest request) throws SQLException{
        Connex cnx = new Connex();
        cnx.init();
         PreparedStatement sel = cnx.connexion.prepareStatement("select * from  these WHERE 	idThese=?");
            sel.setInt(1,idTh);
            ResultSet select=sel.executeQuery();
            System.out.println("yejbed These");
            
             int con=0;
            while(select.next()){
               con=select.getInt(5);
               System.out.println("yejbed Theseavc Qt= "+con);
            }
            if (con>=2){
        try {System.out.println("avnt ajouterThese au panier");
              
               PreparedStatement q = cnx.connexion.prepareStatement("update  reservation  SET  idThese=? WHERE  idEtudiant=? and idThese=?");
               System.out.println("apre");
               q.setInt(1,idTh);
              q.setInt(2,idEtud);
               q.setInt(3,0);
             
           int  rs=q.executeUpdate();
            
                           System.out.println("apres ajouter these"+ rs);
            if(rs==1){
               
            
            int somme=con-1;
                System.out.println("avant modfiifer qt");
            PreparedStatement q1 = cnx.connexion.prepareStatement("update  these SET  	quantite=? WHERE idThese=?");
            q1.setInt(1,somme);
            q1.setInt(2,idTh);
            int  rs1=q1.executeUpdate();
            System.out.println("vrai si 1="+rs1);
                System.out.println(" Ajouter Au Panier");
                request.setAttribute("message", "Votre these est ajouté au panier");
            }
            else{request.setAttribute("message", "Vous Avez Deja une these au panier");}
           } catch (SQLException ex) {
                 System.out.println("Vous Avez Deja une these au panierr");
            } 
            }
             else {
                request.setAttribute("message", "cet these n'existe pas pour le moment ");
            }
            
        
    }
    public void ReserverMemoir(int idEtud,int idMem, HttpServletRequest request) throws SQLException{
       Connex cnx = new Connex();
        cnx.init();
        System.out.println("id Etud= "+idEtud +"idMem= "+idMem);
         PreparedStatement sel = cnx.connexion.prepareStatement("select * from  these WHERE 	idThese=?");
            sel.setInt(1,idMem);
            ResultSet select=sel.executeQuery();
            System.out.println("yejbed These");
            
             int con=0;
            while(select.next()){
               con=select.getInt(5);
               System.out.println("yejbed Mem avc Qt= "+con);
            }
            if (con>=2){
        try {System.out.println("avnt ajouterMemoire au panier");
              
               PreparedStatement q = cnx.connexion.prepareStatement("update  reservation  SET  idMemoire=? WHERE  idEtudiant=? and idMemoire=?");
               System.out.println("apre");
               q.setInt(1,idMem);
              q.setInt(2,idEtud);
               q.setInt(3,0);
             
           int  rs=q.executeUpdate();
            
                           System.out.println("apres ajouter MEm"+ rs);
            if(rs==1){
               
            
            int somme=con-1;
                System.out.println("avant modfiifer qt de mem");
            PreparedStatement q1 = cnx.connexion.prepareStatement("update  these SET  	quantite=? WHERE idThese=?");
            q1.setInt(1,somme);
            q1.setInt(2,idMem);
            int  rs1=q1.executeUpdate();
            System.out.println("vrai si 1="+rs1);
                System.out.println(" Ajouter Au Panier Mm");
                request.setAttribute("message", "Votre Memoire est ajouté au panier");
            }
            else{request.setAttribute("message", "Vous Avez Deja une Memoire au panier");}
           } catch (SQLException ex) {
                 System.out.println("Vous Avez Deja une Memoire au panierr");
            } 
            }
             else {
                request.setAttribute("message", "cet Memoire n'existe pas pour le moment ");
            }
    }
    // elli reservew donc fl panier (Accepter ou refuser)
    public List<Reservation> listeDemandeReservation(){
         Connex cnx= new Connex();
        cnx.init();
       
        List <Reservation> maListe = new ArrayList<Reservation>();
        
        try {int a=0;
        
                 String set="select * from reservation where accept='"+ a+"'";
                 Statement commande=cnx.connexion.createStatement();
                 ResultSet  rs=commande.executeQuery(set);
                  System.out.println("apresRq");
                 while(rs.next()){
                     int idRes=Integer.parseInt(rs.getString(1));
                     int idEtud=rs.getInt(2);
                     int idLiv=rs.getInt(3);
                     int idThes=rs.getInt(4);
                     int idMem=rs.getInt(5);
                      Reservation rev = new Reservation();
                      rev.setIdReservation(idRes);
                     rev.setIdEtudiant(idEtud);
                     rev.setIdLivre(idLiv);
                     rev.setIdMemoire(idMem);
                     rev.setIdThese(idThes);
                    maListe.add(rev);
                     System.out.println("ajouter a ma liste");
                 }
                 
            
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }
        return maListe;
    }
    //li hazzou lktobba Supprimer ki yrajja3  1111
    public List<Reservation> listeReservation(){
        Connex cnx= new Connex();
        cnx.init();
       
        List <Reservation> maListe = new ArrayList<Reservation>();
        
        try {int a=1;
        System.out.println("hi avnt rqt");
                 String set="select * from reservation where accept='"+ a+"'";
                 Statement commande=cnx.connexion.createStatement();
                 ResultSet  rs=commande.executeQuery(set);
                 System.out.println("hi apre rqt");
                 while(rs.next()){
                     int idRes=Integer.parseInt(rs.getString(1));
                     int idEtud=rs.getInt(2);
                     int idLiv=rs.getInt(3);
                     int idThes=rs.getInt(4);
                     int idMem=rs.getInt(5);
                      Reservation rev = new Reservation();
                      rev.setIdReservation(idRes);
                     rev.setIdEtudiant(idEtud);
                     rev.setIdLivre(idLiv);
                     rev.setIdMemoire(idMem);
                     rev.setIdThese(idThes);
                    maListe.add(rev);
                 }
                 
            
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }
        
        return maListe;
    }
    // aanulation de la par de letudiant 
    public void annulerRes(int idRes){
        
    }
    //Voir Mon panier 
    public Reservation monpanier(int idetud){
          Reservation rev= new Reservation();
         Connex cnx = new Connex();
        cnx.init();
        try { int a=0;
                 String set="select * from reservation where idEtudiant='"+ idetud+"' and accept='"+a+"'";
                 Statement commande=cnx.connexion.createStatement();
                 ResultSet  rs=commande.executeQuery(set);
                 System.out.println(rs.first());
                     int idRes=Integer.parseInt(rs.getString(1));
                     
                     int idEtud=rs.getInt(2);
                     int idLiv=rs.getInt(3);
                     
                     int idThes=rs.getInt(4);
                     int idMem=rs.getInt(5);
                     
                     System.out.println(idEtud);
                      rev.setIdReservation(idRes);
                     rev.setIdEtudiant(idEtud);
                     rev.setIdLivre(idLiv);
                     rev.setIdMemoire(idMem);
                     rev.setIdThese(idThes);
                 
                 
            System.out.println("ma reserva");
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }
         return rev;
    }
    //ce que j'ai a la maison
    public Reservation maReservation(int idetud){
          Reservation rev= new Reservation();
         Connex cnx = new Connex();
        cnx.init();
        try { int a=1;
                 String set="select * from reservation where idEtudiant='"+ idetud+"' and accept='"+a+"'";
                 Statement commande=cnx.connexion.createStatement();
                 ResultSet  rs=commande.executeQuery(set);
                 System.out.println(rs.first());
                     int idRes=Integer.parseInt(rs.getString(1));
                     
                     int idEtud=rs.getInt(2);
                     int idLiv=rs.getInt(3);
                     
                     int idThes=rs.getInt(4);
                     int idMem=rs.getInt(5);
                     
                     System.out.println(idEtud);
                      rev.setIdReservation(idRes);
                     rev.setIdEtudiant(idEtud);
                     rev.setIdLivre(idLiv);
                     rev.setIdMemoire(idMem);
                     rev.setIdThese(idThes);
                 
                 
            System.out.println("ma reserva");
            } catch (SQLException ex) {
                System.err.println("pas de liste erreer");
                
            }
         return rev;
        
    }
    public void annulerlivre(int id,int id_user){
        try {
            Connex cnx = new Connex();
            cnx.init();
            
           
            System.out.println(id);
            PreparedStatement q = cnx.connexion.prepareStatement("update  reservation  SET  idLivre=? WHERE idEtudiant=?");
            q.setInt(1,0);
            q.setInt(2,id_user);
            int  rs=q.executeUpdate();
            PreparedStatement sel = cnx.connexion.prepareStatement("select * from  livre WHERE 	idLivre=?");
            sel.setInt(1,id);
            ResultSet select=sel.executeQuery();
            System.out.println(id);
            
             int con=0;
            while(select.next()){
               con=select.getInt(6);
            }
            
            int somme=con+1;
            
            PreparedStatement q1 = cnx.connexion.prepareStatement("update  livre  SET  	quantiteLiv=? WHERE idLivre=?");
            q1.setInt(1,somme);
            q1.setInt(2,id);
            int  rs1=q1.executeUpdate();
            System.out.println(rs1);
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void annulerThese(int id,int id_user){
        try {
            Connex cnx = new Connex();
            cnx.init();
            PreparedStatement q = cnx.connexion.prepareStatement("update  reservation  SET  idThese=? WHERE idEtudiant=?");
            q.setInt(1,0);
            q.setInt(2,id_user);
            int  rs=q.executeUpdate();
            PreparedStatement sel = cnx.connexion.prepareStatement("select * from  these WHERE 	idThese=?");
            sel.setInt(1,id);
            ResultSet select=sel.executeQuery();
            System.out.println(id);
            
             int con=0;
            while(select.next()){
               con=select.getInt(5);
            }
            
            int somme=con+1;
            System.out.println(somme);
            PreparedStatement q1 = cnx.connexion.prepareStatement("update  these  SET  	quantite=? WHERE idThese=?");
            q1.setInt(1,somme);
            q1.setInt(2,id);
            int  rs1=q1.executeUpdate();
            System.out.println(rs1);
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
                public void annulerMemoire(int id,int id_user){
        try {
            Connex cnx = new Connex();
            cnx.init();
            PreparedStatement q = cnx.connexion.prepareStatement("update  reservation  SET  idMemoire=? WHERE idEtudiant=?");
            q.setInt(1,0);
            q.setInt(2,id_user);
            int  rs=q.executeUpdate();
            PreparedStatement sel = cnx.connexion.prepareStatement("select * from  these WHERE 	idThese=?");
            sel.setInt(1,id);
            ResultSet select=sel.executeQuery();
            System.out.println(id);
            
             int con=0;
            while(select.next()){
               con=select.getInt(5);
            }
            
            int somme=con+1;
            
            PreparedStatement q1 = cnx.connexion.prepareStatement("update  these  SET  	quantite=? WHERE idThese=?");
            q1.setInt(1,somme);
            q1.setInt(2,id);
            int  rs1=q1.executeUpdate();
            System.out.println(rs1);
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    //Accepter Etudiant
    public void acceptRes(int idRes){
         Connex cnx = new Connex();
        cnx.init();
  try {System.out.println("av nt");
               //PreparedStatement q = cnx.connexion.prepareStatement("update into etudiant values(?) where matricule=?");
               PreparedStatement q = cnx.connexion.prepareStatement("update  reservation  SET  accept=? WHERE idReservation=?");
               System.out.println("apre");
               q.setInt(1,1);
               
               q.setInt(2,idRes);
           int  rs=q.executeUpdate();
                           System.out.println("apre"+ rs);
            if(rs==1){
                System.out.println(" Accepter avec succee");
            }
           } catch (SQLException ex) {
                 System.out.println("refuser échouéé");
            } 
    }
    public int getcleidRes(int idetud){
       
         Connex cnx = new Connex();
        cnx.init();
        try {  System.out.println("ffffffffffffffffffffffffffffffffffffffff");
                 String set="select * from reservation where idEtudiant=1 ";
                 Statement commande=cnx.connexion.createStatement();
                 ResultSet  rs=commande.executeQuery(set);
                 System.out.println("ffffffffffffffffffffffffffffffffffffffff");
                     int idRes=Integer.parseInt(rs.getString(1));
                     //int idEtud=rs.getInt(2);
                   
            System.out.println("ma reserva"+idRes);
            return idRes;
            } catch (SQLException ex) {
                System.err.println("pas de get id reser");
                return 0;
            }
        
         
    }
    
}
