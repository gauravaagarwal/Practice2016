package com.dao;

import com.beans.Person;

public interface SpringJdbcDao {

	void insertMemDts(Person contact);
	public Person searchMemDts(Person vngmem);
}
