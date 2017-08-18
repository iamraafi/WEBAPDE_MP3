

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Photo;
import utility.Locate;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
	    	PList=Locate.Searching(check,request.getParameter("key"));
			request.setAttribute("signed",true);
			request.setAttribute("OGUser", check);
	    }else{
	    	PList=Locate.Searching("",request.getParameter("key"));
	    	request.setAttribute("signed",false);
	    	request.setAttribute("OGUser", "VISITOR");
	    }
		request.setAttribute("Photos", PList);
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
	}

}
