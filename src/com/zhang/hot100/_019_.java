package com.zhang.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _019_
 * Package: com.zhang.hot100
 * Description:螺旋矩阵
 *
 * @Author Harizon
 * @Create 2025/2/18 19:23
 * @Version 1.0
 */
public class _019_ {
    public static void main(String[] args) {


    }

    public List<Integer> spiralOrder(int[][] arr) {
        int m = arr.length;//行数
        int n = arr[0].length;//列数

        int x1 = 0;
        int y1 = 0;
        int x2 = m-1;
        int y2 = n-1;

        List<Integer> res = new ArrayList<>();
        while (x1 <= x2 && y1 <= y2){
            print(x1, y1, x2, y2, arr, res);
            x1++;y1++;x2--;y2--;
        }
        return res;
    }

    private void print(int x1, int y1, int x2, int y2, int[][] arr, List<Integer> res) {
        //如果只有一行
        if(x1 == x2){
            for (int i = y1; i <= y2 ; i++) {
                res.add(arr[x1][i]);
            }
        }else if(y1 == y2){
            for (int i = x1; i <= x2; i++) {
                res.add(arr[i][y1]);
            }
        }else{
            for (int i = y1; i <= y2 ; i++) {
                res.add(arr[x1][i]);
            }
            for (int i = x1+1; i <= x2; i++) {
                res.add(arr[i][y2]);
            }
            for (int i = y2-1; i >= y1 ; i--) {
                res.add(arr[x2][i]);
            }
            for (int i = x2-1; i >= x1+1; i--) {
                res.add(arr[i][y1]);
            }
        }

    }


}
