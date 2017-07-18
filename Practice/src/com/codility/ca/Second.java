package com.codility.ca;

import java.util.Arrays;

public class Second {

	public static void main(String[] args) {
		int[] A = { 44, 44, 99, 20, 34, 56 };
		System.out.println(solution(A));
	}

	static public int solution(int[] A) {
		Arrays.sort(A);
		int minimum = Math.abs(A[0] - A[1]);
		for (int i = 2; i < A.length - 1; i++) {
			int diff = Math.abs(A[i] - A[i + 1]);
			if (diff < minimum) {
				minimum = diff;
			}
		}
		return minimum;
	}
}
