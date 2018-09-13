<%-- 
    Document   : RecherLivByNom
    Created on : 1 déc. 2017, 20:35:28
    Author     : Maha
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="RechLivByNom" method="post">
        <h1>rechercher livre by Nom titre</h1>
        <input type="text"  name="nom">
                   <table>
 
        <c:forEach var="livre" items="${livre}">
<tr>
<td><c:out value="${ livre.id }" /></td>
<td ><c:out  value="${ livre.titre }" /></td>
<td><c:out value="${ livre.auteur }" /></td>
<td><c:out value="${ livre.datePub }" /></td>
<td><c:out value="${ livre.categorie }" /></td>
<td><c:out value="${ livre.quantiteLiv }" /></td>
</tr>


</c:forEach>
</table>
         <input type="submit" value="chercher">
         
        ${res1}
        ${res2}
        </form>
    </body>
</html>
