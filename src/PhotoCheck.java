

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Person;
import utility.Locate;
import utility.PhotoShared;

/**
 * Servlet implementation class PhotoCheck
 */
@WebServlet("/PhotoCheck")
public class PhotoCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoCheck() {
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
	      Cookie cookie = null;
	      Cookie[] cookies = null;
	      Cookie User=null;
	      // Get an array of Cookies associated with this domain
	      cookies = request.getCookies();
	      for(int i=0;i<cookies.length;i++){
	    	  if(cookies[i].getName().equals("User"))User=cookies[i];
	      }
	      Person p=Locate.findPerson(User.getValue());
	      request.setAttribute("original", true);
	      request.setAttribute("signed", true);
	      request.setAttribute("OGUser", User.getValue());
	      request.setAttribute("Photos", p.getPhotoList());
	      request.setAttribute("Shared", PhotoShared.findShares(p.getUsername()));
	      request.getRequestDispatcher("Photo.jsp").forward(request, response);
	}

}
