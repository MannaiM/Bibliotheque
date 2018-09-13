<%-- 
    Document   : InscriptionEtudiant
    Created on : 27 nov. 2017, 23:30:10
    Author     : Maha
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Signin Template for Bootstrap</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>

        
    <body>
        <br><br>
      <div class="container d" >
        <h1>Inscription</h1>
        <form action="inscription" method="post" class="form-horizontal form-label-left" enctype="multipart/form-data" >
           
            <table>
                <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12"> <label>Matricule</label></td>
                    <td>
            <input type="number" name="matricule"  required="required" class="form-control col-md-12  "></td></tr>
                <tr><td colspan="2">${mes3}<td></tr>
                <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Nom</label></td>
                    <td><input type="text" name="nom" required="required" class="form-control col-md-12 "></td></tr>
                <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Prenom</label></td>
                    <td>  <input type="text" name="prenom"  required="required" class="form-control col-md-12 "></td></tr>
                <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Classe</label></td>
                    <td> <select name="classe" required="required" class="form-control col-md-12 ">
                <option>1ere Licence</option>
                <option>2eme Licence</option>
                <option>3eme Licence</option>
                 <option>1ere Ingenieurie</option>
                <option>2eme Ingenieurie</option>
                <option>3eme Ingenieurie</option>
                
                        </select>
             </td></tr>
                <tr><td><label class="control-label col-md-3 col-sm-3 col-xs-12">Filiaire </label></td>
                    <td> <select name="filiaire" required="required" class="form-control col-md12 ">
                <option>Informatique</option>
                <option>Biologie</option>
                <option>Industriel</option>
                 <option>Mecatronic</option>
                <option>Gestion</option>
                <option>Droit</option>
                
            </select>
                    </td></tr>
                <tr><td> <label class="control-label col-md-3 col-sm-3 col-xs-12">Date Naissance</label></td>
                    <td><input type="date" name="dateNai" required="required" class="form-control col-md-12 " ></td></tr>
                <tr><td> <label class="control-label col-md-3 col-sm-3 col-xs-12">Image</label></td>
                    <td><input type="file" name="photo" required="required"  ></td></tr>
                <tr><td> <label class="control-label col-md-3 col-sm-3 col-xs-12">Mot PAsse</label></td>
                    <td><input type="password" id="confirmation" name="conf" value="" size="20" maxlength="20" class="form-control" placeholder="Password" required/></td></tr>
                   <tr>   <td> <label for="confirmation" class="sr-only">Confirmation du mot de passe <span class="requis">*</span></label></td>
               
                       <td><input type="text" name="mp" required="required" class="form-control col-md-12 " ></td></tr>
                   <tr><td colspan="2">${mes1}<td></tr>
                <tr><td></td><td><input type="submit"  onclick="al()" value="Abonné"></td></tr>
            </table>
            ${res1}
            ${res2}
        </form>
    </div> <!-- /container -->
  </body>
  <style>
      .d{
          width: 400px;
          height: 500px;
      }
  </style>
  <script>
      function al(){
          alert("votre compte a ete ajouter et vous aller attendre l'acceptation")
      }
      </script>
</html>
