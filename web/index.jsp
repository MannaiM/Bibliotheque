
<!doctype html>
<html lang="en">
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
      <br><br><br>
      <div class="container d" >

          <form class="form-signin" method="post" action="Admin">
        <h2 class="form-signin-heading">Connecter</h2>
        <label for="inputEmail" class="sr-only">Cin</label>
        <input type="number"  class="form-control" placeholder="Cin"  name="Cin"><br>    
        <label for="Password" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="Password">
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
          ${mes}
    </div> <!-- /container -->
  </body>
  <style>
      .d{
          width: 400px;
          height: 500px;
      }
  </style>
</html>
