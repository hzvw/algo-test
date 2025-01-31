package com.zhang.od.e;

import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        StringBuilder sb = new StringBuilder(); // 记录文件内容
 
        // 注意：字符串的成对引号不一定限制在一行内
        boolean isSingleOpen = false; // 单引号是否处于闭合状态
        boolean isDoubleOpen = false; // 双引号是否处于闭合状态
 
        while (sc.hasNextLine()) {
            char[] s = sc.nextLine().toCharArray(); // 获取一行
 
            for (int i = 0; i < s.length; i++) { // 遍历一行中每个字符
                char c = s[i];
 
                if (i == 0 || s[i - 1] != '\\') { // 如果当前字符是单引号或双引号，且前面一个字符不是斜杠，那么对应引号就是字符串标识，对应引号状态取反
                    switch (c) {
                        case '\'':
                            isSingleOpen = !isSingleOpen;
                            break;
                        case '"':
                            isDoubleOpen = !isDoubleOpen;
                            break;
                    }
                }
 
                // 如果当前处于引号开启状态，那么当前字符属于字符串内容，为了避免字符串内容影响逻辑，我们可以忽略字符串内容
                if (isSingleOpen || isDoubleOpen) {
                    continue;
                }
 
                // 如果当前字符不是字符串内容，且当前字符和前一个字符都是 - 则为注释，后续所有内容都可以忽略
                if (c == '-' && i + 1 < s.length && s[i + 1] == '-') {
                    break;
                }
 
                // 空白字符和制表符忽略
                if (c != ' ' && c != '\t') {
                    sb.append(c);
                }
            }
        }
 
        sb.append(";"); // 最后一条可以没有 ";" , 这里追加一个
 
        int ans = 0;
 
        int last = -1; // 上一个分号位置
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ';') { // 当前位置是分号
                if (i - last > 1) {
                    ans++; // 如果两个分号不相邻，则有效文本数量+1
                }
                last = i;
            }
        }
 
        System.out.println(ans);
    }
}