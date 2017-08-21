package com.hackerrank.gs;

public class MinimumDistance {

	public static void main(String[] args) {
		String inputString = "Ravi had been saying that he had been Ravi he there";
		String firstWord = "Ravi";
		String secondWord = "he";
		String [] strArray = inputString.split(" ");
		int indexFirst = -1,indexSecond=-1;
		int i=0;
		int minimum=Integer.MAX_VALUE;
		for (String str: strArray){
			
			if (str.equals(firstWord)){
				indexFirst=i;
			}
			if (str.equals(secondWord) ){
				indexSecond=i;
			}
			if (indexFirst!=-1 && indexSecond!=-1 && Math.abs(indexSecond-indexFirst)<minimum){
				minimum=Math.abs(indexSecond-indexFirst);
			}
			i++;
		}
		System.out.println(minimum);
	}

}
