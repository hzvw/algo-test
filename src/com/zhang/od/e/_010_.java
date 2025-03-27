package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _010_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/28 0:21
 * @Version 1.0
 */
public class _010_ {
    static int M;
    static int N;

    static int[][] map;

    static int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0},{0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] MN = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        M = MN[0];
        N = MN[1];

        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = arr[j];
            }
        }
        bfs();


    }

    static void bfs(){
        int i = M-1;
        int j = N-1;
        int val = map[i][j];
        int min = Integer.MAX_VALUE;
        int[][] dist = new int[M][N];
        for(int[] arr : dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[M-1][N-1] = val;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j,val});
        while(!queue.isEmpty()){
            int[] t = queue.pollFirst();
            i = t[0];
            j = t[1];
            val = t[2];

            if(i == 0 && j == 0){
                min = Math.min(min, val);
            }

            for(int[] direction : directions){
                int n_x = i+direction[0];
                int n_y = j+direction[1];
                if(n_x <0 || n_x >=M || n_y <0 || n_y>= N || map[n_x][n_y] == 0){
                    continue;
                }
                int n_val = computeNVal(n_x, n_y, val);
                if(n_val > 100){
                    continue;
                }
                if(n_val < dist[n_x][n_y]){
                    dist[n_x][n_y] = n_val;
                    queue.add(new int[]{n_x,n_y,n_val});
                }
            }
        }
        System.out.println(min != Integer.MAX_VALUE ? min : -1);
    }

    /**
     *  (n_x,n_y),n_val  -> (x,y),val
     * @param n_x
     * @param n_y
     * @param val
     * @return
     */
    static int computeNVal(int n_x, int n_y, int val){
        // 从加油站出发，需要的油为0，因为加油站会加油100
        if(map[n_x][n_y] == -1) {
            return 0;
        } else if (val == -1) {
            return 0;//// 从某位置到加油站，不需要油
        }else{
            return val + map[n_x][n_y];
        }
    }


}
