package sofa.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sofa.model.Comment;
import sofa.model.Reply;
import sofa.util.HibernateUtil;

public class ReplyService {
	public void InsertAReply(Reply reply, int commId){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 
			 tx = session.getTransaction();
			 tx.begin();
			 Comment exComm = (Comment)session.get(Comment.class, commId);
			 exComm.getReplies().add(reply);
			 reply.setComment(exComm);
			 session.saveOrUpdate(reply);	
			 session.saveOrUpdate(exComm);
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
