package sofa.controllerReply;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sofa.model.Reply;
import sofa.service.ReplyService;
@WebServlet("/replyInsert")
public class InsertReply extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int commentId = Integer.parseInt(request.getParameter("cid")); 
	    String rep = request.getParameter("reply");
	  	String userName = (String) session.getAttribute("userName");
	  	Reply reply = new Reply();
	    reply.setReply(rep);
	    reply.setUserName(userName);
	    ReplyService rs = new ReplyService();
	    rs.InsertAReply(reply,commentId);
	  	String url = "/article/eachArticle.jsp";
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);    
	      
	}

}
