package com.ulacit.devappweb.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulacit.devappweb.dao.StudentDao;
import com.ulacit.devappweb.dto.StudentDTO;
import com.ulacit.devappweb.mapper.StudentMapper;
import com.ulacit.devappweb.model.Student;
import com.ulacit.devappweb.service.StudentManager;

@Transactional
@Service("studentManager")
@WebService(serviceName = "StudentService", endpointInterface = "com.ulacit.devappweb.service.StudentManager")
public class StudentManagerImpl extends GenericManagerImpl<Student, Long> implements StudentManager {
	final int maxStatus = 3;
	StudentDao studentDao;

	public StudentManagerImpl() {
	}

	/**
	 * @param dao
	 */
	@Autowired
	public StudentManagerImpl(StudentDao dao) {
		super(dao);
		this.studentDao = dao;
	}

	@Override
	public boolean isValidStudent(String userName, String password) {
		boolean isValidStudent = false;
		StudentDTO studentsDTO = null;
		log.debug("find student by username: " + userName);
		Student student = studentDao.findByUserName(userName);
		studentsDTO = StudentMapper.INSTANCE.studentToStudentDTO(student);
		if (studentsDTO != null) {
			log.debug("student " + userName + " finded");
			if (studentsDTO.getPassword().equals(password)) {
				if (studentsDTO.isStatus()) {
					isValidStudent = true;
					log.debug("student " + userName + " is valid");
				}
			}
		}
		return isValidStudent;
	}

	@Override
	public StudentDTO findStudentById(Long id) {
		Student student = studentDao.get(id);

		if (student != null && student.getAccessCount() != null) {
			// verifying status
			if (student.getAccessCount() > maxStatus) {
				student.setStatus(false);
			}
			student.setAccessCount(student.getAccessCount() + 1);
		}
		StudentDTO studentDTO = StudentMapper.INSTANCE.studentToStudentDTO(student);
		studentDao.save(student);
		return studentDTO;
	}

	@Override
	public List<StudentDTO> getStudents() {
		List<StudentDTO> studentDTOs = null;
		List<Student> student = studentDao.getAll();

		studentDTOs = StudentMapper.INSTANCE.studentstoStudentsDTOs(student);

		return studentDTOs;
	}

}
