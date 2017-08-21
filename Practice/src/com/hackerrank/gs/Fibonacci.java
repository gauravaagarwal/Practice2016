package com.hackerrank.gs;

public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(calculateFib(9));
		System.out.println(calculateFibv(9));
	}

	static int calculateFib(int number) {
		if (number == 0)
			return 0;
		if (number == 1)
			return 1;
		return calculateFib(number - 1) + calculateFib(number - 2);
	}
	
	static int calculateFibv(int number) {
		if (number == 0)
			return 0;

		int fibn=0;
		int fibn1=1;
		while (number>1){
			int temp=fibn1;
			fibn1=fibn+fibn1;
			fibn=temp;
			number--;
		}
		return fibn1;
	}
}
