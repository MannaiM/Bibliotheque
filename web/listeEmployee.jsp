<%-- 
    Document   : listeEmployee
    Created on : 2 déc. 2017, 23:41:39
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
        <form action="listerEmployee" method="post" class="form-horizontal form-label-left" enctype="multipart/form-data">
        <h1>Hello World!</h1>
         <table class="table table-bordered pos " >
                        <thead>
                            <th>
                           Cin
                        </th>
                        <th>Nom </th>
                        <th>Prenom </th>
                        <th>Adresse </th>
                        <th>date Naissance </th>
                        <th>date Embauche </th>
                        <th>photo </th>
                       
                         <c:forEach var="employee" items="${employee}">
                                <tr>
                            <td><c:out value="${ employee.cin }" /></td> 
                            <td><c:out value="${ employee.nomEmp }" /></td>
                            <td><c:out value="${ employee.prenomEmp }" /></td>
                             <td><c:out value="${ employee.dateNais }" /></td>
                              <td><c:out value="${ employee.adresse }" /></td>
                               <td><c:out value="${ employee.dateEmbauche }" /></td>
                                <td><c:out value="${ employee.path }" /></td>
                                <td><img class="ss" src="image/${employee.path}" width="50%" height="50%"></td>
                                <td> <a href="ModifierEmployee?id=${employee.cin}" class="btn btn-success">Modifier</a></td>
                                <td> <a href="SupprimerEmployee?id=${employee.cin}" class="btn btn-danger">Supprimer</a></td>
                            
                            </tr>
                        </c:forEach>
                            
                        </tbody>
                      </table>
        ${res1}
        
         </form>
    </body>
</html>
