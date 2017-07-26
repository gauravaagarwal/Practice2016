package com.codility.citi;

public class Second {

	public static void main(String[] args) {
		System.out.println(solution(123) == 6);
		System.out.println(solution(12345) == 120);
		System.out.println(solution(12333) == 20);
		System.out.println(solution(22333) == 10);
		System.out.println(solution(1213) == 12);
		System.out.println(solution(100) == 1);
		System.out.println(solution(1000) == 1);
		System.out.println(solution(12000));
	}

	static public int solution(int N) {
		String str = "" + N;
		str = str.trim();
		int count0 = countLength(str, "0");
		int duplicateFact = fact(countLength(str, "1"));
		duplicateFact = duplicateFact * fact(countLength(str, "2"));
		duplicateFact = duplicateFact * fact(countLength(str, "3"));
		duplicateFact = duplicateFact * fact(countLength(str, "4"));
		duplicateFact = duplicateFact * fact(countLength(str, "5"));
		duplicateFact = duplicateFact * fact(countLength(str, "6"));
		duplicateFact = duplicateFact * fact(countLength(str, "7"));
		duplicateFact = duplicateFact * fact(countLength(str, "8"));
		duplicateFact = duplicateFact * fact(countLength(str, "9"));

		if (count0 >= 1)
			return calcDiffFact(str, count0);
		return fact(str.length())/duplicateFact;
	}

	private static int calcDiffFact(String str, int count) {
		int value = fact((str.length() - count));
		int copyCount = count;
		int multiplier = str.length() - count;
		while (copyCount > 0 && multiplier > 0) {
			value = value * multiplier;
			copyCount--;
		}
		return value;
	}

	private static int fact(int length) {
		int value = 1;
		while (length > 1) {
			value = value * length;
			length--;
		}
		return value;
	}

	private static int countLength(String str, String subString) {
		if ((str.length() - str.replace(subString, "").length()) == 0) {
			return 0;
		} else
			return str.length() - str.replace(subString, "").length();
	}
}
