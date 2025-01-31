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

    static int max = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        bfs(0,0);

        if(end_x != 0){
            System.out.println(max + " " + (end_x + end_y));
        }else{
            System.out.println(0 + " " + 0);
        }
    }

    static int end_x = 0;
    static int end_y = 0;
    static void bfs(int i, int j){
        while (!queue.isEmpty()){
            int[] ints = queue.poll();

            for(int[] dir : directions){

                int x = ints[0] + dir[0];
                int y = ints[1] + dir[1];

                if(x<0 || x>= m || y<0 || y>= n){
                    continue;
                }
                if(Math.abs(arr[x][y] - arr[ints[0]][ints[1]]) > k){
                    continue;
                }
                if(arr[x][y] > max){
                    max = arr[x][y];
                    end_x = x;
                    end_y = y;
                    queue.offer(new int[]{x,y});
                    bfs(x,y);
                }
            }
        }
    }

}
