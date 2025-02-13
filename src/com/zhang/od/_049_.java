package com.zhang.od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName: _049_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/18 16:46
 * @Version 1.0
 */
public class _049_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if(n<3 || n >7 || m < 0){
            System.out.println(-1);
            return;
        }

        Map<Character, Integer> map = new HashMap<>();
        int min = (int)Math.pow(10, n-1);
        int max = (int)Math.pow(10, n);

        for(int i = 0; i<=9; i++){
            char c = (char) (i+'0');
            int value = (int) Math.pow(i, n);
            map.put(c, value);
        }

        int cnt = 0;
        long last = min;
        for(long i = min; i<max; i++){
            long sum = 0;

            String str_i = i+"";
            for(int j = 0; j<str_i.length(); j++){
                sum += map.get(str_i.charAt(j));
            }

            if(sum == i){
                //found 1
                if(cnt == m){
                    System.out.println(i);
                    return;
                }
                cnt++;
                last = i;
            }
        }

        System.out.println(last * m);


    }

}
