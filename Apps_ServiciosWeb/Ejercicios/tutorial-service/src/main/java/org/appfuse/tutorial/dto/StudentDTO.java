package org.appfuse.tutorial.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class StudentDTO {
	private Long studentId;
	private String name;
	private Long count;
	
	public StudentDTO(){
		super();
	}
	
	public StudentDTO(Long studentId, String name, Long count) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.count = count;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", name=" + name + ", count=" + count + "]";
	}

	
	
}
