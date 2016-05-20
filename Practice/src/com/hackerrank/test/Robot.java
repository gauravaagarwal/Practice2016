package com.hackerrank.test;

import java.util.HashMap;

class Block{
    private int posx=0;
    private int posy=-1;
    public Block() {
    }
    public void setPosy(int posy) {
        this.posy = posy;
    }
    public int getPosx() {
        return posx;
    }
    public int getPosy() {
        return posy;
    }
    public void incrementPosx(){
        if (posx<9)posx++;
    }
}
class Robot {
    Block block=null;
    public void pickUp(){
        block=new Block();
    }
    public void move(){
        if (null!=block)
            block.incrementPosx();
    }
    public void clear(){
        block=null;
    }
    public int lower(){
        if (null==block) return -1;
        return block.getPosx();
    }

    public static String compute (String instructions) {
        int []a=new int[10];
        char[] chAr=instructions.toCharArray();
        Robot robot=new Robot();
        for (char c : chAr){
            switch (c){
            case 'M':
                robot.move();
                break;
            case 'P':
                robot.pickUp();
                break;
            case 'L':
                int posx=robot.lower();
                if (posx!=-1 && a[posx]<15) {
                    a[posx]++;
                    robot.clear();
                }
                break;
            }
        }
        StringBuffer outputStringBuffer = new StringBuffer();
        for (int value:a){
            if (value<10) {
                outputStringBuffer.append(value);
            }
            else {
                outputStringBuffer.append(getHexValues(value));
            }
        }
        return outputStringBuffer.toString();
    }
    public static void main(String[] args) {
        System.out.println(compute("PMLPMMMLPMLPMML").equals("0211000000"));
        System.out.println(compute("PLPLPLPLPL").equals("5000000000"));
        System.out.println(compute("PLPLMMMPLPLPLPLPLPLPML").equals("8100000000"));
        System.out.println(compute("PLPLMMMPLPLPLPLPLPLPMLPL").equals("9100000000"));
        System.out.println(compute("PLPLMMMPLPLPLPLPLPLPMLPLPL").equals("A100000000"));
        System.out.println(compute("MMMMMLLLLLLPPPPP").equals("0000000000"));
        System.out.println(compute("PMMMMMMMMMMMMLLLLLLPMMMMMMMMMMMMLLLLLL").equals("0000000002"));
        System.out.println(compute("PLPLMMMPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLLPLPLPLPPLPLPML").equals("F100000000"));
    }
    public static String getHexValues(int integerValue) {
        HashMap<Integer,String> hexValues= new HashMap<Integer,String>();
        {
            hexValues.put(new Integer(10), "A");
            hexValues.put(new Integer(11), "B");
            hexValues.put(new Integer(12), "C");
            hexValues.put(new Integer(13), "D");
            hexValues.put(new Integer(14), "E");
            hexValues.put(new Integer(15), "F");

        }
        return hexValues.get(new Integer(integerValue));
    }
}
