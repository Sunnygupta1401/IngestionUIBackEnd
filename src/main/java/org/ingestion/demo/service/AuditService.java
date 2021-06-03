package org.ingestion.demo.service;

import java.util.List;

import org.ingestion.demo.model.Audit;
import org.ingestion.demo.model.AuditDetails;

public interface AuditService {
	
	public Audit addAudit(Audit audit);
	
	public void addAuditDetails(List<AuditDetails> listAuditDetails);

}
