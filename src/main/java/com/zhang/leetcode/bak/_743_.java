package com.zhang.leetcode.bak;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * ClassName: _743_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/5/6 18:49
 * @Version 1.0
 */
// 网络延迟时间
public class _743_ {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(new _743_().networkDelayTime(times, n, k));
    }


    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] nums = new int[n+1][n+1];
        for (int i = 0; i <= n ; i++) {
            Arrays.fill(nums[i], Integer.MAX_VALUE);
        }

        for (int[] time : times) {
            int x = time[0];
            int y = time[1];
            int weight = time[2];
            nums[x][y] = weight;
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b [1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()){
            int[] arr = pq.poll();
            int ele = arr[0];
            int weight = arr[1];
            if(visited[ele]){
                continue;
            }
            visited[ele] = true;

            for (int i = 1; i <= n ; i++) {
                if(nums[ele][i] != Integer.MAX_VALUE){
                    if(dist[i] > dist[ele] + nums[ele][i]){
                        dist[i] = dist[ele] + nums[ele][i];
                        pq.offer(new int[]{i, dist[i]});
                    }
                }
            }
        }

        int max = -1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }

        return max != Integer.MAX_VALUE ? max : -1;
    }

}
