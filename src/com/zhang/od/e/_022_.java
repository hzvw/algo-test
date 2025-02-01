package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _022_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/1 18:14
 * @Version 1.0
 */
public class _022_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char bad = sc.nextLine().charAt(0);
        String str = sc.nextLine();

        int i = 0;
        int j = 0;

        //记录上一个该字符所处的位置
        int[] count = new int[128];

        int maxLen = 0;
        while(j < str.length()){
            char c = str.charAt(j);
            if(c == bad){
                maxLen = Math.max(maxLen, j-i);
                i = j+1;
                j = i;
                Arrays.fill(count, 0);
            }else{
                count[c]++;

                if(count[c] > 2){
                    maxLen = Math.max(maxLen, j-i);
                }

                while(count[c] > 2){
                    char t = str.charAt(i);
                    count[t]--;
                    i++;
                }
                j++;
            }

        }
        int len = j-i;
        maxLen = Math.max(maxLen, len);
        System.out.println(maxLen);
    }

}
