package chen.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckUcode extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String username;
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.reset();
		response.setContentType("text/html;charset=UTF-8");
		//String username = request.getSession().getAttribute("username").toString().trim();
		
		String name = request.getParameter("username").trim();
		if (this.username.equals(username)) {
			response.getWriter().print(true);
		} else {
			response.getWriter().print(false);
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}