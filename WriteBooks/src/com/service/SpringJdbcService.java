package com.service;

 
import com.beans.Person;
 
public interface SpringJdbcService {
 
	Person searchMemDts(Person vngmem);
 
	void insertMemDts(Person MemDtlsbean);
 
}
