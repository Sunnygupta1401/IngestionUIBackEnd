package org.ingestion.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.ingestion.demo.model.Audit;
import org.ingestion.demo.model.AuditDetails;
import org.ingestion.demo.model.Customer;
import org.ingestion.demo.service.AuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;



@RestController
@RequestMapping("/Ingestion")
public class AuditingController {
	private static final Logger logger = LoggerFactory.getLogger(AuditingController.class);
	@Autowired
	AuditService auditService;


	//@GetMapping(value = "/addAudit")
	@RequestMapping(value = "/addAudit", method = RequestMethod.POST, headers = "Accept=application/json")
	//@ApiIgnore
	public ResponseEntity<String> addAudit(@RequestBody Audit audit) {
		logger.info("Entered addDdsClientConfig()");
		try {
			/*Audit  audit1 = new Audit();
			audit1.setEndTime(new Date());
			audit1.setBytesPerIteration(20);
			audit1.setSourceCount(10);
			audit1.setFilesPerIteration(15);
			audit1.setStartTime(new Date());
			audit1.setTargetRecordCount(30);*/
			
			
			Audit result = auditService.addAudit(audit);
			if (result == null) {
				return new ResponseEntity<>("Not created", HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/*@RequestMapping(value = "/addAudit", method = RequestMethod.POST, headers = "Accept=application/json")
	public Audit addCustomer(@RequestBody Audit audit) {
		return auditService.addAudit(audit);

	}*/
	
	
	@PostMapping(path = "/addAuditDetails",headers = "Accept=application/json")
	public ResponseEntity<String> addAuditDetails(@RequestBody List<AuditDetails> listAuditDetails){
		try
		{
		auditService.addAuditDetails(listAuditDetails);
				return new ResponseEntity<>("success", HttpStatus.OK);

		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
}

