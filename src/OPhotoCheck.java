

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Person;
import models.Photo;
import utility.Locate;
import utility.PhotoShared;

/**
 * Servlet implementation class OPhotoCheck
 */
@WebServlet("/OPhotoCheck")
public class OPhotoCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OPhotoCheck() {
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
		 
	      // Get an array of Cookies associated with this domain
		String check = "";
	    Cookie[] cookies = null;
	    Cookie User=null;
	    // Get an array of Cookies associated with this domain
	    cookies = request.getCookies();
	    for(int i=0;i<cookies.length;i++){
	    	if(cookies[i].getName().equals("User"))User=cookies[i];
	    }
	    ArrayList<Photo> PList=new ArrayList<Photo>();
	    if(User!=null){
	    	check=User.getValue();
	    	request.setAttribute("signed", true);
	    }else{
	    	request.setAttribute("signed", false);
	    }
	    System.out.print("USER: "+check);
	      String user=(String)request.getParameter("store");
	      Person p=Locate.findPerson(user);
	      request.setAttribute("original", false);
	      request.setAttribute("OGUser", check);
	      request.setAttribute("Photos", Locate.OPhotoSearching(check,p.getPhotoList()));
	      request.setAttribute("Shared", null);
	      request.getRequestDispatcher("/Photo.jsp").forward(request, response);
	}

}
