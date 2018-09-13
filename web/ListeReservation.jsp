<%-- 
    Document   : ListeReservation
    Created on : 4 déc. 2017, 02:47:45
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
        <form action="ListeReservation" method="post"  class="form-horizontal form-label-left" >
        <h1>Hello World!</h1>
        <table class="table table-bordered pos " >
            <thead>
           
                 <th>idRes</th>
                  <th>idEtudian</th>
                   <th>idLivre</th>
                    <th>idMemoire</th>
                     <th>idThese</th>
                     
                    
            
              
            </thead>
<c:forEach var="reserv" items="${reserv}">
<tr>
<td><c:out value="${ reserv.idReservation }" /></td>
<td ><c:out  value="${ reserv.idEtudiant }" /></td>
<td><c:out value="${ reserv.idLivre }" /></td>
<td><c:out value="${ reserv.idThese }" /></td>
<td><c:out value="${ reserv.idMemoire }" /></td>





<td> <a href="detailReser?id=${reserv.idReservation}" class="btn btn-success">Details</a>
<td> <a href="supprimerReser?id=${reserv.idReservation}" class="btn btn-danger">Supprimer</a>
                            
                            
</tr>
</c:forEach>  </table> </form> 
    <!-- jQuery -->
    <script src="admin/css/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="admin/css/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="admin/css/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="admin/css/vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="admin/css/vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="admin/css/vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="admin/css/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="admin/css/vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="admin/css/vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="admin/css/vendors/Flot/jquery.flot.js"></script>
    <script src="admin/css/vendors/Flot/jquery.flot.pie.js"></script>
    <script src="admin/css/vendors/Flot/jquery.flot.time.js"></script>
    <script src="admin/css/vendors/Flot/jquery.flot.stack.js"></script>
    <script src="admin/css/vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="admin/css/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="admin/css/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="admin/css/vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="admin/css/vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="admin/css/vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="admin/css/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="admin/css/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="admin/css/vendors/moment/min/moment.min.js"></script>
    <script src="admin/css/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    

    <!-- Custom Theme Scripts -->
    <script src="admin/js/custom.min.js"></script>
  
    </body>
</html>
