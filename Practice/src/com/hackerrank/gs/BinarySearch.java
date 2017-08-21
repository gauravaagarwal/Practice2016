package com.hackerrank.gs;

public class BinarySearch {

	public static void main(String[] args) {
		int k=15;
		int[] array = {1,3,5,7,9,11,13,15,17,19};
		System.out.println(binarySearch(k, array));
		//System.out.println(array[pivotKey]);
	}

	private static int binarySearch(int key, int[] array) {
		int left = 0;
		int right= array.length-1;
		while (left<right){
			int middle=(left+right)/2;
			if (key<array[middle]){
				right=middle-1;
			}else {
				left=middle+1;
			}
			if (array[middle]==key) return middle;
		}
		return -1;
	}

}
