package com.hackerrank.gs;

public class FactorialCheck {
	private static final int NUMBER_TO_CHECK=10;
	public static void main(String[] args) {
		assertMe(isFactor(10)==true);
		assertMe(isFactor(1)==true);
		assertMe(isFactor(5)==true);
		assertMe(isFactor(2)==true);
		assertMe(isFactor(11)==false);
		assertMe(isFactor(3)==false);
		assertMe(isFactor(9)==false);
		assertMe(isFactor(6)==false);
		assertMe(isFactor(0)==false);
	}
	static boolean isFactor(int possibleFactor){
		if (possibleFactor!=0 && NUMBER_TO_CHECK%possibleFactor==0){
			return true;
		}
		return false;
	}
	static void assertMe(boolean status){
		System.out.println(status);
	}
}
