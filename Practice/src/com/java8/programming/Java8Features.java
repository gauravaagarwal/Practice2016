package com.java8.programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Java8Features {
	
	public static void main(String[] args) {
		forEachLoop();
		Java8.staticMethod();
		new Java8(){}.defaultMethod();
		new Java81(){}.defaultMethod();
		new Java8Features().new Test().defaultMethod();
		
		//No runtime benefit
		 FunctionalInterface obj = (int i)->{
			System.out.println("Too big "+i);
		 };
		 obj.onlyOneMethod(10);
		 FunctionalInterface obj1= new FunctionalInterface(){
			 @Override
				public void onlyOneMethod(int i) {
					System.out.println("Too big ");
				}
		 };
		
	}
	//compile error duplicate default method names with name and parameters inherited from class A and B
	private class Test implements Java8, Java81 {

		@Override
		public void defaultMethod() {
			Java81.super.defaultMethod();
			System.out.println("TeststaticMethod");
		}

		
		
	}
	/**
	 * Java 8 feature of passing logic of for loop as argument.
	 */
	private static void forEachLoop() {
		List<String> listNames= new ArrayList<String>();
		for(int i=0;i<10;i++)listNames.add("Name"+i);
		
		for (String string : listNames) {
			//System.out.println(string);
		}
		Consumer<String> c=new Consumer<String>(){
			public void accept(String str){
				System.out.println(str);
			}
		};
		listNames.forEach(c);
	}
	
	private interface Java8 {
		default public void defaultMethod() {
			System.out.println("Java8defaultMethod");
			
		}
		static public void staticMethod(){
			System.out.println("Java8staticMethod");
		}
	}
	
	private interface Java81 {
		default public void defaultMethod() {
			System.out.println("Java81defaultMethod");
			
		}
		static public void staticMethod(){
			System.out.println("Java81staticMethod");
		}
	}
	
	private interface FunctionalInterface{
		public void onlyOneMethod(int i);
	}
	
	private class DervieFunctionalInterface implements FunctionalInterface{

		@Override
		public void onlyOneMethod(int i) {
			System.out.println("Too big "+i);
		}
		
	}

}
