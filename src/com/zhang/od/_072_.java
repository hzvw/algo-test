package com.zhang.od;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * ClassName: _072_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/20 20:32
 * @Version 1.0
 */
public class _072_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int b = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<10; i++){
            int a = sc.nextInt();
            int sum = 0;
            while(a > 0){
                sum += a&255;
                a = a>>8;
            }
            if(sum % b < c){
                int type = sum % b;
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
        }
        System.out.println(Collections.max(map.values()));
    }

}
