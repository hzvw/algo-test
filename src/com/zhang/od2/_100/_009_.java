package com.zhang.od2._100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _009_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 10:42
 * @Version 1.0
 */
public class _009_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        String[] words = str.split("-");

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < words.length; i++) {
            sb.append(words[i]);
        }

        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 0; i < sb.length(); i += k) {
            String s = "";
            int cnt0 = 0;
            int cnt1 = 0;
            for (int j = 0; j < k && i+j < sb.length(); j++) {
                s += sb.charAt(i+j);
                if(sb.charAt(i+j) >= 'a' && sb.charAt(i+j) <= 'z'){
                    cnt0++;
                }
                if(sb.charAt(i+j) >= 'A' && sb.charAt(i+j) <= 'Z'){
                    cnt1++;
                }
            }
            if(cnt0 > cnt1){
                s = s.toLowerCase();
            }else if(cnt0 < cnt1){
                s = s.toUpperCase();
            }else{
                //
            }
            list.add(s);
        }
        System.out.println(String.join("-", list));
    }
}
