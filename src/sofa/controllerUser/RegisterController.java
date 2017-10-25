package sofa.controllerUser;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import sofa.model.User;
import sofa.service.RegisterService;
@WebServlet("/Register")
@MultipartConfig(maxFileSize = 16177215)
public class RegisterController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String uName = request.getParameter("userName");
		 String password = request.getParameter("password");
		 String email = request.getParameter("email");
		 HttpSession session = request.getSession();
		 InputStream inputStream = null;
		 Part filePart = request.getPart("photo");
		 byte [] bytes = new byte[(int) filePart.getSize()];
		 inputStream = filePart.getInputStream();
		 inputStream.read(bytes);
		 inputStream.close();
	     User user = new User();
		 user.setUserName(uName);
		 user.setPassword(password);
		 user.setEmail(email);
		 user.setPhoto(bytes);
		 String message = " ";
		 String url = " ";
	    
			
		 RegisterService registerService = new RegisterService();
	     boolean result = registerService.registerUser(user);	
	     if (result) {
		        message ="register succsessful";
		        session.setAttribute("message", message);
		        session.setAttribute("user", user);
		        url = "/user/Register.jsp";
		 } else {
			   session.setAttribute("user", user);
		    	url = "/user/LogInForm.jsp";
		 }
	     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		 dispatcher.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		doPost(request, response);
	}
	


}
