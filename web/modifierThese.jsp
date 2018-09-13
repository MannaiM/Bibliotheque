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
         <form action="ModifierThese" method="post" class="form-horizontal form-label-left" >
            
        </form>
         <form action="ModifierThese" method="post">
             <label>Sujet</label>
            <input type="text" name="id" value="${ these.idThese }"><br>
         <label>Sujet</label>
            <input type="text" name="sujet" value="${ these.sujet }"><br>
            
            <label>Quantite</label>
            <input type="text" name="qt" value="${these.quantite}"><br>
            <label>Faite par</label>
            <input type="text" name="fait" value="${these.faitePar}" ><br>
            <label>encadrer Par</label>
            <input type="text" name="enc" value="${ these.encadrePar }"><br>
            <label>Image</label>
            <img class="ss" src="image/${these.img}" width="50%" height="50%" ><br>
            
            <a href="ModifierThese?id=${these.idThese}" class="btn btn-success">lien</a>
            
            <input type="submit" value="Modifier">
            ${res}
          </form>
    </body>
</html>
