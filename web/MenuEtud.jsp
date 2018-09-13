<%-- 
    Document   : MonLivre
    Created on : 4 déc. 2017, 22:04:46
    Author     : Maha
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<!-- Mirrored from kodeforest.net/html/books/store/about-us.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 01 Dec 2017 22:13:29 GMT -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Book Store - Book Guide Author, Publication and Store</title>
<!-- CUSTOM STYLE -->
<link href="style.css" rel="stylesheet" />
<!-- THEME TYPO -->
<link href="css/themetypo.css" rel="stylesheet" />
<!-- BOOTSTRAP -->
<link href="css/bootstrap.css" rel="stylesheet" />
<!-- COLOR FILE -->
<link href="css/color.css" rel="stylesheet" />
<!-- FONT AWESOME -->
<link href="css/font-awesome.min.css" rel="stylesheet" />
<!-- BX SLIDER -->
<link href="css/jquery.bxslider.css" rel="stylesheet" />
<!-- BX SLIDER -->
<link href="css/bootstrap-slider.css" rel="stylesheet" />
<!-- BX SLIDER -->
<link href="css/widget.css" rel="stylesheet" />
<!-- BX SLIDER -->
<link href="css/shortcode.css" rel="stylesheet" />
<!-- responsive -->
<link href="css/responsive.css" rel="stylesheet" />
<!-- Component -->
<link href="js/dl-menu/component.css" rel="stylesheet" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
<div id="loader-wrapper">
	<div id="loader"></div>

	<div class="loader-section section-left"></div>
	<div class="loader-section section-right"></div>

</div>
<!--WRAPPER START-->
<div class="wrapper">
	<!--HEADER START-->
	<header>
    	<div class="top-strip">
        	<div class="container">
            	<div class="site-info">
                   <ul>
                        <c:if test="${etud == null}"><li><a class="btn" href="Loginetudiant">Login</a></li></c:if>
                        <c:if test="${etud != null}"><li><a href="#"><i class="fa fa-envelope-o"></i>${etud.nom} ${etud.prenom}</a></li></c:if>
                        <c:if test="${etud != null}"><li><a href="MaReservation"><i class="fa fa-heart"></i></a></li></c:if>
                        <c:if test="${etud != null}"><li><a href="Panier"><i class="fa fa-shopping-cart"></i></a></li></c:if>
                        <c:if test="${etud != null}"><li><a href="Profil"><i class="fa fa-search">profil</i></a></li></c:if>
                        <c:if test="${etud != null}"><li><a href="Loginetudiant"><i class="fa fa-amazon">deconnection</i></a></li></c:if>
                        
                        
                    </ul>
                </div>
            </div>
        </div>
        <!--Search Overlay Box Starts -->
        <div id="kode_search_box" class="kode_search_box">
            <form class="kode_search_box-form">
                <input class="kode_search_box-input" type="search" placeholder="Search..."/>
                <button class="kode_search_box-submit" type="submit">Search</button>
            </form>
            <span class="kode_search_box-close"></span>
        </div><!-- /kode_search_box -->         
        <div class="overlay"></div>
        <div class="logo-container">
        	<div class="container">
            	<!--LOGO START-->
            	<div class="logo">
                    <a href="#"><img src="images/logo.png" alt=""></a>
                </div>
                <!--LOGO END-->
                <div class="kode-navigation">
                    <ul>
                        <li><a href="about.jsp">Home</a></li>
                        <li><a href="about.jsp">About Us</a></li>
                        <li><a href="ListeLivreE">les Livres</a>
                            <ul>
                                <li><a href="ListeLivreE">Livre</a></li>
								<li><a href="ListeLivreE">Chercher par titre</a></li>
								<li><a href="ListeLivreE">Chercher par genre</a></li>
								
                            </ul>
                        </li>
                        <li class="last"><a href="ListeThese">These</a>
							<ul>
								<li><a href="ListeThese">Liste These</a></li>
								<li><a href="ListeThese"> Chercher par sujet</a></li>								
                            </ul>
						</li>
						<li><a href="ListeMemE">Memoire</a>
                            <ul>
								<li><a href="ListeMemE">chercher par sujet</a></li>
								<li><a href="ListeMemE">Encadrant</a></li>
								
                               
                            </ul>
                        </li>
                        <li class="last"><a href="#">Contact Us</a></li>
                    </ul>
                </div>
				
            </div>
        </div>
    </header>
    <!--HEADER END-->
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
