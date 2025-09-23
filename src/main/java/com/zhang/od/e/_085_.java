package com.zhang.od.e;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * ClassName: _085_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/17 18:15
 * @Version 1.0
 */
public class _085_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] cost = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            cost[i] = sc.nextInt();
        }
        int[][] md = new int[n][2];
        for (int i = 0; i < n; i++) {
            md[i][0] = sc.nextInt();
            md[i][1] = sc.nextInt();
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for (int i = 0; i < n; i++) {
            pq.add(md[i]);
        }

        int time = t - Arrays.stream(cost).sum();

        int money = 0;
        while (time > 0 && !pq.isEmpty()){
            int[] ints = pq.poll();
            int m = ints[0];
            int d = ints[1];

            money += m;
            time--;
            if(m - d > 0){
                pq.add(new int[]{m-d, d});
            }
        }
        System.out.println(money);

    }

}
