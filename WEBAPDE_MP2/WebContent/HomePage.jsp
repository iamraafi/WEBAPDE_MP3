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
          <li class="menu-text"><input type="submit" value="Not Facebook" style="background:none;cursor: pointer;border-width:0px;"></li>
        </ul>
      </div>
      <div class="top-bar-right">
      	<ul class="menu">
        	<li><form method="POST" action="/WEBAPDE_MP2/LogIn">
        		<ul class="menu">
        		<li><input type="text" name="username" placeholder="Username"></li>
          		<li><input type="password" name="password" placeholder="Password"></li>
        		<li><input type="submit" value="Log in" class="button"/></li>
        		</ul>
        	</form></li>
        	<li><form method="get" action="/WEBAPDE_MP2/Register">
        		<ul class="menu">
        		<li><input type="submit" value="Register" class="button"/></li>
        		</ul>
        	</form></li>
        </ul>
      </div>
    </div>
    <!-- End Top Bar -->

    <div class="row columns">
      <div class="orbit" role="region" aria-label="Favorite Space Pictures" data-orbit>
        <ul class="orbit-container">
          <button class="orbit-previous" aria-label="previous"><span class="show-for-sr">Previous Slide</span>&#9664;</button>
          <button class="orbit-next" aria-label="next"><span class="show-for-sr">Next Slide</span>&#9654;</button>
          <li class="orbit-slide is-active">
            <img src="http://placehold.it/1200x450">
          </li>
          <li class="orbit-slide">
            <img src="http://placehold.it/1200x450">
          </li>
          <li class="orbit-slide">
            <img src="http://placehold.it/1200x450">
          </li>
          <li class="orbit-slide">
            <img src="http://placehold.it/1200x450">
          </li>
        </ul>
      </div>
    </div>

    <div class="row column text-center">
      <h1>Welcome to not facebook</h1>
      <p class="lead">It's just like facebook but not facebook</p>
      <ul class="menu">
            <li><form action="/WEBAPDE_MP2/Search" method="post">
		          <ul class="menu">
		            <li><input type="search" name="key" placeholder="Search"></li>
		            <li><input type="submit" value="Search" class="button"/><li>
		          </ul>
		     </form></li>
    </div>

    <hr>
    
    <div class="row">
      <div class="medium-6 large-3 columns">
        <h3>Lorum</h3>
        <p>Vivamus luctus urna sed urna ultricies ac tempor dui sagittis. In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna.</p>
      </div>
      <div class="medium-6 large-3 columns">
        <h3>Ipsum</h3>
        <p>Vivamus luctus urna sed urna ultricies ac tempor dui sagittis. In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna.</p>
      </div>
      <div class="medium-6 large-3 columns">
        <h3>Dolor</h3>
        <p>Vivamus luctus urna sed urna ultricies ac tempor dui sagittis. In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna.</p>
      </div>
      <div class="medium-6 large-3 columns">
        <h3>Sit Amet</h3>
        <p>Vivamus luctus urna sed urna ultricies ac tempor dui sagittis. In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna.</p>
      </div>
    </div>
    
    <hr>

    <div class="row column">
      <div class="callout primary text-center">
        <h3>We may not be facebook</h3>
        <p>But we're still really cool since unlike facebook we don't sell your data</p>
      </div>
    </div>

    <hr>

    <div class="row">
      <div class="large-6 columns">
        <h4>Nulla At Nulla Justo, Eget</h4>
        <img class="thumbnail" src="http://placehold.it/700x250">
        <p>Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed molestie augue sit amet leo consequat posuere. Vestibulum ante ipsum primis in.</p>
      </div>
      <div class="large-6 columns">
        <h4>Nulla At Nulla Justo, Eget</h4>
        <img class="thumbnail" src="http://placehold.it/700x250">
        <p>Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed molestie augue sit amet leo consequat posuere. Vestibulum ante ipsum primis in.</p>
      </div>
    </div>

    <hr>

    
    
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
    <script>
      $(document).foundation();
    </script>
  </body>
</html>
