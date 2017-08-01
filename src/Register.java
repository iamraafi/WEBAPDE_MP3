

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Person;
import utility.CreatePersonList;
import utility.RegisterUser;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("RegisterPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("username").equals("")
				||request.getParameter("password").equals("")){
			request.setAttribute("RegError" , "username and password is required");
    		request.getRequestDispatcher("RegisterPage.jsp").forward(request, response);
		}else{

			Person person=RegisterUser.TrytoRegister(request.getParameter("username"),
					request.getParameter("password"), request.getParameter("description"));
			if(person==null){
	    		request.setAttribute("RegError" , "username is already taken");
	    		request.getRequestDispatcher("RegisterPage.jsp").forward(request, response);
			}else{
				CreatePersonList.AddPerson(person);
				Cookie cookie=new Cookie("User",person.getUsername());
	    		response.addCookie(cookie);
	    		request.setAttribute("Ousername" , person.getUsername());
	    		request.setAttribute("username" , person.getUsername());
	    		request.setAttribute("description" , person.getDescription());
	    		request.setAttribute("photos" , person.getPhotoList());
	    		System.out.println("teststt");
	    		request.getRequestDispatcher("/Profile.jsp").forward(request, response);
			}
	}
		//System.out.println(person.getUsername());
	}

}
