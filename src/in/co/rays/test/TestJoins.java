package in.co.rays.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.co.rays.auction.Auction;
import in.co.rays.auction.Bid;
import in.co.rays.dto.UserDTO;

public class TestJoins {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
	Criteria criteria =	session.createCriteria(Auction.class);
	
	criteria.setFetchMode("item_id", FetchMode.JOIN);
	
	criteria.add(Restrictions.eq("id", 1L));
			
	List list =	criteria.list();
	
   Iterator it = list.iterator();
   
   while(it.hasNext()) {
	   
	Auction item   =  (Auction) it.next();
	
	System.out.println(item.getId());
	
	System.out.println("\t"+item.getDescription());
	
	Set s =  item.getBids();
	
  Iterator it1 =	s.iterator();
  
  while(it1.hasNext()) {
	  
	Bid object =  (Bid) it1.next();
	
	System.out.println(object.getId());
	System.out.println(object.getAmount());
	System.out.println(object.getTimestamp());
  }
   }
   
   session.close();
	
	
	}

}
