package com.codility.ca;

public class First {

	public static void main(String[] args) {
		int[] A = { 2, -4, 6, -3, 9 };
		System.out.println(solution(A));
		A = new int[] { 2, -4, 6, -4, 6 };
		System.out.println(solution(A));
		A = new int[] { 1, -3, 7, -3, 9 };
		System.out.println(solution(A));
		A = new int[] { 2, -1, 5, -6, 9 };
		System.out.println(solution(A));

	}

	// count combinations of even sum of two nums in array
	static public int solution(int[] A) {
		int countEven = 0;
		int countOdd = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				countEven++;
			} else {
				countOdd++;
			}
		}
		int evenCombinations = 0;
		int oddCombinations = 0;
		if (countEven != 0) {
			evenCombinations = (countEven * (countEven - 1)) / 2;
		}
		if (countOdd != 0) {
			oddCombinations = (countOdd * (countOdd - 1)) / 2;
		}
		if (evenCombinations + oddCombinations > 1000000000)
			return -1;
		return evenCombinations + oddCombinations;
	}
}
