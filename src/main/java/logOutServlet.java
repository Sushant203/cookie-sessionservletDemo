

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class logOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        Cookie[] cookies = request.getCookies();
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("userName")) {
	                    cookie.setMaxAge(0);
	                    response.addCookie(cookie);
	                    break;
	                }
	            }
	        }
	        response.sendRedirect("index.html");
	    }

}
