package com.java7.programming;

public class Cloning implements Cloneable {
	BaseClass baseClass;
int myInt;
	public static void main(String[] args) throws Exception {
		Cloning c1 =new Cloning(new BaseClass(new Name("Gaurava"),5),10);
		Cloning c2=(Cloning)c1.clone();
		System.out.println(c1);
		System.out.println(c2);
	}
	public Cloning(BaseClass baseClass, int myInt) {
		super();
		this.baseClass = baseClass;
		this.myInt = myInt;
	}
	@Override
	public String toString() {
		return "Cloning [baseClass=" + baseClass + ", myInt=" + myInt + "]";
	}

}


class BaseClass { 
	Name name;
	int inte;
	public BaseClass(Name name, int inte) {
		super();
		this.name = name;
		this.inte = inte;
	}

	
}

class Name {
	
	public Name(String name) {
		super();
		this.name = name;
	}

	String name;

	@Override
	public String toString() {
		return "Name [name=" + name + "]";
	}
	
	
	
}