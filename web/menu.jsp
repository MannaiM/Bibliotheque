<%-- 
    Document   : menu
    Created on : 2 déc. 2017, 20:51:12
    Author     : Maha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
    </head>
   
     
  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <span class="site_title"><i class="fa fa-paw"></i> <span>Maha</span></span>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>Maha :${SESSION_USER.nomEmp}  ${SESSION_USER.prenomEmp}</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
             <div class="menu_section">
                <h3>Menu</h3>
                <ul class="nav side-menu">
                  
                  <li><a><i class="fa fa-edit"></i> Employee  <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="AjouterEmployee">Ajouter employee </a></li>
                      <li><a href="listerEmployee">Consulter employee</a></li>
                     
                    </ul>
                  </li>
                   <li><a><i class="fa fa-edit"></i> Etudiant  <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      
                      <li><a href="listerEtudiant">Consulter les etudiant</a></li>
                      <li><a href="listeAjout">Demande d'ajout des etudiant</a></li>
                    </ul>
                  </li>
                   <li><a><i class="fa fa-edit"></i> Livre  <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="AjouterLivre">Ajouter Livre</a></li>
                      <li><a href="ListeLivre">Consulter les  Livre</a></li>
                      
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i> These <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="AjouterThese">Ajouter These</a></li>
                      <li><a href="ListerThese">Consulter les  Theses</a></li>
                      
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i> Memoire  <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="AjouterThese">Ajouter Memoire</a></li>
                      <li><a href="ListerMemoire">Consulter les  Memoires</a></li>
                      
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i> Reservation  <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="listDemRes">Accepter les Reservation</a></li>
                      <li><a href="ListeReservation">Consulter les  Reservation</a></li>
                      
                    </ul>
                  </li>
                </ul>
              </div>
              

            </div>
            <!-- /sidebar menu -->

           
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                   
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                   
                    <li>
                      <a href="/Biblio/Parametre">
                        
                        <span>parametre</span>
                      </a>
                    </li>
                    
                    <li><a href="/Biblio/adminlog"><i class="fa fa-sign-out pull-right"></i> Deconnecter</a></li>
                  </ul>
                </li>

                
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->
        <!-- page content -->
        <div class="right_col" role="main">
          <!-- top tiles -->
          <div class="row tile_count">
            <div class="x_content">
            <div class="title_left">
                <h3>Bibliotheque</h3>
              </div>
                    <br>
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
