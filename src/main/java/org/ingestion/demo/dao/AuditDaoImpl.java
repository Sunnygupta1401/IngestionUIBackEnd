package org.ingestion.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ingestion.demo.model.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AuditDaoImpl implements AuditDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public Audit addAudit(Audit audit) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.save(audit);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return audit;
	}

}
