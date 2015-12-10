package com.ulacit.devappweb.dao.hibernate;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ulacit.devappweb.dao.StudentDao;
import com.ulacit.devappweb.model.Student;

@Repository("studentDao")
public class StudentDaoHibernate extends GenericDaoHibernate<Student, Long> implements StudentDao {

	public StudentDaoHibernate() {
		super(Student.class);
	}

	@Override
	public Student findByUserName(String userName) {
		return (Student) getSession().createCriteria(Student.class).add(Restrictions.eq("userName", userName)).uniqueResult();
	}

}
