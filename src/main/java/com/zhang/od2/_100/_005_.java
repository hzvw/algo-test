package com.zhang.od2._100;

import java.util.Scanner;

/**
 * ClassName: _005_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 2:17
 * @Version 1.0
 */
public class _005_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tag = sc.nextLine();
        String str = sc.nextLine();

        String[] words = str.split(" ");

        int i  = 0;
        StringBuilder sb = new StringBuilder();
        while (i < words.length){
            String t = words[i];
            String s_len = words[i+2] + words[i+1];
            int len = Integer.parseInt(s_len, 16);
            if(tag.equals(t)){
                for (int j = 0; j < len; j++) {
                    sb.append(words[i+2+1+j] + " ");
                }
                break;
            }

            i += 2;
            i += len;
            i += 1;
        }
        System.out.println(sb.toString());
    }
}
