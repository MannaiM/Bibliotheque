<%-- 
    Document   : listeDemandeEtudiant
    Created on : 4 déc. 2017, 01:09:49
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
         <form action="listeAjout" method="post" class="form-horizontal form-label-left" enctype="multipart/form-data">>
        <h1>Hello World!</h1>
         <table class="table table-bordered pos " >
                        <thead>
                            <th>
                            Matricule
                        </th>
                        <th>Nom </th>
                        <th>Prenom </th>
                        <th>date Naissanc </th>
                        <th>Classe </th>
                        <th>Filiaire </th>
                        <<th>Image </th>
         </thead>
                         
                           
                         
                            
                            <c:forEach var="etudiant" items="${etudiant}">
                                <tr>
                            <td><c:out value="${ etudiant.matricule }" /></td> 
                            <td><c:out value="${ etudiant.nom }" /></td>
                            <td><c:out value="${ etudiant.prenom }" /></td>
                            <td><c:out value="${ etudiant.dateNai }" /></td>
                            <td><c:out value="${ etudiant.classe }" /></td>
                            <td><c:out value="${ etudiant.filiaire }" /></td>
                            <td><c:out value="${ etudiant.path }" /></td>
                            <td><img class="ss" src="images/${etudiant.path}" width="50%" height="50%"></td>
                            <td> <a href="accepterEtudiant?id=${etudiant.matricule}" class="btn btn-success">Accepter</a>
                                <td> <a href="SupprimerEtudiant?id=${etudiant.matricule}" class="btn btn-danger">Supprimer</a>
                            
                            </tr>
                        </c:forEach>
                            
                        </tbody>
                      </table>
        ${res1}
        
         </form>
    </body>
</html>

