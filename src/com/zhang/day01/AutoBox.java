package com.zhang.day01;

/**
 * 自动装箱与拆箱
 */
public class AutoBox {
    public static void main(String[] args){
        //自动装箱
        Integer i = 1;
        Integer j = 1;
        System.out.println(i == j);

        System.out.println(i + j);

        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);

        Integer i3 = Integer.valueOf(128);
        Integer i4 = Integer.valueOf(128);

        System.out.println(i3 == i4);
    }



}
