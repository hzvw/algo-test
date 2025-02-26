package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _121_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/27 1:06
 * @Version 1.0
 */
public class _121_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] words = str.split(" ");
        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());

        int i = start >= 0 ? start : 0;
        int j = end < words.length ? end : words.length-1;
        while (i < j){
            String t = words[i];
            words[i] = words[j];
            words[j] = t;
            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < words.length; k++) {
            sb.append(words[k]);
            if(k != words.length-1){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());

    }
}
