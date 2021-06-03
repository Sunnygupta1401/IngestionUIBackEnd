package org.ingestion.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="audit_details")
public class AuditDetails {
	
	@Id
	@JsonProperty("JOB_ID")
	int JOB_ID;

	@JsonProperty("RUN_ID")
	int RUN_ID;
	
	@JsonProperty("JOB_NAME")
	String JOB_NAME;
	
	@JsonProperty("KEY_1")
	String KEY_1;
	
	@JsonProperty("VALUE_1")
	String VALUE_1;
	
	public AuditDetails() {}

	public int getJOB_ID() {
		return JOB_ID;
	}

	public void setJOB_ID(int jOB_ID) {
		JOB_ID = jOB_ID;
	}

	public int getRUN_ID() {
		return RUN_ID;
	}

	public void setRUN_ID(int rUN_ID) {
		RUN_ID = rUN_ID;
	}

	public String getJOB_NAME() {
		return JOB_NAME;
	}

	public void setJOB_NAME(String jOB_NAME) {
		JOB_NAME = jOB_NAME;
	}

	public String getKEY_1() {
		return KEY_1;
	}

	public void setKEY_1(String kEY_1) {
		KEY_1 = kEY_1;
	}

	public String getVALUE_1() {
		return VALUE_1;
	}

	public void setVALUE_1(String vALUE_1) {
		VALUE_1 = vALUE_1;
	}
	
	
	

}
