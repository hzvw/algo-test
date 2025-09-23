package com.zhang.hot100;

/**
 * ClassName: _064_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 20:00
 * @Version 1.0
 */
public class _064_ {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n-1;
        while (left <= right){
            int mid = (left+right)/2;

            int x = mid / n;
            int y = mid % n;
            if(matrix[x][y] == target){
                return true;
            }else if(target > matrix[x][y]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
