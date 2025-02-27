package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _005_
 * Package: com.zhang.od
 * Description:TLV解码
 *
 * @Author Harizon
 * @Create 2025/1/14 0:03
 * @Version 1.0
 */
public class _005_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tag = sc.nextLine();
        String input = sc.nextLine();
        String[] words = input.split(" ");
        for (int i = 0; i < words.length;) {
            String t = words[i];
            int len = Integer.parseInt(words[i+2] + words[i+1], 16);

            if(t.equals(tag)){
                for (int j = 0; j < len; j++) {
                    System.out.print(words[i+3+j] + " ");
                }
                System.out.println();
            }
            i += len + 3;
        }

    }

}
