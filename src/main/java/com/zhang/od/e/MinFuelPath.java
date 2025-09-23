package com.zhang.od.e;

import java.util.*;

public class MinFuelPath {
    static class Node implements Comparable<Node> {
        int x, y, fuel;

        public Node(int x, int y, int fuel) {
            this.x = x;
            this.y = y;
            this.fuel = fuel;
        }

        public int compareTo(Node other) {
            return this.fuel - other.fuel;  // 最小油耗优先
        }
    }

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  // 4个方向
    static int INF = Integer.MAX_VALUE;

    public static int minInitialFuel(int[][] grid, int m, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] minFuel = new int[m][n];
        for (int[] row : minFuel) {
            Arrays.fill(row, INF);
        }

        pq.add(new Node(0, 0, grid[0][0] == -1 ? 0 : grid[0][0]));
        minFuel[0][0] = grid[0][0] == -1 ? 0 : grid[0][0];

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int x = current.x, y = current.y, fuel = current.fuel;
            if (x == m - 1 && y == n - 1) {
                return fuel;  // 找到到达终点的最小油耗
            }

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != 0) {
                    int newFuel = fuel + (grid[nx][ny] == -1 ? 0 : grid[nx][ny]);
                    if (grid[nx][ny] == -1) {
                        newFuel = Math.max(0, Math.min(100, fuel));  // 加满油，但最多100
                    }
                    if (newFuel < minFuel[nx][ny]) {
                        minFuel[nx][ny] = newFuel;
                        pq.add(new Node(nx, ny, newFuel));
                    }
                }
            }
        }
        return -1;  // 无法到达终点
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] MN = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int m = MN[0];
        int n = MN[1];

        int[][] grid = new int[m][n];
//        map = new int[M][N];
        for (int i = 0; i < m; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                grid[i][j] = arr[j];
            }
        }
        int result = minInitialFuel(grid, m, n);
        System.out.println(result);
//        System.out.println(n_dj());
    }
}
