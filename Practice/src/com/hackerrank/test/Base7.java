package com.atlassian.test;

import java.util.Scanner;

public class Base7 {

    /**
     * @param args
     */
    public static void main(String[] args) {
          System.out.println( LookAndSay("11",2));;
      /*  System.out.println( base7(7792875));;
        System.out.println( base7(0));;
        System.out.println( base7(6));;
        System.out.println( base7(7));;
        System.out.println( base7(1));;
        System.out.println( base7(999999999999999999l));;*/


    }
    static String LookAndSay(String start, int n) {
        while (n-->0){
            start=LookAndSay(start);
        }
        return start;
    }

    static String LookAndSay(String start) {
        StringBuffer outputStringBuffer = new StringBuffer();
        if (null != start && !start.isEmpty())
        {
            int index = 0;
            for (int i = 0; i < start.length(); i++) {
                if (start.charAt(index) != start.charAt(i)) {
                    String eligibleForOutput = start.substring(index, i);
                    outputStringBuffer.append(eligibleForOutput.length());
                    outputStringBuffer.append(start.charAt(index));
                    index = i;
                }
            }
            String subString=start.substring(index, start.length());
            outputStringBuffer.append(subString.length());
            outputStringBuffer.append(start.charAt(index));
        }
        return outputStringBuffer.toString();
    }
    static String LookAndSay1(String start) {
        if (null == start || start.isEmpty())
        {
            return "";
        }
        int initialCursor = 0;
        StringBuilder output = new StringBuilder();
        char[] ch = start.toCharArray();
        int countSameLetter=0;
        for (int i=0;i<start.length();i++){
            if (ch[i]==ch[i+1]){

            }
        }
        return output.toString();
    }
    static String base7(long input){
        long number=input;
        StringBuffer sb= new StringBuffer();
        if (number<7) {
            getBase7(sb,(int)number); 
        }
        else{
            while (number>0){
                int remainder=(int)number%7;
                number=number/7;
                getBase7(sb, remainder);
            }
        }
        return sb.reverse().toString();
    }
    /**
     * @param sb
     * @param remainder
     */
    private static void getBase7(StringBuffer sb, int remainder) {
        switch (remainder) {
        case 0:
            sb.append(0);
            break;
        case 1:
            sb.append("a");
            break;
        case 2:
            sb.append("t");
            break;
        case 3:
            sb.append("l");
            break;
        case 4:
            sb.append("s");
            break;
        case 5:
            sb.append("i");
            break;
        case 6:
            sb.append("n");
            break;
        }
    }
}
