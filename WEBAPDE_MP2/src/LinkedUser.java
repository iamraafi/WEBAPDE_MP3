

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Person;
import utility.Locate;

/**
 * Servlet implementation class LinkedUser
 */
@WebServlet("/LinkedUser")
public class LinkedUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LinkedUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String check = "";
	    Cookie[] cookies = null;
	    Cookie User=null;
	    // Get an array of Cookies associated with this domain
	    cookies = request.getCookies();
	    for(int i=0;i<cookies.length;i++){
	    	if(cookies[i].getName().equals("User"))User=cookies[i];
	    	
	    }
	    for(int i=0;i<cookies.length;i++){
	    	if(cookies[i].getName().equals("User")){
	    		System.out.print("no "+cookies[i].getValue());
	    	}
	    }
	    if(User!=null){
	    	check=User.getValue();
	    }

		String user=(String)request.getParameter("USER");
		Person person=Locate.findPerson(user);
		
		if(user.equals(check)){
			System.out.println("sam user");
			request.setAttribute("Ousername" , person.getUsername());
    		request.setAttribute("username" , person.getUsername());
    		request.setAttribute("description" , person.getDescription());
    		request.setAttribute("photos" , person.getPhotoList());
    		request.getRequestDispatcher("/Profile.jsp").forward(request, response);
		}
		else{
			System.out.println("differeent user");
			request.setAttribute("Ousername" , person.getUsername());
    		request.setAttribute("username" , person.getUsername());
    		request.setAttribute("description" , person.getDescription());
    		request.setAttribute("photos" , person.getPhotoList());
    		request.getRequestDispatcher("/OProfile.jsp").forward(request, response);
		}
	}

}
