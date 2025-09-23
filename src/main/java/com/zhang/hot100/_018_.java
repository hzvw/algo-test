package com.zhang.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: _018_
 * Package: com.zhang.hot100
 * Description:矩阵置零
 *
 * @Author Harizon
 * @Create 2025/2/18 19:09
 * @Version 1.0
 */
public class _018_ {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new _018_().setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> seti = new HashSet<>();
        Set<Integer> setj = new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    seti.add(i);
                    setj.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(seti.contains(i) || setj.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
