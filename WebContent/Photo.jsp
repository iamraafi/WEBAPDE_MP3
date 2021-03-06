<%@page import="models.Photo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        
        .thumbnail {
            width: 100%;
            height: 100%;
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
        }

        .thumbnail:hover {
            opacity: 0.7;
            transform: scale(1.15);
        }

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
        .uphid{
        	display: none;
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
    
    <div class="off-canvas-wrapper">
      <div class="off-canvas-wrapper-inner" data-off-canvas-wrapper>
        <div class="off-canvas-content" data-off-canvas-content>
		    <div class="top-bar">
		      <div class="row">		      
		        <div class="top-bar-left">
		          <ul class="dropdown menu" data-dropdown-menu>
		             <li class="menu-text">
		             <c:choose>
		             	<c:when test="${requestScope.OGUser.equals('')}">
		             		<form method="post" action="/WEBAPDE_MP2/LinkedUser">
		             	</c:when>
		             	<c:otherwise>
		             		<form method="post" action="/WEBAPDE_MP2/LogOut">
		             	</c:otherwise>
		             </c:choose>
		             <input type="hidden" name="USER" value=<%=request.getAttribute("OGUser")%>>
		             <input type="submit" value="Not Facebook" style="background:none;cursor: pointer;border-width:0px;">
		             </form></li>
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
		     		
		            
		            <c:if test="${requestScope.signed}">
		            	<li><form action="/WEBAPDE_MP2/LogOut" method="post"><input type="submit" value="Log out" class="button"/></form></li>
		            </c:if>
		            	
		          	
		          </ul>
		        </div>
		      </div>
		    </div>
          <div class="callout primary">
            <div class="row column">
              <h1 id="album_title">your photos</h1>
            </div>
          </div>
          <div id="PContainer" class="row small-up-2 medium-up-3 large-up-4">
          	<%	ArrayList<Photo> Uphotos=(ArrayList<Photo>)request.getAttribute("Photos");
          	  	for(Photo photo:Uphotos){%>
          	  	<div class="column">
          	  		<img class="thumbnail" id=<%=photo.getName()%> src="/WEBAPDE_MP2/image.html?id=<%=photo.getId()%>">
          	  	</div>		
          	  	<%}%>
          </div>
        
          <c:if test="${requestScope.original}">
          <div class="row">
                <button id="up_button" class="button expanded">upload</button>
          </div>
          <hr>
          <div class="row column">
              <h1 id="album_title">shared photos</h1>
          </div>
          <hr>
          <</c:if>
          
          <%ArrayList<Photo> Sphotos=(ArrayList<Photo>)request.getAttribute("Shared");
          	if(Sphotos!=null){ %>
		  <div id="PContainer" class="row small-up-2 medium-up-3 large-up-4">
          	<%	for(Photo photo:Sphotos){%>
          	  	<div class="column">
          	  		<img class="thumbnail" id=<%=photo.getName()%> src="/WEBAPDE_MP2/image.html?id=<%=photo.getId()%>">
          	  	</div>		
          	  	<%}%>
          </div>
  		 <%}%>
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
    <script src="js.cookie.js"></script>
    <script>
    $(document).ready(function(){
    	var modal=document.getElementById('myModal');
    	var hidup=document.getElementsByClassName("uphid");
        var modalImg=document.getElementById("img01");
        var captionText=document.getElementById("caption");
	        $(".thumbnail").click(function(){
	            modal.style.display="block";
	            modalImg.src=this.src;
	            //var src=this.id;
	            //var title=document.getElementById("title"+this.id).value;

    	   	  //var sharewith=document.getElementById("share"+this.id).value.split(',');
    	   	  //var shared="";
    	   	  //for(var i=0;i<sharewith.length;i++){
    	   		  //shared+="<input type='submit' name='USER' style='background:none;cursor: pointer;border-width:0px;' value='"+sharewith[i]+"'/>";
    	   	  //}
    		 	  //var tag=document.getElementById("tag"+this.id).value.split(',');
    		 	  //var tagged="";
    	   	  //for(var i=0;i<tag.length;i++){
    	   	//	  tagged+="<p>"+tag[i]+"</p>";
    	   	  //}
    		  //var name=document.getElementById("owner"+this.id).value;
    	   	  //var Thtml='<h3>'+title+' by:<a>'+name+'</a></h3>';
    	   	  //var Shtml='<div class="dropdown"><span>shared with</span><div class="dropdown-content"><form action="/WEBAPDE_MP2/LinkedUser" method="POST">'+shared+'</form></div></div>';
    	   	  //var taghtml='<div class="dropdown"><span>tag</span><div class="dropdown-content">'+tagged+'</div></div>';
    	     // 	captionText.innerHTML= Thtml+Shtml+'&emsp;'+taghtml;          
    	    });
    	    $("span.close").click(function(){
    	        modal.style.display="none";
    	        document.getElementById("caption").innerHtml.value="";
    	    })
    	    $('#up_button').click(function(){
    	    	modal.style.display="block";
    	    	modalImg.src="http://placehold.it/600x600";
    	    	document.getElementById('pubbton').style.display="block";
    	    	document.getElementById('pribton').style.display="block";
    	    	document.getElementById('tagin').style.display="block";
	    		document.getElementById('tagbton').style.display="block";
	    		document.getElementById('subm').style.display="block";
    	    	$('#tagbton').click(function(){
    	    		var tagval=document.getElementById('tagin').value;
    	    		var tagcur=document.getElementById('hidtag').value;
    	    		if(tagcur===""){
    	    			document.getElementById('hidtag').value=tagval;
    	    		}else{
    	    			document.getElementById('hidtag').value=tacur+","+tagval;
    	    		}
    	    	});
    	    	$('#sharebton').click(function(){
    	    		var shareval=document.getElementById('shareit').value;
    	    		var sharecur=document.getElementById('hidshare').value;
    	    		if(sharecur===""){
    	    			document.getElementById('hidshare').value=shareval;
    	    		}else{
    	    			document.getElementById('hidshare').value=sharecur+","+shareval;
    	    		}
    	    	});
    	    	$('#pribton').click(function(){
	    	    		document.getElementById('shareit').style.display="block";
	    	    		document.getElementById('sharebton').style.display="block";
	    	    		document.getElementById('privacy').value="private";
    	    	});
    	    	$('#pubbton').click(function(){
    	    		document.getElementById('shareit').style.display="hidden";
    	    		document.getElementById('sharebton').style.display="hidden";
    	    		document.getElementById('privacy').value="public";
	    		});
    	    });
    });
    
    
    
    </script>


  </body>
</html>

