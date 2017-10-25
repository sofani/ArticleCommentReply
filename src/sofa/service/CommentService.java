package sofa.service;



import org.hibernate.Session;
import org.hibernate.Transaction;
import sofa.model.Article;
import sofa.model.Comment;

import sofa.util.HibernateUtil;

public class CommentService {
	public void InsertAComment(Comment comment, int artId){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Article exArt = (Article)session.get(Article.class, artId);
			 exArt.getComments().add(comment);
			 comment.setArticle(exArt);
			 session.saveOrUpdate(comment);	
			 session.saveOrUpdate(exArt);
			 tx.commit();
			 
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		
	}
	
	
	

}
