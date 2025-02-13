package com.zhang.od.e;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * ClassName: _058_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/13 17:08
 * @Version 1.0
 */
public class _058_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] costs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, costs[0]);
        map.put(3, costs[1]);
        map.put(7, costs[2]);
        map.put(30, costs[3]);

        int n = arr.length;
        int max_day = arr[n-1];
        int[] dp = new int[max_day+1];
        int index = 0;
        for (int i = 1; i <= max_day; i++) {
            if(i != arr[index]){
                dp[i] = dp[i-1];
                continue;
            }
            int a = dp[i-1] + map.get(1);
            int b = (i >= 3 ? dp[i-3] : 0) + map.get(3);
            int c = (i >= 7 ? dp[i-7] : 0) + map.get(7);
            int d = (i >= 30 ? dp[i-30] : 0) + map.get(30);

            dp[i] = min(a,b,c,d);
            index++;
        }
        System.out.println(dp[max_day]);

    }

    static int min(int a, int b, int c, int d){
        int[] arr = new int[]{a,b,c,d};
        Arrays.sort(arr);
        return arr[0];
    }

}
