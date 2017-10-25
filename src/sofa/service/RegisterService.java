package sofa.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import sofa.model.User;
import sofa.util.HibernateUtil;

public class RegisterService {
	public boolean registerUser(User user){
		 Session session = HibernateUtil.openSession();
		 if(isUserExists(user)) 
			 return false;	
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(user);		
			 tx.commit();
			 
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}

	public boolean isUserExists(User user){
		 Session session = HibernateUtil.openSession();
		 boolean result = false;
		 Transaction tx = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from User where email='" + user.getEmail()+"'");
			 User u = (User)query.uniqueResult();
			 tx.commit();
			 if(u != null) 
				 result = true;
		 } catch(Exception ex){
			 if(tx != null){
				 tx.rollback();
			 }
		 } finally{
			 session.close();
		 }
		 return result;
	}
	public boolean authenticate(String userName, String password) {
		Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 boolean result = false;
		
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from User where userName='" + userName+"'" +
			 		                                       "and password='" + password+"'" );
			 User u = (User)query.uniqueResult();
			 tx.commit();
			 if(u != null) 
				 result = true;
		 } catch(Exception ex){
			 if(tx != null){
				 tx.rollback();
			 }
		 } finally{
			 session.close();
		 }
		 return result;
		
	}
	public User getUserByUserName(String userName) {
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 User user = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from User where userName='"+userName+"'");
			 user = (User)query.uniqueResult();
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }
		 return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getListOfUsers(){
		 List<User> list = new ArrayList<User>();
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 list = session.createQuery("from User").list();					
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

}
