package com.zhang.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _020_
 * Package: com.zhang.hot100
 * Description:旋转矩阵
 *
 * @Author Harizon
 * @Create 2025/2/18 21:37
 * @Version 1.0
 */
public class _020_ {
    public static void main(String[] args) {



    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 上下互换
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = t;
            }
        }

        // 对角线互换
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }



}
