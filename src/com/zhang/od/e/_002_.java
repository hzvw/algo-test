package com.zhang.od.e;

import java.util.Arrays;
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
//        int[][] graph = {
//                {0, 10, 0, 30, 0},
//                {10, 0, 50, 0, 0},
//                {0, 50, 0, 20, 10},
//                {30, 0, 20, 0, 60},
//                {0, 0, 10, 60, 0}
//        };
//        int[] dist = dj(graph, 0);  // 源点为 0
//        for(int d : dist){
//            System.out.print(d + " ");
//        }

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[N][N];
//        for(int i = 0; i<N; i++){
//            Arrays.fill(arr[i], Integer.MAX_VALUE);
//        }
        for(int i =0; i<m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dis = sc.nextInt();

            arr[--start][--end] = dis;
        }
        int source = sc.nextInt() -1;

        int[] dist = dj(arr, source);

        int max = 0;
        for(int i = 0; i<N; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println(-1);
                return;
            }
            if(dist[i] > max){
                max = dist[i];
            }
        }
        System.out.println(max);

//        System.out.println(max_dist);
        //System.out.println(Arrays.stream(dist).max().getAsInt());;
    }

    static int[] dj(int[][] arr, int source){
        int N = arr.length;
        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for(int i = 0; i<N; i++){
            int index = findShortestDisIndex(dist, visited);
            if(index == -1){
                break;//节点不可达
            }
            visited[index] = true;

            for(int j = 0; j<N; j++){
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

    static int findShortestDisIndex(int[] dist, boolean[] visited){
        int index = -1;
        int min_dist = Integer.MAX_VALUE;
        for(int i =0;i<dist.length; i++){
            if(!visited[i] && dist[i] < min_dist){
                min_dist = dist[i];
                index = i;
            }
        }
        return index;
    }

}
