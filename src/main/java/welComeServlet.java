

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class welComeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        Cookie[] cookies = request.getCookies();
	        boolean loggedIn = false;
	        String username = null;

	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("Sushant")) {
	                    loggedIn = true;
	                    username = cookie.getValue();
	                    break;
	                }
	            }
	        }

	        if (loggedIn) {
	            response.setContentType("text/html");
	            response.getWriter().println("<html><body>");
	            response.getWriter().println("Welcome, " + username + "!");
	            response.getWriter().println("<br><a href='logOutServlet'>Logout</a>");
	            response.getWriter().println("</body></html>");
	        } else {
	            response.sendRedirect("index.html");
	        }
	    }
}
