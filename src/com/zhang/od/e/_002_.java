package com.zhang.od.e;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * ClassName: _002_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/25 2:25
 * @Version 1.0
 */
public class _002_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int source = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(dj2(arr, source));

    }

    static int dj2(int[][] nums, int source){
        int n = nums.length;

        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // pq中存的是节点编号->节点到源点的距离
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]- b[1]);
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[0];
            int w = cur[1];
            if(visited[u]){
                continue;
            }
            visited[u] = true;

            for (int i = 0; i < n; i++) {
                int v = i+1;
                if(nums[u-1][v-1] != 0 && nums[u-1][v-1] != -1){
                    int n_dist = nums[u-1][v-1] + w;
                    if(n_dist < dist[v]){
                        dist[v] = n_dist;
                        pq.offer(new int[]{v, n_dist});
                    }
                }
            }

        }
        int max = -1;
        for (int i = 1; i < dist.length; i++) {
            max = Math.max(max, dist[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }





    private static int[] dj(int[][] arr, int source) {
        int[] dist = new int[arr.length];
        boolean[] visited = new boolean[arr.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;
        for (int i = 0; i < arr.length; i++) {
            int index = findShortDisIndex(dist, visited);

            if(index == -1){
                break;
            }
            visited[index] = true;

            for (int j = 0; j < arr.length; j++) {
                if(arr[index][j] != 0 && !visited[j]){
                    int new_dist = dist[index] + arr[index][j];
                    if(new_dist < dist[j]){
                        dist[j] = new_dist;
                    }
                }
            }

        }
        return dist;
    }

    static int findShortDisIndex(int[] dist, boolean[] visited){
        int index = -1;
        int min_dist = Integer.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if(!visited[i] && dist[i] < min_dist){
                min_dist = dist[i];
                index = i;
            }
        }
        return index;
    }


}
