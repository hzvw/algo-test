package com.zhang.od2.a;

import java.util.Scanner;

/**
 * ClassName: _006_
 * Package: com.zhang.od2.a
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/31 17:31
 * @Version 1.0
 */
public class _006_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine() + " ";
        String t = sc.nextLine() + "-";

        int maxLen = 0;
        String common = "";
        for (int i = 0; i < s.length(); i++) {
            int j = t.indexOf(s.charAt(i));
            if(j == -1 || j >= t.length()){
                continue;
            }

            int k = i;
            while (j < t.length() && k < s.length() && s.charAt(k) == t.charAt(j)){
                k++;
                j++;
            }
            if(j - i > maxLen){
                maxLen = j - i;
                common = s.substring(i, i + maxLen);
                //System.out.println(maxLen);
            }
        }
        System.out.println(common);
    }
}
