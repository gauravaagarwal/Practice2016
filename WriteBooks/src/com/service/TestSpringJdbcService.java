package com.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.beans.Person;
import com.dao.SpringJdbcDao;

public class TestSpringJdbcService {

	@Before
	public void setUp() throws Exception {
		mockSpringJdbcDao=mock(SpringJdbcDao.class);
		when(mockSpringJdbcDao.searchMemDts(person1)).thenReturn(person1);
		service.setSpringJdbcDao(mockSpringJdbcDao);
	}
	SpringJdbcServiceImpl service= new SpringJdbcServiceImpl();
	static SpringJdbcDao  mockSpringJdbcDao;
	static Person person1= new Person();

	@Test
	public void testSearchMemDts() {
		assertEquals(person1,service.searchMemDts(person1));
	}

}
