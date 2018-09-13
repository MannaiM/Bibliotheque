<%@include file="MenuEtud.jsp" %>
    <!--BANNER START-->
    
    <div class="kode-inner-banner">
    	<div class="kode-page-heading">
        	<h2>These</h2>
            <ol class="breadcrumb">
              <li><a href="#">Home</a></li>
              <li><a href="#">Memoire Guide</a></li>
              <li class="active">Memoire</li>
            </ol>
        </div>
        <div class="container">
        	<div class="banner-search">
            	<div class="row">
                    <form action="MemoirR" method="post">
                    
                	<div class="col-md-2">
                    	<h2>Search<br> La Memoire</h2>
                    </div>
                    <div class="col-md-4">
                    	<input type="text" name ="nom" placeholder="Enter Your Title">
                    </div>
                    
                    <div class="col-md-2">
                    	<button>Search</button>
                    </div>
                        </form>
                    <form action="MemoirS" method="post">
                    <div class="col-md-2">
                    	<select name ="nom">
                            <option>informatique</option>
                            <option>biologique</option>
                             <option>chimique</option>
                        </select>
                    </div>
                    <div class="col-md-2">
                    	<button>Search</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!--BANNER END-->
    <!--CONTENT START-->
    <form action="ListeMemE" method="post">
    <div class="kode-content padding-tb-50">
        <div class="container">
            <div class="row">
 <c:forEach var="memoire" items="${memoire}">
                <!--LIST ITEM START-->
                <div class="col-md-4 col-sm-6">
                    <div class="kode-single-blog">
                        <figure>
                            <a href="getMemoire?id=${memoire.idThese}" ><img src="image/${memoire.img}" alt=""></a>
                        </figure>
                        <div class="kode-text">
                        	<div class="kode-date">
                            	
                                <span>these</span> 
                            </div>
                        	<h3>${ memoire.sujet }</h3>
                            <p>By : ${ memoire.encadrePar }</p>
                        </div>
                    </div> 
                </div>
            
               
                <!--LIST ITEM END-->
                </c:forEach>
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
    </form>
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
        	<p>Copyrights Maha 2017/2018</p>
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