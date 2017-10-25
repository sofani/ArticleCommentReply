package sofa.controllerArticle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import sofa.model.Article;
import sofa.model.Comment;
import sofa.service.ArticleService;
import sofa.service.CommentService;
@WebServlet("/articleDisplay")
public class ArticleDisplay extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession();
		  int articleId = Integer.parseInt(request.getParameter("Id"));
		  ArticleService articleService = new ArticleService();
		  Article article = articleService.getArticleById(articleId);
		  session.setAttribute("article", article);
        
          String url = "/article/eachArticle.jsp";
	      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	      dispatcher.forward(request, response);
	}

}
