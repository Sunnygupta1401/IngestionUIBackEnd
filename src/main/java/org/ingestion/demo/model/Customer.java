
package org.ingestion.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Customer table in database
 */
@Entity
@Table(name="CUSTOMER")
public class Customer{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="fileName")
	String fileName;

	@Column(name="frameName")
	String frameName; 

	@Column(name="schemaFileName")
	String schemaFileName;
	
	@Column(name="fileType")
	String fileType; 

	@Column(name="isHeader")
	String isHeader;
	
	@Column(name="fileDelimiter")
	String fileDelimiter; 

	

	public Customer() {
		super();
	}
	public Customer(String fileName,String frameName,String schemaFileName,String fileType,String isHeader,String fileDelimiter) {
		super();
		this.fileName=fileName;
		this.frameName=frameName;
		this.schemaFileName=schemaFileName;
		this.fileType=fileType;
		this.isHeader=isHeader;
		this.fileDelimiter=fileDelimiter;
		
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFrameName() {
		return frameName;
	}
	public void setFrameName(String frameName) {
		this.frameName = frameName;
	}
	public String getSchemaFileName() {
		return schemaFileName;
	}
	public void setSchemaFileName(String schemaFileName) {
		this.schemaFileName = schemaFileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getIsHeader() {
		return isHeader;
	}
	public void setIsHeader(String isHeader) {
		this.isHeader = isHeader;
	}
	public String getFileDelimiter() {
		return fileDelimiter;
	}
	public void setFileDelimiter(String fileDelimiter) {
		this.fileDelimiter = fileDelimiter;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
