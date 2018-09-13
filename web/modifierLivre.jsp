<%-- 
    Document   : modifierLivre
    Created on : 28 nov. 2017, 01:00:42
    Author     : Maha
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
         <form action="ModifierLivre" method="post" class="form-horizontal form-label-left" >
             <label>id Livre</label>
            <input type="text" name="id" value="${livre.idLivre}"><br>
            <label>Titre</label>
            <input type="text" name="titre" value="${livre.titre}"><br>
            <label>Nom auteur</label>
            <input type="text" name="auteur" value="${livre.auteur}" ><br>
            <label>Date Publication</label>
            <input type="date" name="datePub" value="${livre.datePub}"><br>
            <label>Genre</label>
            <input type="text" name="genre" value="${livre.genre}"><br>
            <label>Categorie</label>
            <input type="text" name="categorie" value="${livre.categorie}" ><br>
            <label>quantite</label>
            <input type="number" name="qt" value="${livre.quantiteLiv}"><br>
            <label>Image</label>
             
            <img class="ss" src="image/${livre.path}" width="30%" height="30%" ><br>
           
            <a href="ModifierLivre?id=${livre.idLivre}" class="btn btn-success">lien</a>
            
            <input type="submit" value="Modifier">
            ${res1}
        </form>
    </body>
</html>
