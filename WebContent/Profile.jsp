<%@page import="models.Photo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Foundation | Welcome</title>
    <link rel="stylesheet" href="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
    <style>
		.dropdown {
		    position: relative;
		    display: inline-block;
		}
		
		.dropdown-content {
		    display: none;
		    position: absolute;
		    background-color: #f9f9f9;
		    min-width: 160px;
		    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		    padding: 12px 16px;
		    z-index: 1;
		}
		
		.dropdown:hover .dropdown-content {
		    display: block;
		}
		 div#album_sample{
            font-size: 0;
            width: 300px;
        }  
        div.gallery{
            margin-bottom: 5px;
            width: 300px;
            margin-right: 5px;
        }
         div.gallery img:hover {
          transform: scale(1.15);
        }


        div.gallery img{
            width:45%;
            height:auto;
            margin-bottom: 5px;
            margin-right: 5px;
        }
        a.hidden{
            display: none;
        }
        
        .myImg {
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
        }

        .myImg:hover {opacity: 0.7;}

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
        }

        /* Modal Content (image) */
        .modal-content {
            margin: auto;
            display: block;
            width: 80%;
            max-width: 700px;
        }

        /* Caption of Modal Image */
        #caption {
            margin: auto;
            display: block;
            width: 80%;
            max-width: 700px;
            text-align: center;
            color: #ccc;
            padding: 10px 0;
            height: 150px;
        }

        /* Add Animation */
        .modal-content, #caption {    
            -webkit-animation-name: zoom;
            -webkit-animation-duration: 0.6s;
            animation-name: zoom;
            animation-duration: 0.6s;
        }

        @-webkit-keyframes zoom {
            from {-webkit-transform:scale(0)} 
            to {-webkit-transform:scale(1)}
        }

        @keyframes zoom {
            from {transform:scale(0)} 
            to {transform:scale(1)}
        }

        /* The Close Button */
        .close {
            position: absolute;
            top: 15px;
            right: 35px;
            color: #f1f1f1;
            font-size: 40px;
            font-weight: bold;
            transition: 0.3s;
        }

        .close:hover,
        .close:focus {
            color: #bbb;
            text-decoration: none;
            cursor: pointer;
        }

        /* 100% Image Width on Smaller Screens */
        @media only screen and (max-width: 700px){
            .modal-content {
                width: 100%;
            }
        }
    </style>
  </head>
  <body>
    

    <!-- Start Top Bar -->
    <div class="top-bar">
      <div class="row">
        <div class="top-bar-left">
          <ul class="dropdown menu" data-dropdown-menu>
             <li class="menu-text"><input type="submit" value="Not Facebook" style="background:none;cursor: pointer;border-width:0px;"></li>
          </ul>
        </div>
        <div class="top-bar-right">
          <ul class="menu">
            <li><form action="/WEBAPDE_MP2/Search" method="post">
		          <ul class="menu">
		            <li><input type="search" name="key" placeholder="Search"></li>
		            <li><input type="submit" value="Search" class="button"/><li>
		          </ul>
		     </form></li>
            <%if(request.getAttribute("username")!=null) {%>
            	<li><form action="/WEBAPDE_MP2/LogOut" method="post"><input type="submit" value="Log out" class="button"/></form></li>
          	<%}%>
          </ul>
        </div>
      </div>
    </div>
    <!-- End Top Bar -->
    <br>
    <!-- You can now combine a row and column if you just need a 12 column row -->
    

    <div class="row">
      <div class="medium-6 columns">
      	<%ArrayList<Photo> photos=(ArrayList<Photo>)request.getAttribute("photos");%>
      	<%if(photos.size()>0){%>
	        <img class="thumbnail myImg" id=<%=photos.get(0).getLurl()%> src=<%=photos.get(0).getLurl()%>>
	        <input type="hidden" id=<%=("title"+photos.get(0).getLurl())%> value=<%=photos.get(0).getName()%>>
	        <input type="hidden" id=<%=("tag"+photos.get(0).getLurl())%> value=<%=photos.get(0).getHtmlTag()%>>
	        <input type="hidden" id=<%=("share"+photos.get(0).getLurl())%> value=<%=photos.get(0).getHtmlShare()%>>
	        <%}%>
        <div class="row small-up-4">
        <%if(photos.size()>1){%>
          <div class="column">
            <input type="hidden" id=<%=("title"+photos.get(1).getLurl())%> value=<%=photos.get(1).getName()%>>
            <img class="thumbnail myImg" id=<%=photos.get(1).getLurl()%> src=<%=photos.get(1).getLurl()%>>
            <input type="hidden" id=<%=("tag"+photos.get(1).getLurl())%> value=<%=photos.get(1).getHtmlTag()%>>
       	 	<input type="hidden" id=<%=("share"+photos.get(1).getLurl())%> value=<%=photos.get(1).getHtmlShare()%>>
          </div>
          <%} %>
          <%if(photos.size()>2){%>
          <div class=" column">
            <input type="hidden" id=<%=("title"+photos.get(2).getLurl())%> value=<%=photos.get(2).getName()%>>
            <img class="thumbnail myImg" id=<%=photos.get(2).getLurl()%> src=<%=photos.get(2).getLurl()%>>
            <input type="hidden" id=<%=("tag"+photos.get(2).getLurl())%> value=<%=photos.get(2).getHtmlTag()%>>
       	 	<input type="hidden" id=<%=("share"+photos.get(2).getLurl())%> value=<%=photos.get(2).getHtmlShare()%>>
          </div>
          <%} %>
          <%if(photos.size()>3){%>
          <div class="column">
            <input type="hidden" id=<%=("title"+photos.get(3).getLurl())%> value=<%=photos.get(3).getName()%>>
            <img class="thumbnail myImg" id=<%=photos.get(3).getLurl()%> src=<%=photos.get(3).getLurl()%>>
            <input type="hidden" id=<%=("tag"+photos.get(3).getLurl())%> value=<%=photos.get(3).getHtmlTag()%>>
       	 	<input type="hidden" id=<%=("share"+photos.get(3).getLurl())%> value=<%=photos.get(3).getHtmlShare()%>>
          </div>
          <%}%>
          <%if(photos.size()>4){%>
          <div class="column">
            <img class="thumbnail myImg" id=<%=photos.get(4).getLurl()%> src=<%=photos.get(4).getLurl()%>>
            <input type="hidden" id=<%=("title"+photos.get(4).getLurl())%> value=<%=photos.get(4).getName()%>>
            <input type="hidden" id=<%=("tag"+photos.get(4).getLurl())%> value=<%=photos.get(4).getHtmlTag()%>>
       	 	<input type="hidden" id=<%=("share"+photos.get(4).getLurl())%> value=<%=photos.get(4).getHtmlShare()%>>
          </div>
          <%} %>
        </div>
      </div>
    
      <div class="medium-6 large-5 columns">
        <h3><%=request.getAttribute("username") %></h3>
        <p><%=request.getAttribute("description")%></p>
		<form action="/WEBAPDE_MP2/PhotoCheck" method="post"><input type="submit" value="Photos" class="button large expanded"></form>
  
        
        </div>
    </div>

    <div class="column row">
      <hr>
      <ul class="tabs" data-tabs id="example-tabs">
        <li class="tabs-title is-active"><a href="#panel1" aria-selected="true">Reviews</a></li>
      </ul>
      <div class="tabs-content" data-tabs-content="example-tabs">
        <div class="tabs-panel is-active" id="panel1">
          <h4>Posts</h4>
          <div class="media-object stack-for-small">
            <div class="media-object-section">
            </div>
            <div class="media-object-section">
              <h5><%=request.getAttribute("username") %></h5>
              <p>I'm going to improvise. Listen, there's something you should know about me... about inception. An idea is like a virus, resilient, highly contagious. The smallest seed of an idea can grow. It can grow to define or destroy you.</p>
            </div>
          </div>
          <div class="media-object stack-for-small">
            <div class="media-object-section">
            </div>
            <div class="media-object-section">
              <h5><%=request.getAttribute("username") %></h5>
              <p>I'm going to improvise. Listen, there's something you should know about me... about inception. An idea is like a virus, resilient, highly contagious. The smallest seed of an idea can grow. It can grow to define or destroy you</p>
            </div>
          </div>
          <div class="media-object stack-for-small">
            <div class="media-object-section">
            </div>
            <div class="media-object-section">
              <h5><%=request.getAttribute("username") %></h5>
              <p>I'm going to improvise. Listen, there's something you should know about me... about inception. An idea is like a virus, resilient, highly contagious. The smallest seed of an idea can grow. It can grow to define or destroy you</p>
            </div>
          </div>
        </div>
      </div>
    </div>
	<div id="myModal" class="modal">
        <span class="close">&times;</span>
        <img class="modal-content" id="img01">
        <div id="caption"></div>
    </div>


    
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
    <script>
      $(document).foundation();
      $(document).ready(function(){
    	  var modal=document.getElementById('myModal');
          var modalImg=document.getElementById("img01");
          var captionText=document.getElementById("caption");
          
          $(".myImg").click(function(){
              modal.style.display="block";
              modalImg.src=this.id;
              var src=this.id;
              var title=document.getElementById("title"+this.id).value;

	     	  var sharewith=document.getElementById("share"+this.id).value.split(',');
	     	  var shared="";
	     	  for(var i=0;i<sharewith.length;i++){
	     		  shared+="<p>"+sharewith[i]+"</p>"
	     	  }
	 	 	  var tag=document.getElementById("tag"+this.id).value.split(',');
	 	 	  var tagged="";
	     	  for(var i=0;i<tag.length;i++){
	     		  tagged+="<p>"+tag[i]+"</p>"
	     	  }
			  var name=<%
					  	out.print("'");
 			  			out.print((String)request.getAttribute("username"));
 			  			out.println("'");%>;
	     	  var Thtml='<h3>'+title+' by:<a>'+name+'</a></h3>';
	     	  var Shtml='<div class="dropdown"><span>shared with</span><div class="dropdown-content">'+shared+'</div></div>';
	     	  var taghtml='<div class="dropdown"><span>tag</span><div class="dropdown-content">'+tagged+'</div></div>';
	        	captionText.innerHTML= Thtml+Shtml+'&emsp;'+taghtml;           
	        $(".exit").click(function(){
	            Cookies.set("aId",this.id);  
	            window.location="Photos.html";
	        });
	        $(".reload").click(function(){
	            location.reload(); 
	        });
              
          });
          $("span.close").click(function(){
              modal.style.display="none";
          })
      });
    </script>
  </body>
</html>