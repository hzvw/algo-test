package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _054_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/13 0:41
 * @Version 1.0
 */
public class _054_ {
    static int r;
    static int c;

    static int[][] arr;

    static boolean[][] visited;

    static int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();//行数
        c = sc.nextInt();//列数

        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[r][c];
        // 记录的从起点到终点的最大的最小权值(每条路径)
        int[][] dist = new int[r][c];
        dist[0][0] = arr[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> dist[b[0]][b[1]] - dist[a[0]][a[1]]);
        pq.add(new int[]{0,0});

        while (!pq.isEmpty()){
            int[] ints = pq.poll();
            int i = ints[0];
            int j = ints[1];

            if(i == r-1 && j == c-1){
                break;
            }

            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];

                if(x>=0 && x<r && y>=0 && y<c){
                    int t = Math.min(dist[i][j], arr[x][y]);
                    if(dist[x][y] < t){
                        dist[x][y] = t;
                        pq.add(new int[]{x,y});
                    }
                }
            }
        }
        System.out.println(dist[r-1][c-1]);
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
