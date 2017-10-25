package sofa.controllerUser;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sofa.service.RegisterService;

@WebServlet("/LogIn")
public class LogInController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
		String userName = request.getParameter("user");
		String password = request.getParameter("password"); 
		String message = " ";
	    String url = " ";
	   System.out.println(userName);

		
	    RegisterService rs = new RegisterService ();
	    boolean result = rs.authenticate(userName, password);
	    if (result) {
	        message= "log in succsessful";
	        session.setAttribute("message", message);
	        session.setAttribute("userName", userName);
	        url = "/articleList";
	    } else {
	    	 url = "/article/home.jsp";
	    }
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);

}

}
