package com.ulacit.devappweb.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.appfuse.service.GenericManager;

import com.ulacit.devappweb.dto.StudentDTO;
import com.ulacit.devappweb.model.Student;

@WebService
@Path("/student")
public interface StudentManager extends GenericManager<Student, Long> {
	
	@GET
	@Path("/isValidStudent/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	boolean isValidStudent(@QueryParam("userName") String userName, @QueryParam("password") String password);
	
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	StudentDTO findStudentById(@PathParam("id") Long id);
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	List<StudentDTO> getStudents();
}
