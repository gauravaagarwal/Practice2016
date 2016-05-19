package com.stackoverflow.help.basic;

public class ForLoop {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int tmp = 4;

        int x = (tmp-1)*2+1;
        int y = x/2;
        int z = 1;

        for(int i=0; i<tmp; i++){

            for(int j=0; j<=y; j++){
                System.out.print(" ");
            }
            for(int k=0; k<z; k++){
                System.out.print("*");
            }
            System.out.println();
            y--;
            z+=2;
        }
        for(int i=0; i<tmp; i++){
            y++;
            for(int j=0; j<=y; j++){
                System.out.print(" ");
            }

            z-=2;
            for(int k=0; k<z; k++){
                System.out.print("*");
            }

            System.out.println();

        }

    }

}
