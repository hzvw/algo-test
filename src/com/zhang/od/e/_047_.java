package com.zhang.od.e;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * ClassName: _047_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/11 19:29
 * @Version 1.0
 */
public class _047_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(sc.nextLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele  : arr){
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }

        int k = map.values().stream().max((a,b) -> a-b).get();
        int p = 0;
        for(int cnt : map.values()){
            if(cnt == k){
                p++;
            }
        }

        int result = (k-1)*(n+1) + p > arr.length ? (k-1)*(n+1) + p : arr.length;
        System.out.println(result);
    }

}
