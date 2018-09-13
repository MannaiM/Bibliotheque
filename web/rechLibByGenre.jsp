<%-- 
    Document   : rechLibByGenre
    Created on : 2 déc. 2017, 14:21:38
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
        <h1>Hello World!</h1>
        <form action="rechLibByGenre" method="post">
        <h1>Hello World!</h1>
<c:forEach var="livre" items="${livre}">
<tr>
<td><c:out value="${ livre.id }" /></td>
<td ><c:out  value="${ livre.titre }" /></td>
<td><c:out value="${ livre.auteur }" /></td>
<td><c:out value="${ livre.datePub }" /></td>
<td><c:out value="${ livre.categorie }" /></td>
<td><c:out value="${ livre.quantiteLiv }" /></td>

<td><a class="btn btn-warning" href="Detail?id=${livre.id}"><i class="glyphicon glyphicon-plus-sign"> </i>  detail</a>
    <c:if test="${user==null}"><span class="btn btn-danger d">you want to connect to revert </span></c:if>
    <c:if test="${user!=null}"><a class="btn btn-success" style="width: 80px;" href="reserver?id1=${livre.id}"><i class="glyphicon glyphicon-ok" > </i>   book</a></c:if></td>
</td>
</tr>
</c:forEach>   </form>
    </body>
</html>
