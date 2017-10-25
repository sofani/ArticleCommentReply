package sofa.controllerArticle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sofa.model.Article;
import sofa.service.ArticleService;
@WebServlet("/articleImage")
public class ImageArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int articleId = Integer.parseInt(request.getParameter("Id"));
		ArticleService articleService = new ArticleService();
		Article article = articleService.getArticleById(articleId);
        byte [] image =  article.getPhoto();
        response.setContentType("image/jpg");
        response.getOutputStream().write(image);;
        response.getOutputStream().flush();
        response.getOutputStream().close();
      
	}
}
