package in.co.rays.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.auction.Auction;
import in.co.rays.auction.Bid;

public class TestTransitivePersistence {
	
	public static void main(String[] args) {
		
		Bid bid = new Bid();
		bid.setId(6);
		bid.setAmount(199);
		bid.setTimestamp("monday");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx =  session.beginTransaction();
		
		Auction item =   (Auction) session.get(Auction.class, 1L);
		
		Set s = item.getBids();
		
		s.add(bid);
		
		tx.commit();
		
		session.close();
	}

}
