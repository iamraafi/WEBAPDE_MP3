<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Foundation | Welcome</title>
    <link rel="stylesheet" href="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
  </head>
  <body>
    
    <!-- Start Top Bar -->
    <div class="top-bar">
      <div class="top-bar-left">
        <ul class="menu">
          <li class="menu-text">Not Facebook</li>
        </ul>
      </div>
    </div>
    <!-- End Top Bar -->

   

    <div class="row column text-center">
      <h1>Not Facebook Register</h1>
      <form style="align:center;left:50%;width:30%;margin:0 auto;" method="post" action="/WEBAPDE_MP2/Register">   
      	<input align="center"style="width:100%" type="text" name="username" placeholder="Username">
      	<span></span>
        <input align="center" style="width:100% " type="password" name="password" placeholder="Password">
        <br>
        <input align="center" style="width:100% " type="text" name="description" placeholder="Description(optional)">
        <br>
        <input style="width:100% "type="submit" value="Register" class="button"/>
      </form>
      
    </div>
    <hr>
    
    

    <hr>

    
    
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
    <script>
      $(document).foundation();
    </script>
  </body>
</html>
