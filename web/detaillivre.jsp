<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<%@include file="MenuEtud.jsp" %>
    <!--BANNER START-->
    <div class="kode-inner-banner">
    	<div class="kode-page-heading">
        	<h2>Book Detail</h2>
            <ol class="breadcrumb">
              <li><a href="#">Home</a></li>
              <li><a href="#">Books Guide</a></li>
              <li class="active">Book Detail</li>
            </ol>
        </div>
        <div class="container">
            <a href="detaillivre.jsp"></a>
        	
        </div>
    </div>
    <!--BANNER END-->
  
                </div>
                <div class="col-md-9">
                    <!--BOOK DETAIL START-->
                    <form action="getLivre" method="post" enctype="multipart/form-data">
                    <div class="lib-book-detail">
                        <div class="row">
                            <div class="col-md-5">
                                <div class="kode-thumb">
                                    <img src="image/${livre.path}" alt="">
                                </div>
                            </div>
                            <div class="col-md-7">
                                <div class="kode-text">
                                	<h2>le nom de livre : </h2>
                                    <div class="product-review">
                                        
                                    </div>
                                    <div class="product-price">
                                        <h4>${livre.titre}</h4>
                                        <p>Auteur : <span class="color">${livre.auteur}</span></p>
                                    </div>
                                    <div class="book-text">
                                    	<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto.</p>
                                    </div>
                                    <div class="book-text">
                                    	
                                        <p>Genre: ${livre.genre}.</p>
                                        <p>Autheur: ${livre.auteur}</p>
                                        <p>date Publication: ${livre.datePub}</p>
                                        <p>Quantité disponible: ${livre.quantiteLiv}</p>
                                    </div>
                                        <c:if test="${etud==null}"><a class="add-to-cart btn btn-danger" href="Loginetudiant"> login</a></c:if>
                                        <c:if test="${etud!=null}"><input type="submit" value="Ajouter au panier"  class="add-to-cart">
                                        ${message} </c:if>
                                        
                                    
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
                        <!--TAB PANEL START-->
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane fade in active" id="Description">
                                <p>${livre.categorie}</p>
                                <p><input  hidden="true" type="text" name="id" value="${livre.idLivre}"></p>
                            </div>
                            
                            
                            
                        </div>
                        <!--TAB PANEL END-->
                    </div>
                    <!--PRODUCT REVIEW TABS END-->
                    <!--RELATED PRODUCTS START-->
                    <div class="lib-related-products">
                        <h2>Related Books</h2>
                        <div class="row">
                            <!--PRODUCT GRID START-->
                            <div class="col-md-4">
                                <div class="best-seller-pro">
                                     <figure>
                            	<img src="images/book7.png" alt="">
                            </figure>
                            <div class="kode-text">
                            	<h3><a href="#">Burnt Siena</a></h3>
                            </div>
                            <div class="kode-caption">
                            	<h3>Art History Mystery</h3>
                                <div class="rating">
<span>?</span><span>?</span><span>?</span><span>?</span><span>?</span>
</div>
                                <p>Sara Wisseman</p>
                                <p class="price">$334.50</p>
                                <a href="#" class="add-to-cart">Add To Cart</a>
                                    </div>
                                </div>
                            </div>
                            <!--PRODUCT GRID END-->
                            <!--PRODUCT GRID START-->
                            <div class="col-md-4">
                                <div class="best-seller-pro">
                                    <figure>
                            	<img src="images/book8.png" alt="">
                            </figure>
                            <div class="kode-text">
                            	<h3><a href="#">Chrysalis</a></h3>
                            </div>
                            <div class="kode-caption">
                            	<h3>The Brave Girl</h3>
                                <div class="rating">
<span>?</span><span>?</span><span>?</span><span>?</span><span>?</span>
</div>
                                <p>William S.</p>
                                <p class="price">$24.75</p>
                                <a href="#" class="add-to-cart">Add To Cart</a>
                                    </div>
                                </div>
                            </div>
                            <!--PRODUCT GRID END-->
                            <!--PRODUCT GRID START-->
                            <div class="col-md-4">
                                <div class="best-seller-pro">
                                    <figure>
                            	<img alt="" src="images/book12.png">
                            </figure>
                            <div class="kode-text">
                            	<h3><a href="#">Dead Water</a></h3>
                            </div>
                            <div class="kode-caption">
                            	<h3>Dead Water in the Sea</h3>
                                <div class="rating">
<span>?</span><span>?</span><span>?</span><span>?</span><span>?</span>
</div>
                                <p>Ann Grannger</p>
                                <p class="price">$777.75</p>
                                <a class="add-to-cart" href="#">Add To Cart</a>
                                    </div>
                                </div>
                            </div>
                            <!--PRODUCT GRID END-->
                        </div>
                    </div>
                    <!--RELATED PRODUCTS END-->
                    </form>
                </div>
            </div>
        </div>
        </div>
        <!--NEWSLETTER START-->
    <section class="kode-newsletters">
        <div class="container">
            <!--SECTION CONTENT START-->
            <div class="section-content white">
                <h2>Subscribe to our Newsletter for the latest news.</h2>
                 <p>Update your-self right now! By filling the form below, the lastest information about a thousand books will be sent directly to your email weekly.</p>
            </div>
            <!--SECTION CONTENT END-->
            <div class="input-container">
                <input type="text" placeholder="Subscribe us">
                <button>Subscribe</button>
            </div>
        </div>
    </section>
    <!--NEWSLETTER END-->
    <footer>
    	<div class="container">
        	<div class="row">
            	<!--TEXT WIDGET START-->
            	<div class="col-md-3">
                	<div class="widget widget-text">
                    	<h2>About Us</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.</p>
                        <ul>
                        	<li><i class="fa fa-tags"></i><p>450 fifth Avenue, 34th floor. NYC</p></li>
                            <li><i class="fa fa-phone"></i><p>(+800) 123 4567 890</p></li>
                            <li><i class="fa fa-envelope-o"></i><p><a href="mailto:info@bookstore.com">info@bookstore.com</a></p></li>
                        </ul>
                    </div>
                </div>
                <!--TEXT WIDGET END-->
                <!--TWITTER WIDGET START-->
                <div class="col-md-3">
                	<div class="widget widget-twitter">
                    	<h2>Latest Tweets</h2>
                        <ul>
                        	<li>
                            	<p>There are some amazing submissions in the latest<a href="#"> @tutsplus ?Created by you ?challenge http://t.co/duajgjahuz 16 hour ago</a></p>
                            </li>
                            <li>
                            	<p>There are some amazing submissions in the latest<a href="#"> @tutsplus ?Created by you ?challenge http://t.co/duajgjahuz 16 hour ago</a></p>
                            </li>
                        </ul>
                    </div>
                </div>
                <!--TWITTER WIDGET END-->
                <!--CATEGORY WIDGET START-->
                <div class="col-md-3">
                	<div class="widget widget-categories">
                    	<h2>Information</h2>
                        <ul>
                        	<li><a href="#">Specials</a></li> 
                            <li><a href="#">New products</a></li> 
                            <li><a href="#">Best sellers</a></li> 
                            <li><a href="#">Contact us</a></li> 
                            <li><a href="#">Terms of use</a></li> 
                            <li><a href="#">Sitemap</a></li>  
                        </ul>
                    </div>
                </div>
                <!--CATEGORY WIDGET END-->
                <!--NEWSLETTER START-->
                <div class="col-md-3">
                	<div class="widget widget-newletter">
                    	<h2>Newsletter</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.</p>
                        <input type="text" placeholder="E-mail ID">
                        <button>Subscribe</button>
                    </div>
                </div>
                <!--NEWSLETTER START END-->
            </div>
        </div>
    </footer>
    <div class="copyrights">
    	<div class="container">
        	<p>Copyrights © 2015-16 KodeForest. All rights reserved</p>
            <div class="cards"><img src="images/cards.png" alt=""></div>
        </div>
    </div>
</div>
<!--WRAPPER END-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.bxslider.min.js"></script>
<script src="js/bootstrap-slider.js"></script>
<script src="js/waypoints.min.js"></script> 
<script src="js/jquery.counterup.min.js"></script>
<script src="js/owl.carousel.js"></script>
<script src="js/dl-menu/modernizr.custom.js"></script>
<script src="js/dl-menu/jquery.dlmenu.js"></script>
<script src="js/classie.js"></script> 
<script src="js/functions.js"></script>
</body>

<!-- Mirrored from kodeforest.net/html/books/store/book-detail.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 01 Dec 2017 22:25:03 GMT -->
</html>