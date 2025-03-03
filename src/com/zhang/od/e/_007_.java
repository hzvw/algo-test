package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _007_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/27 0:47
 * @Version 1.0
 */
public class _007_ {
    static int m;
    static int n;

    static int[][] map;

    static Set<Integer> visited;

    static int[][] stepMap;

    static int[][] directions = new int[][]{{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ints = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = ints[0];
        n = ints[1];

        map = new int[m][n];
        stepMap = new int[m][n];
        visited = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited.add(i * n + j);
            }
        }


        for (int i = 0; i < m; i++) {
            char[] cs = sc.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if(cs[j] != '.'){
                    int k = cs[j] - '0';
                    bfs(i,j,k, new HashSet<Integer>());
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (Integer ele : visited) {
            int x = ele / n;
            int y = ele % n;
            res = Math.min(res, stepMap[x][y]);
        }
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void bfs(int i, int j, int k, HashSet<Integer> vis) {
        LinkedList<int[]> queue = new LinkedList<>();
        vis.add(i * n + j);
        queue.add(new int[]{i,j, 0});

        while (!queue.isEmpty() && k> 0){
            LinkedList<int[]> n_queue = new LinkedList<>();
            for (int[] ints : queue) {
                int x = ints[0];
                int y = ints[1];
                int step = ints[2];

                for (int[] d : directions) {
                    int n_x = x + d[0];
                    int n_y = y + d[1];
                    int n_step = step+1;

                    if(n_x>=0 && n_x <m && n_y >= 0 && n_y < n && !vis.contains(n_x * n + n_y)){
                        n_queue.add(new int[]{n_x, n_y, n_step});
                        vis.add(n_x * n + n_y);
                        stepMap[n_x][n_y] += n_step;
                    }
                }

            }
            k--;
            queue = n_queue;
        }
        visited.retainAll(vis);
    }


}
