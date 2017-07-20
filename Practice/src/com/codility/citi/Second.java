package com.codility.citi;

public class Second {

	public static void main(String[] args) {
		System.out.println(solution(123));
		System.out.println(solution(12345));
		System.out.println(solution(12333));
		System.out.println(solution(22333));
		System.out.println(solution(1213));
		System.out.println(solution(100));
		System.out.println(solution(1000));
		System.out.println(solution(12000));
	}

	static public int solution(int N) {
		String str = "" + N;
		str = str.trim();
		int count0 = countLength(str, "0") - 1;
		int duplicate = countLength(str, "1") - 1;
		duplicate = duplicate + countLength(str, "2") - 1;
		duplicate = duplicate + countLength(str, "3") - 1;
		duplicate = duplicate + countLength(str, "4") - 1;
		duplicate = duplicate + countLength(str, "5") - 1;
		duplicate = duplicate + countLength(str, "6") - 1;
		duplicate = duplicate + countLength(str, "7") - 1;
		duplicate = duplicate + countLength(str, "8") - 1;
		duplicate = duplicate + countLength(str, "9") - 1;
		if (count0 > 0) {
			if (str.length()-count0==2) count0++;
			duplicate = duplicate + count0;
		}
		if (count0 == 0 && duplicate == 0)
			return fact(str.length());
		else {
			if (duplicate >= 1)
				return calcDiffFact(str, duplicate);
			return 0;
		}
	}

	private static int calcDiffFact(String str, int count) {
		int value = fact((str.length() - count));
		int copyCount = count;
		int multiplier = str.length() - count-1;
		while (copyCount > 0 && multiplier >0) {
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
			return 1;
		} else
			return str.length() - str.replace(subString, "").length();
	}
}
