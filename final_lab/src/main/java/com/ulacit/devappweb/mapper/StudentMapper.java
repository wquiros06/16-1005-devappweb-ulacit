package com.ulacit.devappweb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.ulacit.devappweb.dto.StudentDTO;
import com.ulacit.devappweb.model.Student;

@Mapper
public interface StudentMapper {
	StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

	List<StudentDTO> studentstoStudentsDTOs(List<Student> student);
	
	@Mappings({ 
		@Mapping(source = "studentId", target = "studentId"),	
		@Mapping(source = "userName", target = "userName"),
		@Mapping(source = "password", target = "password"), 
		@Mapping(source = "accessCount", target = "accessCount"),
		@Mapping(source = "status", target = "status") 
		})
	StudentDTO studentToStudentDTO(Student student);
}
