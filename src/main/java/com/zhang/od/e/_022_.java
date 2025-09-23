package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _022_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/1 18:14
 * @Version 1.0
 */
public class _022_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char bad = sc.nextLine().charAt(0);
        String str = sc.nextLine();

        /*int i = 0;
        int j = 0;
        int[] count = new int[128];
        int maxLen = 0;
        while(j < str.length()){
            char c = str.charAt(j);
            if(c == bad){
                maxLen = Math.max(maxLen, j-i);
                i = j+1;
                Arrays.fill(count, 0);
            }else{
                count[c]++;
                if(count[c] > 2){
                    maxLen = Math.max(maxLen, j-i);
                    for(int k = i; k<=j-1; k++){
                        count[str.charAt(k)]--;
                        if(str.charAt(k) == c){
                            i=k+1;
                            break;
                        }
                    }
                }
            }
            j++;
        }
        maxLen = Math.max(maxLen, j-i);
        System.out.println(maxLen);*/
        test01(bad, str);

    }

    public static void test01(char bad, String str) {
        int i = 0;
        int j = 0;

        // 记录滑动窗口中的字符出现的次数
        int[] count = new int[128];

        int maxLen = 0;
        while(j < str.length()){
            char c = str.charAt(j);
            if(c == bad){
                maxLen = Math.max(maxLen, j-i);
                i = j+1;
                Arrays.fill(count, 0);
            }else{
                if(count[c] <= 1){
                    count[c] ++;
                }else{
                    maxLen = Math.max(maxLen, j-i);
                    for(int k = i;k<=j-1 ;k++){
                        count[str.charAt(k)]--;
                        if(str.charAt(k) == c){
                            i = k+1;
                            break;
                        }
                    }
                    count[c]++;
                }
            }
            j++;
        }
        maxLen = Math.max(maxLen, j-i);
        System.out.println(maxLen);
    }

}
