package in.co.rays.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.dto.UserDTO;

public class HQLQueries {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
  
	   //Query q =	session.createQuery("from UserDTO where firstName like 's%'");
	   
	    Query q1 =  session.createSQLQuery("select * from USERDTO where firstName like 's%'");
	    
	    q1.setCacheable(true);
	  List list =  q1.list();
	  
	  
		 
		 Iterator it = list.iterator();
		 
		 while(it.hasNext()) {
			Object[] dto =  (Object[]) it.next();
			
			System.out.print("\t"+dto[0]);
			System.out.println("\t"+dto[1]);
		 }
		 
	  }
	

}
