

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        // For simplicity, let's assume the username is "user" and the password is "password"
	        if ("userName".equals(username) && "password".equals(password)) {
	            Cookie loginCookie = new Cookie("userName", username);
	            loginCookie.setMaxAge(30 * 60); // 30 minutes
	            response.addCookie(loginCookie);
	            response.sendRedirect("welComeServlet");
	        } else {
	            response.getWriter().println("Invalid username or password.");
	        }
	    }

}
