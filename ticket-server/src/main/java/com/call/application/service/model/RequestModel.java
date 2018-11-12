package com.call.application.service.model;

import java.util.Date;

import com.call.application.domain.User;
import com.call.application.enums.Process;
import com.call.application.service.model.base.BaseModel;

public class RequestModel extends BaseModel{
	
	private String requestContent;
	
	private String priority;
	
	private CategoryModel category;
	
	private Date createDate;
	
	private Process process;
	
	private String fileUrl;
	
	private int state;
	
	private User user;

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

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

}
