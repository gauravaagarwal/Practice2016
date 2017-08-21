package com.hackerrank.gs;

public class StairCase {
	public static void main(String[] args) {
		System.out.println(calculateHeight(897) + " 41");
		System.out.println(calculateHeight(861) + " 41");
		System.out.println(calculateHeight(12) + " 4");
		System.out.println(calculateHeight(13) + " 4");
		System.out.println(calculateHeight(14) + " 4");
		System.out.println(calculateHeight(15) + " 5");
		System.out.println(calculateHeight(16) + " 5");
		System.out.println(calculateHeight(17) + " 5");
		System.out.println(calculateHeight(99) + " 13");
	}

	/*private static int calculateHeight(int n) {
		int rhs=n*2;
		int lhs=(int)Math.sqrt(rhs);
		if ((lhs*lhs + lhs)/2>n) lhs--;
		return lhs;
	}*/
	
	private static int calculateHeight(int n) {
		int sum=0;
		int i=1;
		for(;sum+i<=n;i++){
			sum+=i;
		}
		return i-1;
	}
}
