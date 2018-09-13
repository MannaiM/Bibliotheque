<%-- 
    Document   : AjouterLivre
    Created on : 27 nov. 2017, 23:31:47
    Author     : Maha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <!-- Bootstrap -->
    <link href="admin/css/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="admin/css/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="admin/css/vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- iCheck -->
    <link href="admin/css/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
  
    <!-- bootstrap-progressbar -->
    <link href="admin/css/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="admin/css/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="admin/css/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="admin/css/custom.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Hello World!</h1>
        <form action="AjouterLivre" method="post" class="form-horizontal form-label-left" enctype="multipart/form-data">
           <table>
                <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Titre</label></td>
                    <td>
            <input type="text" name="titre" required="required" class="form-control col-md-7 col-xs-12 "></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Nom auteur</label></td>
            <td>
            <input type="text" name="auteur" required="required" class="form-control col-md-7 col-xs-12 "></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">photo</label></td>
            <td>
            <input type="file" name="photo" required="required" ></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">
            <label>Date Publication</label></td>
            <td>
            <input type="date" name="dateNai" required="required" class="form-control col-md-7 col-xs-12 "></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Genre</label></td>
           <td>
               <select name="genre" >
                            <option>educatif</option>
                            <option>documentaire</option>
                            <option>article</option>
                            
                        </select>
             </td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">
            Sujet</label></td>
           <td>
            <input type="text" name="categorie" required="required" class="form-control col-md-7 col-xs-12 "></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12"> quantite</label></td>
              
                <td> <input type="number" name="qt" ></td></tr>
            <tr><td></td><td><input type="submit" value="Ajouter" class="btn btn-success "></td></tr>
            <tr><td> ${message}</td></tr></table>
            
        </form>
    </body>
</html>
