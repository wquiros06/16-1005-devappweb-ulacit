package com.ulacit.devappweb.service.impl;

import static org.junit.Assert.assertSame;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.ulacit.devappweb.dao.StudentDao;
import com.ulacit.devappweb.model.Student;

public class StudentManagerImplTest extends BaseManagerMockTestCase {
	
    @InjectMocks
    private StudentManagerImpl manager;

    @Mock
    private StudentDao dao;
    
    @Test
    public void testGetStudent() {
        log.debug("testing get...");
        //given
        final Long id = 1L;
        final Student students = new Student();
        given(dao.get(id)).willReturn(students);

        //when
        Student result = manager.get(id);

        //then
        assertSame(students, result);
    }
    @Test
    public void testGetStudents() {
        log.debug("testing getAll...");
        //given
        final List students = new ArrayList();
        given(dao.getAll()).willReturn(students);

        //when
        List result = manager.getAll();

        //then
        assertSame(students, result);
    }
    
    @Test
    public void testSaveStudents() {
        log.debug("testing save students...");

        //given
        final Student student = new Student();

        given(dao.save(student)).willReturn(student);

        //when
        manager.save(student);

        //then
        verify(dao).save(student);
    }

}
