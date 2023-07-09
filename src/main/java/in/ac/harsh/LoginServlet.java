package in.ac.harsh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	String user_name = null;
	String user_password = null;
	String newpassword = null;
	RequestDispatcher requestDispatcher = null;
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>Welcome</h2>");
		user_name = request.getParameter("user_name");
		user_password = request.getParameter("user_password");
		
		StringBuffer sb = new StringBuffer(user_password);
		newpassword = sb.reverse().toString();
		
		if(user_name != null && user_password != null) {
			if(user_name.equals(newpassword)) {
				HttpSession session = request.getSession();
				session.setAttribute("Authenticator", user_name);
				session.setAttribute("Title", getServletContext().getInitParameter("WebApp"));
				session.setMaxInactiveInterval(15*45);
				requestDispatcher = request.getRequestDispatcher("home.jsp");
			}
			else {
				request.setAttribute("message", "Invalid username/password");
				requestDispatcher = request.getRequestDispatcher("index.jsp");
			}
		}
		else {
			request.setAttribute("message", "please enter username and password");
			requestDispatcher = request.getRequestDispatcher("index.jsp");
		}
		requestDispatcher.forward(request, response);
	}
}
