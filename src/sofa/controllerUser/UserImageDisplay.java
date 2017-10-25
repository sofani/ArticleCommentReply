package sofa.controllerUser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sofa.model.User;
import sofa.service.RegisterService;
@WebServlet("/displayImageUser")
public class UserImageDisplay extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("UserName");
		RegisterService  rs = new RegisterService();
		User user = rs.getUserByUserName(userName);
        byte [] image = user.getPhoto();
        response.setContentType("image/jpg");
        response.getOutputStream().write(image);;
        response.getOutputStream().flush();
        response.getOutputStream().close();
      
	}

}
