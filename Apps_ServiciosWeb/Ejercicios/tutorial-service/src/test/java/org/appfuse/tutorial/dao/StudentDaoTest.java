package org.appfuse.tutorial.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.appfuse.tutorial.model.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class StudentDaoTest extends BaseDaoTestCase {

	@Autowired
	private StudentDao studentDao;

	@Test
	public void testFindStudentByName() throws Exception {
		List<Student> student = studentDao.findByName("Keylor");
		assertTrue(student.size() > 0);
	}

	
	@Test(expected = DataAccessException.class)
	public void testAddAndRemoveStudent() throws Exception {
		Student student = new Student();
		student.setName("Keylor");
		student.setCount(1L);

		student = studentDao.save(student);
		flush();

		student = studentDao.get(student.getStudentId());

		assertEquals("Keylor", student.getName());
		assertNotNull(student.getStudentId());

		log.debug("removing student...");

		studentDao.remove(student.getStudentId());
		flush();

		// should throw DataAccessException
		studentDao.get(student.getStudentId());
	}

}
