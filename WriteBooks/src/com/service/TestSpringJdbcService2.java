package com.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.beans.Person;
import com.dao.SpringJdbcDao;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class TestSpringJdbcService2 {

	@Before
	public void setUp() throws Exception {
	}
	//@InjectMocks annotation is used to create and inject the mock object
	@InjectMocks //service.setSpringJdbcDao(mockSpringJdbcDao);
	SpringJdbcServiceImpl service= new SpringJdbcServiceImpl();
	
	//@Mock annotation is used to create the mock object to be injected
	@Mock //mockSpringJdbcDao=mock(SpringJdbcDao.class);
	SpringJdbcDao  mockSpringJdbcDao;
	 Person person1= new Person("Name","DOB","EMAIL","Phone","address",461030l,"SG");
	 Person person2= new Person("Name","DOB","EMAIL","Phone","address",461030l,"SG");

	@Test
	public void testSearchMemDts() {
		when(mockSpringJdbcDao.searchMemDts(person1)).thenReturn(person1);
		assertEquals(person1,service.searchMemDts(person1));
		assertEquals(person1,service.searchMemDts(person1));
		//verify the behavior if specified method was called or not
		//default call count is 1
		//verify(mockSpringJdbcDao).searchMemDts(person2);
		verify(mockSpringJdbcDao,new Times(2)).searchMemDts(person1);
		//varying number of calls
		verify(mockSpringJdbcDao,atLeastOnce()).searchMemDts(person1);
		verify(mockSpringJdbcDao,atLeast(2)).searchMemDts(person1);
		verify(mockSpringJdbcDao,atMost(2)).searchMemDts(person1);
		//verify(mockSpringJdbcDao).searchMemDts(person2);
	}
	
	@Rule
	public ExpectedException exception=ExpectedException.none();
	
	@Test
	public void testThrowException() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("not implemented");
		doThrow(new RuntimeException("not implemented")).when(mockSpringJdbcDao).searchMemDts(person1);
		mockSpringJdbcDao.searchMemDts(person1);
	}
	
	@Test
	public void testCallBack() {
		when(mockSpringJdbcDao.searchMemDts(person1)).thenAnswer(new Answer<Person>(){

			@Override
			public Person answer(InvocationOnMock invocation) throws Throwable {
				//get the arguments passed to mock
	            Object[] args = invocation.getArguments();
	            
	            //get the mock 
	            Object mock = invocation.getMock();	
				
	            //return the result
				return person1;
			}
			
		});
		
		assertEquals(person1,service.searchMemDts(person1));
	}
	

}
