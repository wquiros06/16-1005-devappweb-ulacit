package com.ulacit.devappweb.mapper;

import com.ulacit.devappweb.dto.StudentDTO;
import com.ulacit.devappweb.model.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2015-12-09T14:09:05-0600",
    comments = "version: 1.0.0.CR1, compiler: javac, environment: Java 1.8.0_40 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public List<StudentDTO> studentstoStudentsDTOs(List<Student> student) {
        if ( student == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>();
        for ( Student student_ : student ) {
            list.add( studentToStudentDTO( student_ ) );
        }

        return list;
    }

    @Override
    public StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO_ = new StudentDTO();

        studentDTO_.setStudentId( student.getStudentId() );
        studentDTO_.setAccessCount( student.getAccessCount() );
        studentDTO_.setPassword( student.getPassword() );
        studentDTO_.setUserName( student.getUserName() );
        studentDTO_.setStatus( student.isStatus() );

        return studentDTO_;
    }

}
