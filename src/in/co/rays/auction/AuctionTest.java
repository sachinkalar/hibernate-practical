package in.co.rays.auction;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AuctionTest {
	
	public static void main(String[] args) {
		
		
		Bid bid1 = new Bid();
		bid1.setId(1);
		bid1.setAmount(10000);
		bid1.setTimestamp("rambharose");
		
		
		
		Bid bid2 = new Bid();
		bid2.setId(2);
		bid2.setAmount(20000);
		bid2.setTimestamp("lakhan");
		
		
		Bid bid3 = new Bid();
		bid3.setId(3);
		bid3.setAmount(30000);
		bid3.setTimestamp("jeevan");
		
		
		Set bids = new HashSet();
		bids.add(bid1);
		bids.add(bid2);
		bids.add(bid3);
		
		Auction item = new Auction();
		item.setId(1);
		item.setDescription("sachin");
		item.setBids(bids);
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
	Transaction tx = session.beginTransaction();
	
	session.save(item);
	
	tx.commit();
	
	session.close();
		
	
	}

}
