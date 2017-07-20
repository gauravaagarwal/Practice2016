package com.codility.citi;

public class Third {

	public static void main(String[] args) {
		System.out.println(solution("10:30", "10:31"));
		System.out.println(solution("10:00", "13:21"));
		System.out.println(solution("9:42", "11:42"));
		System.out.println(solution("9:2", "11:02"));

	}

	public static int solution(String E, String L) {
		int diff=time(L.trim())-time(E.trim());
		int hours = diff/60;
		if (diff%60>0) hours++;
		int cost=2+3;
		if (hours>1){
			cost += (hours-1)*4;
		}
		return cost;
	}
	static int  time(String str){
		int i =0;
		String s[] = str.split(":");
			i=Integer.parseInt(s[0])*60;
			i+=Integer.parseInt(s[1]);
		return i;
	}
}
