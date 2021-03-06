<%-- 
    Document   : ListerMemoire
    Created on : 3 déc. 2017, 14:02:00
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
         <form action="ListerMemoire" method="post"  class="form-horizontal form-label-left" enctype="multipart/form-data" >
        <h1>Consulter Memoires!</h1>
         <table class="table table-bordered pos " >
                        <thead>
                            <th>
                            id 
                        </th>
                        <th>sujet </th>
                        <th>Encadrant </th>
                        <th>faite par </th>
                        <th>Categorie </th>
                        <th>quantite </th>
                       
                         
                           
                         
                            
                            <c:forEach var="memoire" items="${memoire}">
                                <tr>
                            <td><c:out value="${ memoire.idThese }" /></td> 
                            <td><c:out value="${ memoire.sujet }" /></td>
                            <td><c:out value="${ memoire.encadrePar }" /></td>
                            <td><c:out value="${ memoire.faitePar }" /></td>
                            <td><c:out value="${ memoire.quantite }" /></td>
                            <td><c:out value="${ memoire.categorie }" /></td>
                            <td><img class="ss" src="image/${memoire.img}" width="50%" height="50%"></td>
                            
                            <td> <a href="ModifierThese?id=${memoire.idThese}" class="btn btn-success">Modifier</a>
                                <td> <a href="supprimerThese?id=${memoire.idThese}" class="btn btn-danger">Supprimer</a>
                            
                            </tr>
                        </c:forEach>
                            
                        </tbody>
                      </table>
          
         </form>
        </body>
</html>