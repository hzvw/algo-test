package com.zhang.od.e;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * ClassName: _060_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/13 18:04
 * @Version 1.0
 */
public class _060_ {
    static int n;
    static int m;
    static int[][] arr;
    static int[][] directions = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

    static boolean[][] visited ;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new LinkedList<>();
        while(sc.hasNextLine()){
            list.add(sc.nextLine());
        }
        n = list.size();
        m = list.get(0).length();
        arr = new int[n][m];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = list.get(i).charAt(j) - '0';
            }
        }
        visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] != 0 && !visited[i][j]){
                    ans = Math.max(ans, bfs(i,j));
                }
            }
        }

        System.out.println(ans);
    }

    static int bfs(int i, int j){
        int sum = 0;
         Queue<int[]> queue = new LinkedList<>();
         queue.offer(new int[]{i,j});
         visited[i][j] = true;

         while(!queue.isEmpty()){
             int[] ints = queue.poll();
             int x = ints[0];
             int y = ints[1];
             sum += arr[x][y];

             for (int[] direction : directions) {

                 int n_x = x + direction[0];
                 int n_y = y + direction[1];

                 if(n_x >= 0 && n_x < n && n_y >= 0 && n_y < m && !visited[n_x][n_y] && arr[n_x][n_y] != 0){
                     queue.offer(new int[]{n_x, n_y});
                     visited[n_x][n_y] = true;
                 }
             }
         }
         return sum;
    }

}
