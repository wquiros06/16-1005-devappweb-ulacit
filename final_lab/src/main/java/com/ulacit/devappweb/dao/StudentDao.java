package com.ulacit.devappweb.dao;

import org.appfuse.dao.GenericDao;

import com.ulacit.devappweb.model.Student;

public interface StudentDao extends GenericDao<Student, Long> {
	public Student findByUserName(String userName);
}
