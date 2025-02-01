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
                int len = j-i;
                maxLen = Math.max(maxLen, len);
                i = j+1;
                Arrays.fill(count, 0);
            }else{
                if(count[c] <= 1){
                    count[c] ++;
                }else{
                    int len = j-i+1;
                    maxLen = Math.max(maxLen, len);
                    for(int k = i;k<=j-1 ;k++){
                        if(str.charAt(k) == c){
                            i = k;
                            break;
                        }
                        count[k]--;
                    }
                }
            }
            j++;
        }
        int len = j-i+1;
        maxLen = Math.max(maxLen, len);
        System.out.println(maxLen);
    }

}
