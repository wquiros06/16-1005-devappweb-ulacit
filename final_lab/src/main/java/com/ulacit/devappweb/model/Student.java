/**
 * 
 */
package com.ulacit.devappweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Desarrollo
 *
 */

@XmlRootElement
@Entity
@Table(name = "student")
public class Student {
	private Long studentId;
	private String userName;
	private String password;
	private Integer accessCount;
	private boolean status;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id", unique = true, nullable = false)
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	@Column(name = "user_name", length = 50)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "password", length = 50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "access_count")
	public Integer getAccessCount() {
		return accessCount;
	}
	public void setAccessCount(Integer accessCount) {
		this.accessCount = accessCount;
	}
	
	@Column(name = "status")
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessCount == null) ? 0 : accessCount.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (accessCount == null) {
			if (other.accessCount != null)
				return false;
		} else if (!accessCount.equals(other.accessCount))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status != other.status)
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", userName=" + userName + ", password=" + password
				+ ", accessCount=" + accessCount + ", status=" + status + "]";
	}

	
}
