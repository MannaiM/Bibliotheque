<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <%@include file="MenuEtud.jsp" %>
    <!--BANNER START-->
    <div class="kode-inner-banner">
    	<div class="kode-page-heading">
        	<h2>Livres</h2>
            <ol class="breadcrumb">
              <li><a href="#">Home</a></li>
              <li><a href="#">Books Guide</a></li>
              <li class="active">Book</li>
            </ol>
        </div>
        
        <div class="container">
        	<div class="banner-search">
            	<div class="row">
                	<div class="col-md-2">
                    	<h2>Chercher<br> votre livre</h2>
                    </div>
                     <form action="Livrerechereche" method="post">
                    <div class="col-md-4">
                    	<input type="text" placeholder="Enter Your Title" name="nom">
                    </div>
                    <div class="col-md-2">
                        <input type="submit"value="chercher" >
                    </div>
                    </form>
                     <form action="Livreselect" method="post">
                    <div class="col-md-2">
                        <select name="genre">
                            <option>educatif</option>
                            <option>documentaire</option>
                            <option>article</option>
                            
                        </select>
                    </div>
                    <div class="col-md-2">
                    	<input type="submit"value="chercher">
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!--BANNER END-->
    <!--CONTENT START-->
    <div class="kode-content padding-tb-50">
        <div class="container">
            <div class="row">
            
                <!--LIST ITEM START-->
                
                    <c:forEach var="livre" items="${livre}">
                <div class="col-md-4 col-sm-6">
                    <div class="kode-single-blog">
                        <figure>
                        	<a href="getLivre?id=${livre.idLivre}"><img src="image/${livre.path}" alt=""></a>
                        </figure>
                        <div class="kode-text">
                        	<div class="kode-date">
                            	${ livre.datePub }
                                <span>May</span>
                            </div>
                        	<h3>${ livre.titre }</h3>
                            <p>By : ${ livre.auteur }</p>
                        </div>
                    </div> 
                </div>
            
               </c:forEach>   </form> 
                <!--LIST ITEM END-->
            </div>
            <!--PAGINATION START-->
            <nav>
              <ul class="pagination">
                <li>
                  <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                  </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                
                
                <li>
                  <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                  </a>
                </li>
              </ul>
            </nav>
            <!--PAGINATION END-->
        </div>
    </div>
    <!--CONTENT END-->
        <!--NEWSLETTER START-->
    <section class="kode-newsletters">
        <div class="container">
            <!--SECTION CONTENT START-->
            <div class="section-content white">
                <h2>Subscribe to our Newsletter for the latest news.</h2>
                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</p>
            </div>
            <!--SECTION CONTENT END-->
            <div class="input-container">
                <input type="text" placeholder="Subscribe us">
                <button>Subcribe</button>
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
                        <p>Books are your friends, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.</p>
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
                        <p>Books are your friends, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore.</p>
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
<script src="js/dl-menu/modernizr.custom.js"></script>
<script src="js/dl-menu/jquery.dlmenu.js"></script>
<script src="js/classie.js"></script> 
<script src="js/functions.js"></script>
</body>

<!-- Mirrored from kodeforest.net/html/books/store/blog.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 01 Dec 2017 22:17:06 GMT -->
</html>