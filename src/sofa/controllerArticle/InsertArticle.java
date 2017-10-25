package sofa.controllerArticle;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import sofa.model.Article;
import sofa.service.ArticleService;
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/articleInsert")
public class InsertArticle extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("articleUserName");
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String description = request.getParameter("Description");
		InputStream inputStream = null;
		Part filePart = request.getPart("photo");
		byte [] bytes = new byte[(int) filePart.getSize()];
		inputStream = filePart.getInputStream();
		inputStream.read(bytes);
		inputStream.close();
		Article article = new Article();
		article.setUserName(userName);
		article.setTitle(title);
		article.setSummary(summary);
		article.setDescription(description);
		article.setPhoto(bytes);
		
		ArticleService  articleService = new ArticleService();
		articleService.InsertAnArticle(article);
		String url = "/article/home.jsp";
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
}
