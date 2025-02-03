package com.zhang.od.e;

import java.util.*;

public class MatrixSelection {
    static int N, M, K;
    static int[][] matrix;
    static boolean[] usedCols;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        
        matrix = new int[N][M];
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
                minVal = Math.min(minVal, matrix[i][j]);
                maxVal = Math.max(maxVal, matrix[i][j]);
            }
        }
        
        // 二分查找答案
        int left = minVal, right = maxVal;
        while (left < right) {
            int mid = left + (right - left) / 2;
            usedCols = new boolean[M];
            if (canSelect(0, new ArrayList<>(), mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(left);
    }
    
    // 使用DFS选取N个数，并检查第K大的数是否≤ mid
    private static boolean canSelect(int row, List<Integer> selected, int maxLimit) {
        if (row == N) {
            // 取选中元素中的第 K 大的数
            Collections.sort(selected);
            return selected.get(selected.size() - K) <= maxLimit;
        }

        for (int col = 0; col < M; col++) {
            if (!usedCols[col] && matrix[row][col] <= maxLimit) {
                usedCols[col] = true;
                selected.add(matrix[row][col]);
                
                if (canSelect(row + 1, selected, maxLimit)) {
                    return true;
                }
                
                selected.remove(selected.size() - 1);
                usedCols[col] = false;
            }
        }
        
        return false;
    }
}
