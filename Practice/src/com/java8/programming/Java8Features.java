package com.java8.programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Java8Features {
	
	public static void main(String[] args) {
		List<String> listNames= new ArrayList<String>();
		for(int i=0;i<10;i++)listNames.add("Name"+i);
		
		for (String string : listNames) {
			//System.out.println(string);
		}
		Consumer c=new Consumer<String>(){
			public void accept(String str){
				System.out.println(str);
			}
		};
		listNames.forEach(c);
	}

}
