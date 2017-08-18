

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ImageServices;

/**
 * Servlet implementation class image
 */
@WebServlet("/image.html")
public class image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public image() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("kiss by fire:"+request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id")); // Returns "foo.png".
		byte[] bytes=ImageServices.loadImage(id);
		//if(bytes!=null&&bytes.length>0){
		response.setContentType("image/jpeg");
		ServletOutputStream output=response.getOutputStream();
	    output.write(bytes);
	        	   //response.getOutputStream().flush();
	    output.close();
	           //}
	           /*
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    byte[] content = resultSet.getBytes("content");
	                    response.setContentType(getServletContext().getMimeType(imageName));
	                    response.setContentLength(content.length);
	                    response.getOutputStream().write(content);
	                } else {
	                    response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
	                }
	            }*/
	        
	    
	}
	

}
