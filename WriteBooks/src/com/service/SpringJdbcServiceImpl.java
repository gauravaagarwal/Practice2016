package com.service;

import org.springframework.jdbc.BadSqlGrammarException;

import com.beans.Person;
import com.dao.SpringJdbcDao;

public class SpringJdbcServiceImpl implements SpringJdbcService {
	 
	SpringJdbcDao springJdbcDao;
	public SpringJdbcDao getSpringJdbcDao() {
		return springJdbcDao;
	}
 
	public void setSpringJdbcDao(SpringJdbcDao springJdbcDao) {
		this.springJdbcDao = springJdbcDao;
	}
 
	public Person searchMemDts(Person vngmem) {
		try {
			return springJdbcDao.searchMemDts(vngmem);
		} catch (BadSqlGrammarException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 
	public void insertMemDts(Person MemDtlsbean) {
		springJdbcDao.insertMemDts(MemDtlsbean);
 
	}
 
}
