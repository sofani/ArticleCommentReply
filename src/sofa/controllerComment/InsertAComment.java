package sofa.controllerComment;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sofa.model.Comment;
import sofa.service.CommentService;
@WebServlet("/commentInsert")
public class InsertAComment extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int articleId = Integer.parseInt(request.getParameter("id"));
	    System.out.println("*********" + articleId);
        String comm = request.getParameter("comment");
        //String userName = (String) session.getAttribute("userName");		
		Comment comment = new Comment();
		comment.setComment(comm);
	    comment.setUserName("s");
	    CommentService cs = new CommentService();
	    cs.InsertAComment(comment,  articleId);
	    

	    String url = null;
	    url = "/article/eachArticle.jsp";
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);
    }
}