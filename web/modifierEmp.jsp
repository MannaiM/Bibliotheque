<%-- 
    Document   : modifierEmp
    Created on : 8 déc. 2017, 23:38:24
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
        <h1>Modifier un employee!</h1>
        <form action="ModifierEmployee" method="post" class="form-horizontal form-label-left" >
            
        </form>
        <form action="ModifierEmployee" method="post" >
            <table>
                <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">cin</label></td>
                    <td><input type="text" name="id"  value="${ employee.cin }"></td></tr>
             <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Nom</label></td>
            <td><c:out value="${ employee.nomEmp }" /></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Prenom</label></td>
            <td><c:out value="${ employee.prenomEmp }" /></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Adresse</label></td>
           <td> <input type="text" name="adressee" required="required" class="form-control col-md-7 col-xs-12 " value="${ employee.adresse }" /></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">date Embauche</label></td>
            <td> <c:out value="${ employee.dateEmbauche }" /></td></tr>
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">date Naissance</label></td>
            <td><c:out value="${ employee.dateNais }" /></td></tr>
            
            <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Mot dePasse</label></td>
            <td><input type="password" name="mpp" required="required" class="form-control col-md-7 col-xs-12 " 
                       value="${ employee.motPasse }"></td></tr>
            <tr><td></td><td><input type="submit" value="Modifier" class="btn btn-success "></td></tr>
            <tr><td collspan="2">${res1}</td></tr></table>
        </form>
    </body>
</html>
