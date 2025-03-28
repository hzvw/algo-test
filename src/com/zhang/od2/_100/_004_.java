package com.zhang.od2._100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * ClassName: _004_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 1:55
 * @Version 1.0
 */
public class _004_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        str = str + "_";

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;// 表示是否在双引号内
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c != '_'){
                sb.append(c);
                if(c == '"'){
                    flag = !flag;
                }
            }else{
                // 在双引号内
                if(flag){
                    sb.append(c);
                }else {
                    // 不在双引号内
                    if(sb.length() != 0){
                        list.add(sb.toString());
                    }
                    sb = new StringBuilder();
                }
            }

        }
        list.set(k, "******");

        System.out.println(String.join("_", list));
    }
}
