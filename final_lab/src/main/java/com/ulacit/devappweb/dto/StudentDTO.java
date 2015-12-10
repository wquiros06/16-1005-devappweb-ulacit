package com.ulacit.devappweb.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Desarrollo
 *
 */
@XmlRootElement(name = "student")
public class StudentDTO {
	private Long studentId;
	private String userName;
	private String password;
	private Integer accessCount;
	private boolean status;
	
	public StudentDTO() {
		super();
	}
	
	/**
	 * @param studentId
	 * @param userName
	 * @param password
	 * @param accessCount
	 * @param status
	 */
	public StudentDTO(Long studentId, String userName, String password, Integer accessCount, boolean status) {
		super();
		this.studentId = studentId;
		this.userName = userName;
		this.password = password;
		this.accessCount = accessCount;
		this.status = status;
	}
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAccessCount() {
		return accessCount;
	}
	public void setAccessCount(Integer accessCount) {
		this.accessCount = accessCount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
