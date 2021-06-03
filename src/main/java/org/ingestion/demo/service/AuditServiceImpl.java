package org.ingestion.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.ingestion.demo.dao.AuditDao;
import org.ingestion.demo.model.Audit;
import org.ingestion.demo.model.AuditDetails;
import org.ingestion.demo.model.AuditDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("auditService")
public class AuditServiceImpl implements AuditService{
	@Autowired
	private AuditDao auditDao;
	
	@Autowired
	EntityManager em;
	
	@Autowired
	AuditDetailsRepository auditDetailsRepository;

	@Transactional
	public Audit addAudit(Audit audit) {
		// TODO Auto-generated method stub
		return auditDao.addAudit(audit);
	}

	@Override
	@Transactional
	public void addAuditDetails(List<AuditDetails> listAuditDetails) {
		// TODO Auto-generated method stub
		
		auditDetailsRepository.save(listAuditDetails);
		
		
		
	}

}
