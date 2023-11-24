package in.co.rays.subclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestPerSubClass extends Payment{
	
	public static void main(String[] args) {
		
	
	
	CreditCardPayment ccp = new CreditCardPayment();
	ccp.setAmount(29);
	ccp.setCcType("visa");
	ccp.setPaymentType("Cash");
	
	Cash c = new Cash();
	c.setAmount(102);
	c.setPaymentType("cash");

	
	Cheque ch = new Cheque();
	ch.setAmount(123);
	ch.setChequeNo(109);
	ch.setBankName("PUNB");
	ch.setPaymentType("deposite");
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	Session session =  sf.openSession();
	
    Transaction tx =	session.beginTransaction();
    
    session.save(ccp);
    
    session.save(ch);
    
    session.save(c);
    
    tx.commit();
    
    session.close();

}
}