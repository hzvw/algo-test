package other;

import org.junit.Test;

import java.util.*;

/**
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class _01_print_matrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int row = matrix.length;
        int column = matrix[0].length;

        if(row == 1){
            for(int i =0; i<column; i++){
                ret.add(matrix[0][i]);
            }
            return ret;
        }

        if(column == 1){
            for(int i = 0; i<row; i++){
                ret.add(matrix[i][0]);
            }
            return ret;
        }

        //System.out.println("row = " + );
        int circle = (Math.min(row, column)-1)/2 + 1;

        for(int i = 0;i<circle; i++){
            // 从左往右打印
            for(int j = i; j<column-i; j++){
                ret.add(matrix[i][j]);
            }
            // 从上至下
            for(int j = i+1; j<row-i; j++){
                ret.add(matrix[j][column-i-1]);
            }
            // 从右至左
            for(int j = column-2-i; j>=i; j--){
                ret.add(matrix[row-i-1][j]);
            }
            // 从下至上
            for(int j = row-2-i ; j>=i+1; j--){
                ret.add(matrix[j][i]);
            }
        }
        return ret;
    }

    @Test
    public void testPrintMatrix(){
        /*
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13, 14,15,16},
                {17,18,19,20}};
         */



        int[][] matrix = {{1},{2},{3},{4},{5}};
        _01_print_matrix obj = new _01_print_matrix();

        ArrayList<Integer> ret = obj.printMatrix(matrix);

        System.out.println(Arrays.toString(ret.toArray()));
    }

}
