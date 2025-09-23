package com.zhang.od.e;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _029_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/2 2:01
 * @Version 1.0
 */
public class _029_ {
    static int N;
    static int[][] brr;

    static LinkedList<int[]> queue;

    static boolean[][] visited ;
    static int[][] directions = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        N = (int) Math.sqrt(arr.length * 1.0);

        brr = new int[N][N];
        visited = new boolean[N][N];
        int k = 0;
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                brr[i][j] = arr[k];
                if(brr[i][j] == 1){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
                k++;
            }
        }
        int cnt = bfs();
        System.out.println(cnt == 0 ? -1 : cnt);
    }



    static int bfs(){
        int cnt = 0;
        while(queue.size() > 0){
            boolean flag = false;
            LinkedList<int[]> n_queue = new LinkedList<>();
            for(int[] ints : queue){
                int x = ints[0];
                int y = ints[1];

                for(int[] dir : directions){
                    int n_x = x + dir[0];
                    int n_y = y + dir[1];

                    if(n_x >= 0 && n_x <N && n_y>=0 && n_y<N && brr[n_x][n_y] == 0 && !visited[n_x][n_y]){
                        n_queue.add(new int[]{n_x, n_y});
                        visited[n_x][n_y] = true;
                        brr[n_x][n_y] = 1;
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
