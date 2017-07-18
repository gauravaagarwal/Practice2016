package com.codility.practice;

public class BinaryGap {

	public static void main(String[] args) {
		System.out.println(solution(1047));
		 System.out.println(solution(6));
	}

	public static int solution(int N) {
		int count = 0;
		int number = N;
		int tempCount = 0;
		boolean oneFound = false;
		while (number > 1) {
			if (number % 2 == 1) {
				if (!oneFound) {
					oneFound = true;
				}

				if (tempCount > count) {
					count = tempCount;
					tempCount = 0;
				}

			}
			if (number % 2 == 0 && oneFound) {
				tempCount++;
			}
			//System.out.println(number % 2 + "  " + number + "  " + oneFound + "  " + tempCount);
			number = number / 2;
		}
		
		 if (tempCount>count) { count=tempCount; }
		 
		return count;
	}
}
