package com.codility.practice;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Codility {

    public static void main(String[] args) {
        int[] A = { 2, -4, 6, -3, 9 };
        System.out.println(solution(A));
        int[] AA = { 2000000000, -40000000, 600000000, -3, 999999999 };
       // System.out.println(solution(AA));
        int[] AACC = { 2000000000, -40000000, 600000000, -300000000, 999999999 };
       // System.out.println(solution(AACC));
        
        int[] A1={0,1,2,2,3,5};
        int[] B1={500000,500000,0,0,0,20000};
        //System.out.println(solution(A1,B1));
        //Performance.main(null);
        //StairCase(6);
    }

    static public int solution(int[] A) {
        BigInteger[] prefixArray = new BigInteger[A.length + 1];
        prefixArray[0] = BigInteger.ZERO;
        for (int i = 0; i < A.length; i++) {
            prefixArray[i + 1] = prefixArray[i].add(BigInteger.valueOf(A[i]));
        }
        Arrays.sort(prefixArray);
        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < prefixArray.length - 1; i++) {
            BigInteger currentDifference = (prefixArray[i]
                    .subtract(prefixArray[i + 1])).abs();
            if (BigInteger.valueOf(difference).compareTo(currentDifference) > 0) {
                difference = currentDifference.intValue();
            }
        }
        return difference;
    }

   static public int solution(int[] A, int[] B) {
        if (A.length != B.length) {
            return 0;
        }
        if (A.length < 2) {
            return 0;
        }
        int counter=0;
        for (int i = 0; i < A.length-1; i++) {
            for (int j=i+1;j<A.length;j++) {
                long multiplication=(get(A[i],B[i])*get(A[j],B[j]))/DECIMAL_MULTIPLIER;
                long addition=get(A[i],B[i])+get(A[j],B[j]);
                if (multiplication>=addition) {
                    counter++;
                }
            }

        }
        return counter;
    }
   private static int DECIMAL_MULTIPLIER=1000000;
  static  private long get(int real, int decimal) {
        return (long)real * DECIMAL_MULTIPLIER + (long)decimal;
    }
  
  public static class Performance {
      public static void mains(String[] args){
          Vector v=new Vector();
          Object element;
          Enumeration enuM;
          Iterator iter;
          long start;
          
          for(int i=0; i<1000000; i++){
              v.add("New Element");
          }
          
          enuM=v.elements();
          iter=v.iterator();
          //*****CODE BLOCK FOR ITERATOR**********************
          start=System.currentTimeMillis();
          while(iter.hasNext()){
              element=iter.next();
          }
          System.out.println("Iterator took " + (System.currentTimeMillis()-start));
          //*************END OF ITERATOR BLOCK************************
          
          System.gc();   //request to GC to free up some memory
          //*************CODE BLOCK FOR ENUMERATION*******************
          start=System.currentTimeMillis();
          while(enuM.hasMoreElements()){
              element=enuM.nextElement();
          }
          System.out.println("Enumeration took " + (System.currentTimeMillis()-start));
          //************END OF ENUMERATION BLOCK**********************
      }
  }
  
  static void StairCase(int n) {
      for (int i=1;i<=n;i++) {
          int k=1;
          for (int j=0;k<=n;k++) {
              if (j<n-i) System.out.print(" ");
              else System.out.print("#");
              j++;
          }
          System.out.println("");
      }
  }

}
