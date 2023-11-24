package in.co.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.auction.Auction;

public class TestDirtyChecking {
	
	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx  =  session.beginTransaction();
		
	  Auction item =	(Auction) session.get(Auction.class, 1L);
	  
	  item.setDescription("newsachin");
	  
	  tx.commit();
	  
	  session.close();
		
	}

}
