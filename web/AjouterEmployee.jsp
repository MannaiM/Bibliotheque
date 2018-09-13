<%-- 
    Document   : AjouterEmployee
    Created on : 27 nov. 2017, 23:33:58
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Ajouter un employee!</h1>
        <form action="AjouterEmployee" method="post" class="form-horizontal form-label-left" enctype="multipart/form-data">
            <table>
                <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">cin</label></td>
                    <td><input type="text" name="cin" required="required" class="form-control col-md-7 col-xs-12 "></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Nom</label></td>
            <td><input type="text" name="nom" required="required" class="form-control col-md-7 col-xs-12 "></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Prenom</label></td>
            <td><input type="text" name="prenom" required="required" class="form-control col-md-7 col-xs-12 "></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Adresse</label></td>
           <td> <input type="text" name="adresse" required="required" class="form-control col-md-7 col-xs-12 "></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">date Embauche</label></td>
            <td><input type="date" name="dateEmb" required="required" class="form-control col-md-7 col-xs-12 "></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">date Naissance</label></td>
            <td><input type="date" name="dateNai" required="required" class="form-control col-md-7 col-xs-12 "></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Image</label></td>
                <td>  <input type="file" name="photo" required="required" ></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Mot dePasse</label></td>
            <td><input type="text" name="mp" required="required" class="form-control col-md-7 col-xs-12 "></td></tr>
            <tr><td></td><td><input type="submit" value="Ajouter" class="btn btn-success "></td></tr>
            <tr><td collspan="2">${res1}</td></tr></table>
        </form>
    </body>
</html>
