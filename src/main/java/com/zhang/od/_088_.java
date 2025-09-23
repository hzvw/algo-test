package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _088_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/22 16:50
 * @Version 1.0
 */
public class _088_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][3];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<3; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int last_j = -1;
        int sum = 0;
        for(int i = 0; i<N; i++){
            int min_ = Integer.MAX_VALUE;
            int tmp = -1;
            for(int j = 0; j<3; j++){
                if(j == last_j){
                    continue;
                }

                if(arr[i][j] <= min_){
                    min_ = arr[i][j];
                    tmp = j;
                }
            }
            last_j = tmp;
            sum += min_;
        }
        System.out.println(sum);


    }



}
