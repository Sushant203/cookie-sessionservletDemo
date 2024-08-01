

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
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("userName")) {
	                    loggedIn = true;
	                    response.getWriter().println("Welcome, " + cookie.getValue() + "!");
	                    response.getWriter().println(<a href='logOutServlet'>Logout</a>);
	                    break;
	                }
	            }
	        }
	        if (!loggedIn) {
	            response.sendRedirect("index.html");
	        }
	    }
}
