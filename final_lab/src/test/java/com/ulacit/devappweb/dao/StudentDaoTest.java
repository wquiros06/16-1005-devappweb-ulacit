package com.ulacit.devappweb.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.ulacit.devappweb.model.Student;

public class StudentDaoTest extends BaseDaoTestCase {
	@Autowired
	private StudentDao studentDao;
	
	@Test
	public void testFindByUserName() throws Exception {
		final String userName = "wquiros";
		Student student = null;
		student = studentDao.findByUserName(userName);
		log.debug("find student...");
		assertNotNull(student);
	}
	
	@Test(expected = DataAccessException.class)
	public void testAddAndRemoveStudents() throws Exception {
		final String userName = "emonge";
		final String password = "123";
		final Integer accessCount = 0;
		final boolean status = true;

		Student student = new Student();
		student.setUserName(userName);
		student.setPassword(password);
		student.setAccessCount(accessCount);
		student.setStatus(status);

		student = studentDao.save(student);
		flush();

		student = studentDao.get(student.getStudentId());

		assertEquals(userName, student.getUserName());
		assertNotNull(student);

		log.debug("removing students...");

		studentDao.remove(student.getStudentId());
		flush();

		// should throw DataAccessException
		studentDao.get(student.getStudentId());
	}

}
