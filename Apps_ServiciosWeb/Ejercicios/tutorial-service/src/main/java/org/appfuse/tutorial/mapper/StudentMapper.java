package org.appfuse.tutorial.mapper;

import java.util.List;

import org.appfuse.tutorial.dto.StudentDTO;
import org.appfuse.tutorial.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
	
	StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

	List<StudentDTO> studentstoStudentsDTOs(List<Student> student);
	
	@Mappings({ 
		@Mapping(source = "studentId", target = "studentId"),	
		@Mapping(source = "name", target = "name"), 
		@Mapping(source = "count", target = "count") 
		})
	StudentDTO studentToStudentDTO(Student student);
}
