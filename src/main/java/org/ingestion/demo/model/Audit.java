package org.ingestion.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="AUDIT")
public class Audit {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
		private Integer sourceCount;

		private Integer targetRecordCount;
		
		private Integer FilesPerIteration;
		
		private Integer BytesPerIteration;
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
		private Date startTime;
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd hh:mm:ss")
		private Date endTime;
		


		public Integer getSourceCount() {
			return sourceCount;
		}

		public void setSourceCount(Integer sourceCount) {
			this.sourceCount = sourceCount;
		}

		public Integer getTargetRecordCount() {
			return targetRecordCount;
		}

		public void setTargetRecordCount(Integer targetRecordCount) {
			this.targetRecordCount = targetRecordCount;
		}

		public Date getStartTime() {
			return startTime;
		}

		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}

		public Date getEndTime() {
			return endTime;
		}

		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}

		public Integer getFilesPerIteration() {
			return FilesPerIteration;
		}

		public void setFilesPerIteration(Integer filesPerIteration) {
			FilesPerIteration = filesPerIteration;
		}

		public Integer getBytesPerIteration() {
			return BytesPerIteration;
		}

		public void setBytesPerIteration(Integer bytesPerIteration) {
			BytesPerIteration = bytesPerIteration;
		}



		


	}




