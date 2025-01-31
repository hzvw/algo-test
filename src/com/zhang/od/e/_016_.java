package com.zhang.od.e;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _016_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/1 2:26
 * @Version 1.0
 */
public class _016_ {
    static int m ;
    static int n;
    static int[][] arr;

    static int k;

    static int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    static LinkedList<int[]> queue;

    static int max_h = 0;
    static int min_step = 0;

    static boolean[][] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[m][n];
        visited = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        max_h = arr[0][0];
        min_step = 0;
        visited[0][0] = true;

        bfs(0,0);
        System.out.println(max_h + " " + min_step);
    }

    static void bfs(int i, int j){
        int step = 0;
        while (!queue.isEmpty()){
            LinkedList<int[]> n_queue = new LinkedList<>();
            step++;
            int x = 0;
            int y = 0;
            for(int[] ints : queue){
                visited[ints[0]][ints[1]] = true;

                for(int[] dir : directions){

                    x = ints[0] + dir[0];
                    y = ints[1] + dir[1];

                    if(x<0 || x>= m || y<0 || y>= n){
                        continue;
                    }
                    if(Math.abs(arr[x][y] - arr[ints[0]][ints[1]]) > k){
                        continue;
                    }
                    if(visited[x][y]){
                        continue;
                    }
                    if(arr[x][y] > max_h){
                        max_h = arr[x][y];
                        min_step = step;
                    }
                    n_queue.offer(new int[]{x,y});
                }
            }
            queue = n_queue;
        }
    }

}
