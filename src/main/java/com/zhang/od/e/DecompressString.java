package com.zhang.od.e;

import java.util.Stack;
import java.util.Scanner;

public class DecompressString {
    public static String decompress(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) { // 解析数字
                num = num * 10 + (c - '0');
            } else if (c == '[') { // 遇到 [，压栈并重置 num 和 currentStr
                countStack.push(num);
                strStack.push(currentStr);
                num = 0;
                currentStr = new StringBuilder();
            } else if (c == ']') { // 遇到 ]，弹出栈顶的 count，并构建重复字符串
                int repeatTimes = countStack.pop();
                StringBuilder temp = strStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentStr);
                }
                currentStr = temp;
            } else { // 普通字母，直接拼接
                currentStr.append(c);
            }
        }
        return currentStr.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String compressedStr = sc.nextLine();
        System.out.println(decompress(compressedStr));
    }
}
