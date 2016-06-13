package com.java.practice.recursion;

public class Recursive {

	public static void main(String[] args) {
		/*System.out.println(getFactorial(4));
		System.out.println(isPalin("LEVEL"));
		System.out.println(isPalin("LEVELL"));
		//printFibonacci(1,3);
		System.out.println(reverse("reverse me"));*/
		bubbleSort(new int[]{1,5,3,7,8,92,3,5});
		
		System.out.println("1,5,3,7,8,92,3,5");
		selectionSort(new int[]{1,5,3,7,8,92,3,5});
		insertionSort(new int[]{1,5,3,7,8,92,3,5});
	}

	public static int getFactorial(int n) {
		if (n==1) return n;
		return n*getFactorial(n-1);
	}

	public static boolean isPalin(String str) {
		if (str.length()<2) {return true; }
		if (str.charAt(0)==str.charAt(str.length()-1)) {

			return isPalin(str.substring(1,str.length()-1));
		}
		else return false;
	}
	
	public static int printFibonacci(int start, int count) {
		if (count==0) return start;
		System.out.println(":"+start);
		return printFibonacci(start+1,count--);
	}
	
	public static String reverse(String string){
		if (string.length()==1) return string;
		
		return string.charAt(string.length()-1) + reverse(string.substring(0, string.length()-1));
	}
	
	//start first loop from n, and decrement.
	//start second loop from 0 up to -1 and increment
	//swap if second value is less than first value to take max value to right side
	public static void bubbleSort(int a[]) {
		int n=a.length;
		for (int i=n;i>0;i--){
			for (int j=0;j<i-1;j++){
				if (a[j]>a[j+1])
					swap( a, j,j+1);
			}
		}
		for (int i:a)
		System.out.print(i);
	}

	private static void swap(int a[], int j, int i) {
		int temp=a[j];
		a[j]=a[i];
		a[i]=temp;
		
	}
	
	//find smallest and swap with first
	public static void selectionSort(int a[]) {
		int n=a.length;
		for (int i=0;i<n;i++){
			int smallest=i;
			boolean swapped=false;
			for (int j=1+i;j<n;j++){
				if (a[smallest]>a[j]) {
					smallest=j;
					
				}
					
			}
			System.out.println(smallest);
			 swap( a, i,smallest);
		}
		for (int i:a)
		System.out.print(i);
	}
	
	//find smallest and swap with first
		public static void insertionSort(int a[]) {
			int n=a.length;
			for (int i=1;i<n;i++){
				int key=a[i];
				
				int j=i-1;
				while ((j>-1) && (a[j]>key)){
					
						a[j+1]=a[j];
						j--;
					
						
				}
				a[j+1]=key;
				System.out.println(key);
				 
			}
			for (int i:a)
			System.out.print(i);
		}
}
