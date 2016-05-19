package com.codility.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    /**
     * @param args
     */
    /**
     * @param args
     * @throws Exception
     */
    /**
     * @param args
     * @throws Exception
     */
    public static void test1(String args[] ) throws Exception {
        Scanner scanner=new Scanner(System.in);
        int numberOfEntries=scanner.nextInt();
        int[] intArray=new int[numberOfEntries];
        for (int i=0;i<numberOfEntries;i++) {
            intArray[i]=scanner.nextInt();
        }
        int counter=0;
        for (int i=0;i<intArray.length;i++) {
            int sum=0;
            for (int j=i;j<intArray.length;j++) {
                sum=sum+intArray[j];
                if (sum<0) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
    public static void diagonalDiff(String args[] ) throws Exception {
        System.out.println("input");
        Scanner scanner=new Scanner(System.in);
        int sizeN=scanner.nextInt();
        int[][] array2=new int[sizeN][sizeN];
        for (int i=0;i<sizeN;i++) {
            
            for (int j=0;j<sizeN;j++) {
                array2[i][j]=scanner.nextInt();
            }
        }
       // int [][] array2={{11,2,4},{4,5,6},{10,8,-12}};
        long primarySum=0;
        long secondarySum=0;
        for (int i=0;i<sizeN;i++){
           primarySum+=array2[i][i];
        }
        for (int i=sizeN-1;i>=0;i--){
            secondarySum+=array2[sizeN-i-1][i];
         }
        //System.out.println(primarySum);
        //System.out.println(secondarySum);
        System.out.println(Math.abs(primarySum-secondarySum));
    }
    public static void sampleSearch() {
        Scanner scanner=new Scanner(System.in);
        int numToSearch=scanner.nextInt();
        int sizeN=scanner.nextInt();
        int[] array=new int[sizeN];
        for (int i=0;i<sizeN;i++){
            array[i]=scanner.nextInt();
        }
        for (int i=sizeN/2;i<sizeN && i>=0;){
            if (array[i]<numToSearch) {
                i++;
            }
            if (array[i]==numToSearch) {
                System.out.println(i);
                break;
            }
            if (array[i]>numToSearch) {
                i--;
            }
        }
    }
    public static void insertIntoSorted(int[] ar) {
        int pivot=ar[ar.length-1];
       for (int i=ar.length-1;i>=0;i--) {
           if (i==0||pivot>=ar[i-1]) {
               ar[i]=pivot;
               i=-1;
           }
           else {
               ar[i]=ar[i-1];
           }
           for (int j:ar)
           System.out.print(j + " ");
           System.out.println("");
       }
    }
    public static void insertionSort2(int[] ar){
       // int [] a2= new int[ar.length];
       // a2[0]=ar[0];
        int count=0;
        for (int k=1;k<ar.length;k++){
            int pivot=ar[k];
            for (int i=k;i>=0;i--) {
                if (i==0||pivot>=ar[i-1]) {
                    ar[i]=pivot;
                    i=-1;
                }
                else {
                    ar[i]=ar[i-1];
                    count++;
                }
            }
            System.out.println(count);
            //printArray(ar);
        }
    }
    
    public static void printArray(int [] ar){
        for (int j:ar)
            System.out.print(j + " ");
            System.out.println("");
    }
    public static void main(String[] args) throws Exception {
     /*int [] intArray= {1,-2,4,-5,1};
     int counter=0;
     for (int i=0;i<intArray.length;i++) {
         int sum=0;
         for (int j=i;j<intArray.length;j++) {
             sum=sum+intArray[j];
             if (sum<0) {
                 counter++;
             }
         }
     }
     System.out.println(counter);*/
        //diagonalDiff(null);
      //  sampleSearch();
        int[] ar={2,7,4,6,8,1};
        //insertIntoSorted(ar);
       // insertionSort2(ar);
       
    }
  
}
