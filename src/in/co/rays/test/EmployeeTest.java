package in.co.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.dto.Address;
import in.co.rays.dto.Employee;

public class EmployeeTest {
	
	public static void main(String[] args) {
		
		
		Address addr = new Address();
		addr.setId(1);
		addr.setCity("indore");
		addr.setStreet("mog line");
		addr.setState("mp");
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("sachin");
		emp.setLastName("kalar");
		emp.setEmpAddr(addr);
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
	    Transaction tx = 	session.beginTransaction();
	
	    session.save(emp);
	
     	tx.commit();
	
	    session.close();
		
		
		
		
		

	}

}
