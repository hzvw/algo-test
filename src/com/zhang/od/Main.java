package com.zhang.od;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String zipStr = sc.nextLine(); // 输入的压缩串
        String unZipStr = unZip(zipStr); // 解压后字符串

        if ("!error".equals(unZipStr) || !zipStr.equals(zip(unZipStr))) { // 对解压后的字符串二次压缩, 如果二次压缩结果和输入的压缩串不一致, 则输入不合法
            System.out.println("!error");
        } else {
            System.out.println(unZipStr);
        }
    }

    // 解压
    public static String unZip(String zipStr) {
        char[] s = zipStr.toCharArray(); // charAt写出来的代码太臃肿了

        StringBuilder unZipStr = new StringBuilder(); // 记录解压结果串

        int i = 0;
        while (i < s.length) {
            char c = s[i];

            if (Character.isDigit(c)) { // 如果遍历的字符是数字
                // 则探索出之后连续的所有数字
                StringBuilder num = new StringBuilder();
                while (i < s.length && Character.isDigit(s[i])) {
                    num.append(s[i]);
                    i++;
                }

                // 以及跟着的一个小写字母
                if (i < s.length && Character.isLowerCase(s[i])) {
                    int repeatCount = Integer.parseInt(num.toString());
                    char repeatLetter = s[i];

                    // 必须超过连续两个相同小写字母才能进行压缩
                    if (repeatCount <= 2) return "!error";

                    // 解压
                    for (int k = 0; k < repeatCount; k++) {
                        unZipStr.append(repeatLetter);
                    }
                } else {
                    // 数字后面没有跟着小写字母, 则不合法
                    return "!error";
                }

            } else if (Character.isLowerCase(c)) {
                // 单独的小写字母直接并入解压串
                unZipStr.append(c);
            } else {
                // 压缩串中含有数字,小写字母以外的字符, 则不合法
                return "!error";
            }

            i++;
        }

        return unZipStr.toString();
    }

    // 压缩
    public static String zip(String unZipStr) {
        StringBuilder zipStr = new StringBuilder();

        // 加一个空格不影响压缩结果, 同时可以避免收尾操作
        unZipStr += " ";

        // 记录上一个字母, 以及它的出现次数
        char last = unZipStr.charAt(0);
        int count = 1;

        for (int i = 1; i < unZipStr.length(); i++) {
            char curt = unZipStr.charAt(i);

            if (curt == last) {
                // 当前字母和上一个字母相同, 则连续相同该字母数量++
                count++;
            } else {
                // 当前字母和上一个字母不相同, 则连续相同字母被打断
                if (count > 2) {
                    // 超过两个连续相同字母, 则进行压缩
                    zipStr.append(count);
                    zipStr.append(last);
                } else if (count == 2) {
                    // 两个连续相同字母
                    zipStr.append(last);
                    zipStr.append(last);
                } else {
                    // 一个字母
                    zipStr.append(last);
                }

                // 更新last和count
                last = curt;
                count = 1;
            }
        }

        return zipStr.toString();
    }
}