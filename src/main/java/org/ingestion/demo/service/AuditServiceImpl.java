package org.ingestion.demo.service;

import javax.transaction.Transactional;

import org.ingestion.demo.dao.AuditDao;
import org.ingestion.demo.model.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("auditService")
public class AuditServiceImpl implements AuditService{
	@Autowired
	private AuditDao auditDao;

	@Transactional
	public Audit addAudit(Audit audit) {
		// TODO Auto-generated method stub
		return auditDao.addAudit(audit);
	}

}
