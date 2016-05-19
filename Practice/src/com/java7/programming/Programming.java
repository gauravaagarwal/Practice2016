package com.java7.programming;

public class Programming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="gaurava";
		switch (name){
        
        }
	}
	static class FirstException extends Exception { }
    static class SecondException extends Exception { }
    public void rethrowException(String exceptionName) throws FirstException,SecondException {
    	
    	 
        try {
          if (exceptionName.equals("First")) {
            throw new FirstException();
          } else {
            throw new SecondException();
          }
        } catch (Exception ex) {
          throw ex;
        }
        
       
      }
}
