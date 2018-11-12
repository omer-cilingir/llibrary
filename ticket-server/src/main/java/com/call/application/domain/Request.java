package com.call.application.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.call.application.domain.base.BaseEntity;
import com.call.application.enums.Process;


@Entity
@Table(name = "request")
public class Request extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Size(max = 200)
	private String requestContent;
	
	private String priority;

	@ManyToOne(fetch = FetchType.EAGER)
	Category category;
	
	//This date only keeps the request time !!! 
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	Date createdDate; 
	
	@Enumerated(EnumType.STRING)
	Process process;
	
	@Size(max = 50)
	String fileUrl;
	
	int state;
	
	@ManyToOne
	public User user;
	
	public Request() {
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String toString(){
		return String.format("Request[requestContent:%s , createDate:%s]", 
				this.requestContent, this.createdDate);
	}
}
