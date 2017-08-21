package com.hackerrank.gs;

public class PerfectSquare {

	public static void main(String[] args) {
		System.out.println(checkSquare(10,100));
		System.out.println(checkSquare(10,1000));
		System.out.println(checkSquare(10,1001));
		System.out.println(checkSquare(10,2));
		System.out.println(checkSquare(10,3));
	}

	public static boolean checkSquare(int key, int number){
		while (number>1){
			if (number%key!=0) 
				return false;
			number = number/key;
		}
		if (number==1)
		return true;
		return false;
	}
}
