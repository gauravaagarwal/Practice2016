package practice.junit;

import java.util.ArrayList;

import org.junit.Test;

public class UnCaughtException {

	

	@Test
	public void testIndexOutOfBoundsExceptionNotRaised() 
	    throws IndexOutOfBoundsException {
	 
	    ArrayList emptyList = new ArrayList();
	    Object o = emptyList.get(0);
	}
	
	@Test
	public void testIndexOutOfBoundsExceptionNotRaised2() 
	     {
	 
	    ArrayList emptyList = new ArrayList();
	    Object o = emptyList.get(0);
	}
	

}
