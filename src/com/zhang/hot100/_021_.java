package com.zhang.hot100;

/**
 * ClassName: _021_
 * Package: com.zhang.hot100
 * Description:搜索二维矩阵 II
 *
 * @Author Harizon
 * @Create 2025/2/18 22:12
 * @Version 1.0
 */
public class _021_ {

    public static void main(String[] args) {
        //int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] arr = {{1,4},{2,5}};
        new _021_().searchMatrix(arr, 5);

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while (i < m && j>=0){
            if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
