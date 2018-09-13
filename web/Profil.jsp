<%-- 
    Document   : Profil
    Created on : 9 déc. 2017, 15:09:52
    Author     : Maha
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        

<!DOCTYPE html>
<html lang="fr">

        <title>JSP Page</title>
    </head>
    <body>
       <%@include file="MenuEtud.jsp" %>
    <!--BANNER START-->
    
    <div class="kode-inner-banner">
    	<div class="kode-page-heading">
        	<h2>Mon Profil</h2>
            
        </div>
        <div class="container">
        	<div class="banner-search">
            	<div class="row">
                    
                   
                   
                    
                </div>
            </div>
        </div>
    </div>
    <!--BANNER END-->
        <h1>Mon profil!</h1>
        <div class="col-md-9">
                    <!--BOOK DETAIL START-->
                    <form action="Profil" method="post" enctype="multipart/form-data">
                    <div class="lib-book-detail">
                        <div class="row">
                            <div class="col-md-5">
                                <div class="kode-thumb">
                                    <img src="image/${etud.path}" width="200 px" alt="">
                                </div>
                            </div>
                            <div class="col-md-7">
                                <div class="kode-text">
                                	<h2>le nom d'etudiant : </h2>
                                    <div class="product-review">
                                        
                                    </div>
                                    <div class="product-price">
                                        <h4>${etud.nom}</h4>
                                        <p>Prenom : <span class="color">${etud.prenom}</span></p>
                                    </div>
                                    
                                    <div class="book-text">
                                    	
                                        <p>Date naissance ${etud.dateNai}.</p>
                                        <p>filiaire ${etud.filiaire}</p>
                                        <p>classe ${etud.classe}</p>
                                        
                                    </div>
                                       
                                        
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--BOOK DETAIL END-->
                    <!--PRODUCT REVIEW TABS START-->
                    <div class="product-review-tabs">
                        <!--NAV TABS START-->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active"><a href="#Description " aria-controls="Description" role="tab" data-toggle="tab">Description </a></li>
                            
                        </ul>
                        <!--NAV TABS END-->
                        
                    </div>
                    <!--PRODUCT REVIEW TABS END-->
                    
                    </form>
                </div>
                                        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.bxslider.min.js"></script>
<script src="js/bootstrap-slider.js"></script>
<script src="js/waypoints.min.js"></script> 
<script src="js/jquery.counterup.min.js"></script> 
<script src="js/dl-menu/modernizr.custom.js"></script>
<script src="js/dl-menu/jquery.dlmenu.js"></script>
<script src="js/classie.js"></script> 
<script src="js/functions.js"></script>
</body>

    
</html>
