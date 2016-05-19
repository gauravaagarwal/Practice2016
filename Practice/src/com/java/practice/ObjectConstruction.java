package com.java.practice;

public class ObjectConstruction {

	public static void main(String[] args) {

	}
	
    public class Parent{
        String name="parent";   
        int age=50;
        Parent() {
            init(55,"55parent");
        }
        protected void init(int _age, String _name) {
            age=_age;
            name=_name;
        }
    }
    public class Child extends Parent{
        String cname="Child";   
        int cage=20;
        int newInt;
        Child(int _age, String _name) {
            age=_age;
            name=_name;
        }
        protected void init(int _age, String _name) {
            cage=_age;
            cname=_name;
            newInt=91;
        }
    }

}
