package com.zhang.od.e;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _007_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/27 0:47
 * @Version 1.0
 */
public class _007_ {

    static int m;//m行
    static int n;

    static int[][] map ;

    static int[][] direction = {{1, 2}, {1, -2},{2, 1}, {2, -1},{-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    static int[][] stepMap;

    static HashSet<Integer> reaches = new HashSet<>();


//    public static void main(String[] args) {
//        System.out.println(Character.isDigit('1'));
//
//
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = arr[0];
        n = arr[1];
        map = new int[m][n];
        stepMap = new int[m][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                reaches.add(i * n + j);
            }
        }

        for(int i = 0; i<m; i++){
            String s = sc.nextLine();
            for(int j = 0; j<n; j++){
                char c = s.charAt(j);
                if(Character.isDigit(c)){
                    map[i][j] = c - '0';
                    bfs(i, j, map[i][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int pos : reaches){
            int x = pos / n;
            int y = pos % n;
            min = Math.min(min, stepMap[x][y]);
        }
        System.out.println(min != Integer.MAX_VALUE ? min : -1);
    }

    static void bfs(int i, int j, int k){
        HashSet<Integer> vis = new HashSet<>();//记录哪些地方到达过
        vis.add(i * n + j);

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j ,0});

        while(queue.size()>0 && k>0){
            LinkedList<int[]> n_qu = new LinkedList<>();

            for(int[] t : queue){
                int x = t[0];
                int y = t[1];
                int step = t[2];
                for(int[] dir : direction){
                    int n_x = x + dir[0];
                    int n_y = y + dir[1];
                    int n_step = step + 1;
                    if(n_x < 0 || n_x >=m || n_y < 0 || n_y >= n || vis.contains(n_x * n + n_y)){
                        continue;
                    }
                    n_qu.add(new int[]{n_x, n_y, n_step});
                    stepMap[n_x][n_y] += n_step;
                    vis.add(n_x * n + n_y);
                }
            }
            queue = n_qu;
            k--;
        }
        reaches.retainAll(vis);
    }


}
