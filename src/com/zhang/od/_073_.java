package com.zhang.od;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * ClassName: _073_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/20 21:18
 * @Version 1.0
 */
public class _073_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger num = sc.nextBigInteger();

        System.out.println(solve(num));
    }

    static String solve(BigInteger num){
        String str = num.toString(2);
//        System.out.println(str);
        int index = str.length()-1;

        StringBuilder sb = new StringBuilder();

        while(index >= 7){
            String s = str.substring(index-6, index+1);
            s = "1" + s;
            sb.append(convert16(s));
            index = index - 7;
        }

        if(index >= 0){
            String s = str.substring(0, index+1);
            s = "0" + s;
            sb.append(convert16(s));
        }

        return sb.toString();
    }

    //将一个8位的二进制数字转为16进制
    static String convert16(String s){
        String tmp = Integer.toHexString(Integer.parseInt(s, 2));

        if(tmp.length() == 1){
            tmp = "0" + tmp;
        }
        return tmp.toUpperCase();
    }

}
