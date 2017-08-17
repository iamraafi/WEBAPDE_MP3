

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Person;
import services.PersonServices;
import utility.CreatePersonList;
import utility.LogInCheck;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("watabave");
		CreatePersonList.CreateList();
		Cookie[] cookies = null;
	    Cookie User=null;
	    // Get an array of Cookies associated with this domain
	    cookies = request.getCookies();
	    for(int i=0;i<cookies.length;i++){
	    	if(cookies[i].getName().equals("User")){
	    		cookies[i].setMaxAge(0);;
	    		response.addCookie(cookies[0]);
	    	}
	    }
	    for(int i=0;i<cookies.length;i++){
	
	    		System.out.print("no "+cookies[i].getValue());
	    }
	    
		request.getRequestDispatcher("HomePage.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("/ProtectedPage.jsp").forward(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Person person = PersonServices.login(username, password);
		//Person person=LogInCheck.LoggingIn(request.getParameter("username"),request.getParameter("password"));
    	if(person==null){
    		request.setAttribute("LogError" , "wrong combination of username and password");
    		request.getRequestDispatcher("LogInPage.jsp").forward(request, response);
    		}
    	else{
    		Cookie cookie=new Cookie("User",person.getUsername());
    		response.addCookie(cookie);
    		request.setAttribute("Ousername" , person.getUsername());
    		request.setAttribute("username" , person.getUsername());
    		request.setAttribute("description" , person.getDescription());
    		request.setAttribute("photos" , person.getPhotoList());
    		request.getRequestDispatcher("/Profile.jsp").forward(request, response);
 
    	}
    		
	}

}
