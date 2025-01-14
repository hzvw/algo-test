package com.zhang.od;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName: _011_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/14 17:13
 * @Version 1.0
 */
public class _011_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str += "0";

        int k = Integer.parseInt(sc.nextLine());
        if(k < 1){
            System.out.println(-1);
            return;
        }

        int i = 0;
        char b = str.charAt(i);
        int len =1;

        Map<Character, Integer> map = new HashMap<>();
        int j = 1;
        for(j = 1; j<str.length(); j++){
            char c = str.charAt(j);
            if(b == c){
                len += 1;
            }else{
                if(!map.containsKey(b) || map.get(b) < len){
                    map.put(b, len);

                }
                b = c;
                len = 1;

            }
        }
        Integer[] arr = map.values().toArray(new Integer[0]);
        if(k> arr.length){
            System.out.println(-1);
            return;
        }

        Arrays.sort(arr, (x,y) -> y-x);
//        System.out.println();
        System.out.println(arr[k-1]);



    }

}
