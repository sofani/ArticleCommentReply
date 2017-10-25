package sofa.controllerArticle;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import sofa.model.Article;
import sofa.service.ArticleService;
@WebServlet("/articleList")
public class ArticleList extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 ArticleService articleService = new  ArticleService();
	     List<Article> articles =  articleService.getListOfArticles();
	     session.setAttribute("articles", articles);
	     String url = "/article/home.jsp";
	     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	     dispatcher.forward(request, response);        
	 }
	 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	          doGet(request, response);
	 }
}
