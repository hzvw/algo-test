package com.zhang.od.e;

import java.util.*;

public class MatrixSelection {
    static int N, M, K;
    static int[][] matrix;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        matrix = new int[N][M];

        TreeSet<Integer> uniqueValues = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
                uniqueValues.add(matrix[i][j]); // 记录所有不同的值
            }
        }
        sc.close();
        
        // 转换为排序列表，方便二分搜索
        List<Integer> sortedValues = new ArrayList<>(uniqueValues);
        
        // 二分查找答案
        int left = 0, right = sortedValues.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (canSelect(sortedValues.get(mid))) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(sortedValues.get(left)); // 输出最终结果
    }

    /**
     * 判断是否可以选择 N 个数，使得它们的第 K 大值 ≤ x
     */
    private static boolean canSelect(int x) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] <= x) {
                    adj.get(i).add(j);
                }
            }
        }

        // 使用匈牙利算法计算最大匹配
        return maxMatching(adj, N, M) == N;
    }

    /**
     * 匈牙利算法求最大匹配
     */
    private static int maxMatching(List<List<Integer>> adj, int N, int M) {
        int[] colToRow = new int[M]; // 记录列对应的行
        Arrays.fill(colToRow, -1);
        int match = 0;
        
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[M];
            if (hungarianDFS(i, adj, colToRow, visited)) {
                match++;
            }
        }
        return match;
    }

    /**
     * 匈牙利算法的 DFS 递归匹配
     */
    private static boolean hungarianDFS(int row, List<List<Integer>> adj, int[] colToRow, boolean[] visited) {
        for (int col : adj.get(row)) {
            if (!visited[col]) {
                visited[col] = true;
                if (colToRow[col] == -1 || hungarianDFS(colToRow[col], adj, colToRow, visited)) {
                    colToRow[col] = row;
                    return true;
                }
            }
        }
        return false;
    }
}
