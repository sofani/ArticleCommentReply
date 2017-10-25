package sofa.service;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sofa.model.Article;
import sofa.util.HibernateUtil;

public class ArticleService {
	public void InsertAnArticle(Article article){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(article);		
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
	@SuppressWarnings("unchecked")
	public ArrayList<Article> getListOfArticles(){
		 ArrayList<Article> list = new ArrayList<Article>();
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 list =  (ArrayList<Article>) session.createQuery("from Article").list();					
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }
		 return list;
	}
	public Article getArticleById(int articleId) {
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 Article article = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from Article where aId='"+articleId+"'");
			 article = (Article)query.uniqueResult();
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }
		 return article;
	}
}
