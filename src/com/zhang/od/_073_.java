package com.zhang.od;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * ClassName: _073_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/20 21:18
 * @Version 1.0
 */
public class _073_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger num = sc.nextBigInteger();

        System.out.println(p(num));
    }

    static String p(BigInteger num){
        String str = num.toString(2);
        int index = str.length()-1;

        StringBuilder sb = new StringBuilder();

        while(index > 6){
            String s = str.substring(index-6, index+1);
            s = "1" + s;
            sb.append(p1(s));
            index = index - 7;
        }

        if(index >= 0){
            String s = str.substring(0, index+1);
            s = "0" + s;
            sb.append(p1(s));
        }

        return sb.toString();
    }

    //将一个8位的二进制数字转为16进制
    static String p1(String s){
        String i1 = Integer.toHexString(Integer.parseInt(s, 2));

        if(i1.length() == 1){
            i1 = "0" + i1;
        }
        return i1.toUpperCase();
    }

}
