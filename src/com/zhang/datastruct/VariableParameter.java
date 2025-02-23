package com.zhang.datastruct;

/**
 * 可变参数
 */
public class VariableParameter {
    public static void main(String[] args){
        int x = 10;
        int[] arg = {2, 3, 5};
        System.out.print(add(x, arg));
    }


    public static int add(int x, int... args){
//        for(int i = 0; i<args.length; i++){
//            x += args[i];
//        }
        //增强for循环
        for(int i : args){
            x += i;
        }
        return x;
    }




}
