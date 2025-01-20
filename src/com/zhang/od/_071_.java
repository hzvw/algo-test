package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _071_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/20 1:20
 * @Version 1.0
 */
public class _071_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int col = (int) Math.ceil(n*1.0/m);
        my_print(n,m, col);
    }

    static void my_print(int n, int m ,int col){
         List<Integer> i1 = new ArrayList<>();
         // m 行数
        // col 列数

        int start_x = 0;//行数0~m-1
        int start_y = 0;//列数0~col-1

        int end_x = m-1;//最后一行
        int end_y = col-1;//最后一列

        arr = new int[m][col];

        while(start_x <= end_x && start_y <= end_y){
            print(i1, start_x, start_y,end_x,end_y);
            start_x++;
            start_y++;
            end_x--;
            end_y--;
        }

        for(int i = 0;i<m; i++){
            for(int j = 0; j<col; j++){
//                System.out.print(arr[i][j] + " ");
                if(arr[i][j] <= n){
                    System.out.print(arr[i][j] + " ");
                }else{
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }

    }

    static int num = 1;
    static int[][] arr ;

    static void print(List<Integer> i1, int start_x,int start_y,int end_x, int end_y){
        if(start_x == end_x){
            for(int i = start_y; i<=end_y; i++){
                arr[start_x][i] = num;
                num++;
            }
        }else if(start_y == end_y){
            for(int i = start_x; i<=end_x; i++){
                arr[i][start_y] = num;
                num++;
            }
        }else{
            for(int i = start_y; i<=end_y; i++){

                arr[start_x][i] = num;
                num++;
            }
            for(int i = start_x+1; i<=end_x; i++){

                arr[i][end_y] = num;
                num++;
            }
            for(int i = end_y-1;i>=start_y;i--){

                arr[end_x][i] = num;
                num++;
            }
            for(int i = end_x-1; i>=start_x+1;i--){

                arr[i][start_y] = num;
                num++;
            }

        }
    }

}

class Solution {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> list = printMatrix(arr);
        list.forEach(System.out::println);


    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null)    return null;
        int startX = 0, startY = 0;
        int endX = matrix.length - 1, endY = matrix[0].length - 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (startX <= endX && startY <= endY) {
            print(matrix, startX++, startY++, endX--, endY--, list);
        }
        return list;
    }
    private static  void print(int[][] matrix, int startX, int startY, int endX, int endY, ArrayList<Integer> list) {
        if (startX == endX) { // 只有一行了
            for (int i = startY; i <= endY; ++i) {
                list.add(matrix[startX][i]);
            }
        } else if (startY == endY) { // 只有一列了
            for (int i = startX; i <= endX; ++i) {
                list.add(matrix[i][startY]);
            }
        } else {
            int curX = startX, curY = startY;
            while (curY != endY) {
                list.add(matrix[startX][curY++]);
                System.out.println(startX + ":" + curY);
            }
            while (curX != endX) {
                list.add(matrix[curX++][endY]);
            }
            while (curY != startY) {
                list.add(matrix[endX][curY--]);
            }
            while (curX != startX) {
                list.add(matrix[curX--][startY]);
            }
        }
    }
}

