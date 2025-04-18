package com.zhang._0416;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _002_
 * Package: com.zhang._0416
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/16 20:56
 * @Version 1.0
 */
public class _002_ {
    static int[][] map;
    static boolean[][] visited;

    static int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};

    static int m;

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] words = str.split(",");
        m = Integer.parseInt(words[0]);
        n = Integer.parseInt(words[1]);

        int a = Integer.parseInt(words[2]);
        int b = Integer.parseInt(words[3]);
        int c = Integer.parseInt(words[4]);
        int d = Integer.parseInt(words[5]);

        map = new int[m][n];
        visited = new boolean[m][n];

        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a,b});
        queue.offer(new int[]{c,d});
        map[a][b] = 1;
        map[c][d] = 1;
        visited[a][b] = true;
        visited[c][d] = true;


        int res = dfs(queue);
        System.out.println(res);
    }

    static int dfs(LinkedList<int[]> queue){
        int cnt = 0;
        while (!queue.isEmpty()){

            LinkedList<int[]> n_queue = new LinkedList<>();
            boolean flag = false;
            for (int[] ints : queue) {
                int x = ints[0];
                int y = ints[1];

                for (int[] direction : directions) {
                    int n_x = x + direction[0];
                    int n_y = y + direction[1];

                    if(n_x >= 0 && n_x<m && n_y>= 0 && n_y<n && map[n_x][n_y] == 0 && !visited[n_x][n_y]){
                        map[n_x][n_y] = 1;
                        visited[n_x][n_y] = true;
                        n_queue.offer(new int[]{n_x, n_y});
                        flag = true;
                    }
                }
            }
            queue = n_queue;
            if(flag){
                cnt++;
            }
        }
        return cnt;
    }

}




