package com.zhang.od;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * ClassName: _070_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/19 23:41
 * @Version 1.0
 */
public class _070_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(p(str));
    }

    static String p(String s){
        BigInteger res = new BigInteger("0");
        boolean flag  = false;//负号标志
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                //数字
                if (!flag) {
                    res = res.add(new BigInteger(c + ""));
                } else {
                    sb.append(c);
                }
            } else {
                //非数字
                if (flag && sb.length() > 0) {
                    res = res.subtract(new BigInteger(sb.toString()));
                    sb = new StringBuilder();
                }

                if (c == '-') {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }
        if(sb.length() > 0){
            res = res.subtract(new BigInteger(sb.toString()));
        }


        return res.toString();
    }

}
