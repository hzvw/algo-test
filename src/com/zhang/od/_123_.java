package com.zhang.od;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * ClassName: _123_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/9 22:05
 * @Version 1.0
 */
public class _123_ {

    static int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,-0},{1,1}};
    static int n;
    static int m;
    static int[][] nums;

    static boolean[][] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        nums = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(nums[i][j] == 1 && !visited[i][j]){
                    count++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(count);


    }

    static void bfs(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;

        while (!queue.isEmpty()){
            Queue<int[]> n_queue = new LinkedList<>();

            for (int[] ints : queue) {
                int x = ints[0];
                int y = ints[1];
                for (int[] direction : directions) {
                    int n_x = x + direction[0];
                    int n_y = y + direction[1];

                    if(n_x>=0 && n_x<n && n_y>=0 && n_y<m && nums[n_x][n_y] == 1 && !visited[n_x][n_y]){
                        n_queue.offer(new int[]{n_x, n_y});
                        visited[n_x][n_y] = true;
                    }
                }
            }
            queue = n_queue;
        }


    }


    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        UnionSet unionSet = new UnionSet(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(nums[i][j] != 1){
                    unionSet.count--;
                    continue;
                }
                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];

                    if(x>=0 && x<n && y>=0 && y<m && nums[x][y] == 1){
                        unionSet.union(x * m + y, i * m + j);
                    }
                }
            }
        }

        System.out.println(unionSet.count);

    }

    static class UnionSet{
        int[] fa;
        int count = 0;

        public UnionSet(int n) {
            fa = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x){
            if(fa[x] != x){
                return find(fa[x]);
            }
            return fa[x];
        }

        void union(int x, int y){
            int fa_x = find(x);
            int fa_y = find(y);
            if(fa_x != fa_y){
                fa[fa_y] = fa_x;
                count--;
            }

        }
    }


}
