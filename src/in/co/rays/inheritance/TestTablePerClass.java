package in.co.rays.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestTablePerClass {
	
	public static void main(String[] args) {
		
		CreditCardPayment ccp = new CreditCardPayment();
		ccp.setAmount(10);
		ccp.setCcType("debit");
		ccp.setPaymentType("cash");
		
		Cash c = new Cash();
		c.setAmount(11);
		c.setPaymentType("credit");
		
		Cheque ch = new Cheque();
		ch.setAmount(12);
		ch.setChequeNo(101);
		ch.setBankName("SBI");
		ch.setPaymentType("deposite");
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx =  session.beginTransaction();
		
		session.save(ccp);
		
		session.save(ch);
		
		session.save(c);
		
		tx.commit();
		
		session.close();
		
	}

}
