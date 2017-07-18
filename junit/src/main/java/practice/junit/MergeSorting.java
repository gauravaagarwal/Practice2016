package practice.junit;

public class MergeSorting {

	static int [] array= new int[]{4,77,22,56,12,54,23,98,78,56,32,6,3,2,4,1,22};
	
	public static int[] sort(int a[]){
		for (int i=0;i<a.length;i++){
			for (int j=i+1;j<a.length;j++){
				if (a[i]>a[j]){
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		sort(array);
		for (int i: array)
		System.out.println(i);
	}
}
