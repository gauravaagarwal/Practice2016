package com.hackerrank.gs;

public class BiggestNumber {

	public static void main(String[] args) {
		int [] array= {54, 546, 548, 60};
		//raw 5485466054
		System.out.println(findMaxnumber(array).equals(""+6054854654l));
	}

	private static String findMaxnumber(int[] array) {
		
		for (int i=0;i<array.length;i++){
			for (int j=i+1;j<array.length;j++){
				String numi=""+array[i]+array[j];
				String numj=""+array[j]+array[i];
				if (Integer.parseInt(numi)<Integer.parseInt(numj)){
						//array[i]<array[j]){
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		StringBuilder str=new StringBuilder();
		for (int number:array){
			str.append(number);
		}
		return str.toString();
	}

}
