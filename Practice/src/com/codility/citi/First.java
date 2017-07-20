package com.codility.citi;

public class First {

	public static void main(String[] args) {
		String str = "13+62*7+*";
		System.out.println(solution(str));
		System.out.println(solution("11++"));
		System.out.println(solution("99*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*"));
		

	}

	// calculate math expression using stack
	static public int solution(String str) {
		int [] A = new int[200001];
		int index=0;
		for (char ch : str.toCharArray()) {
			switch (ch){
			case '0':A[index++]=0;break;
			case '1':A[index++]=1;break;
			case '2':A[index++]=2;break;
			case '3':A[index++]=3;break;
			case '4':A[index++]=4;break;
			case '5':A[index++]=5;break;
			case '6':A[index++]=6;break;
			case '7':A[index++]=7;break;
			case '8':A[index++]=8;break;
			case '9':A[index++]=9;break;
			case '+':
				if (index<2) return -1;
				long newVal = A[--index] + A[--index];
				if (newVal > Integer.MAX_VALUE) return -1;
				A[index++]=(int)newVal;
				break;
			case '*':
				if (index<2) return -1;
				long newVal1 = A[--index] * A[--index];
				if (newVal1 > Integer.MAX_VALUE) return -1;
				A[index++]=(int)newVal1;
				break;
			}
		}
		int topValue = A[--index];
		if (topValue <0) return -1;
		return topValue;
	}
}
