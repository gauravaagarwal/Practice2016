package com.codility.practice;

import java.math.BigInteger;

public class EquilibiriumCodility {

	public static void main(String[] args) {
		int[] A = { -1,3,-4,5,1,-6,2,1 };
		System.out.println(solution(A));
		
	}
	static public int solution(int[] A) {
        BigInteger[] prefixArray = new BigInteger[A.length + 1];
        prefixArray[0] = BigInteger.ZERO;
        for (int i = 0; i < A.length; i++) {
            prefixArray[i + 1] = prefixArray[i].add(BigInteger.valueOf(A[i]));
        }
        for (int i=1;i<prefixArray.length;i++){
        	if (prefixArray[i].equals((prefixArray[prefixArray.length-2].subtract(prefixArray[i]).subtract(prefixArray[i+1]))))
        			return i;
        }
        return 0;
    }
}
