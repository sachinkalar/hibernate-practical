package in.co.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.auction.Auction;

public class TestDetached {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session  = sf.openSession();
		
	    Auction item =	(Auction) session.get(Auction.class, 1L);
	
	    session.close();
	    
	    item.setDescription("reeema");
	    
	    Session session1 = sf.openSession();
	    
	    Transaction tx =  session1.beginTransaction();
	    
	    session1.update(item);
	    
	    tx.commit();
	    
	    session1.close();
	
	}

}
