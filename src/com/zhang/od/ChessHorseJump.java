package com.zhang.od;

import java.util.*;

public class ChessHorseJump {
    static int[][] directions = {
        {1, 2},
            {1, -2},
            {2, 1},
            {2, -1},
        {-1, 2},
            {-1, -2},
            {-2, 1},
            {-2, -1}
    };
    
    static int m, n;
    static int[][] board;
    static List<int[]> horses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        board = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String value = scanner.next();
                if (!value.equals(".")) {
                    board[i][j] = Integer.parseInt(value);
                    horses.add(new int[]{i, j, board[i][j]});
                }
            }
        }
        
//        int result = findMinimumMoves();
//        System.out.println(result);

        int[][] result = bfs(0, 0 , 4);
        for(int i = 0; i<m ;i++){
            for(int j = 0; j<n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int findMinimumMoves() {
        int[][] totalSteps = new int[m][n];
        int horseCount = horses.size();

        for (int[] horse : horses) {
            int[][] steps = bfs(horse[0], horse[1], horse[2]);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (steps[i][j] == Integer.MAX_VALUE) {
                        return -1;  // 无法到达某个位置，返回 -1
                    }
                    totalSteps[i][j] += steps[i][j];
                }
            }
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minSteps = Math.min(minSteps, totalSteps[i][j]);
            }
        }

        return minSteps;
    }

    static int[][] bfs(int startX, int startY, int maxJump) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] steps = new int[m][n];
        for (int[] row : steps) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        queue.add(new int[]{startX, startY});
        steps[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            int count= 0;
            for (int[] dir : directions) {
                for (int k = 1; k <= maxJump; k++) {  // 允许马跳1~k步
                    count++;
                    int nx = x + dir[0] * k;
                    int ny = y + dir[1] * k;

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && steps[nx][ny] > steps[x][y] + 1) {
                        steps[nx][ny] = steps[x][y] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }

            System.out.println("count = " + count);
        }
        return steps;
    }
}
