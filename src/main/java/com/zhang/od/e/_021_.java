package com.zhang.od.e;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _021_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/1 17:53
 * @Version 1.0
 */
public class _021_ {
    static int m;
    static int n;
    static int[][] arr;
    static int end_i;
    static int end_j;
    static int sre_i;
    static int sre_j;

    static boolean[][] visited;

    static int[][] directions = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        arr = new int[m][n];
        visited = new boolean[m][n];
        sre_i = 0;
        sre_j = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] != 0 && arr[i][j] != -1){
                    sre_i = i;
                    sre_j = j;
                }
            }
        }

        end_i = sc.nextInt();
        end_j = sc.nextInt();
        System.out.println(bfs());;
    }



    static int bfs(){
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sre_i, sre_j, arr[sre_i][sre_j]});
        visited[sre_i][sre_j] = true;
        int res = 0;

        while(!queue.isEmpty()){
            LinkedList<int[]> n_queue = new LinkedList<>();
            for(int[] ints : queue){
                int x = ints[0];
                int y = ints[1];
                int k = ints[2];

                if(x == end_i && y == end_j){
                    res = k;
                    return res;
                }
                for(int[] dir : directions){
                    int n_x = x + dir[0];
                    int n_y = y + dir[1];
                    if(n_x >=0 && n_x <m && n_y>=0 && n_y<n&& arr[n_x][n_y] != -1 && !visited[n_x][n_y]){
                        int n_k = 0;
                        if(k > 0){
                            n_k = k-1;
                        }
                        visited[n_x][n_y] = true;
                        n_queue.add(new int[]{n_x, n_y, n_k});
                    }
                }
            }
            queue = n_queue;
        }
        return res;
    }



}
