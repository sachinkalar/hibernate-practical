package in.co.rays.projections;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import in.co.rays.dto.UserDTO;

public class Projection {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(UserDTO.class);

		ProjectionList p = Projections.projectionList();

		// p.add(Projections.property("id"));

		p.add(Projections.property("firstName"));

		criteria.setProjection(p);

		List<String> list = criteria.list();

		Iterator<String> it = list.iterator();


		while (it.hasNext()) {
		String	dto = it.next();

			// System.out.print(dto[0]);
			System.out.println(dto);
		}
		tx.commit();
		session.close();
	}

}
