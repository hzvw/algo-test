package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _097_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/23 2:53
 * @Version 1.0
 */
public class _097_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0;i<N; i++){
            arr[i] = sc.nextInt();
        }

        int[][] map = new int[N][2];
        for(int i = 0; i<N; i++){
            for (int j = i+1; j<N; j++){
                if(arr[j] > arr[i]){
                    map[i][0] = j-i;
                    map[i][1] = arr[j]-arr[i];
                    break;
                }
            }
        }

        for(int i = 0; i<N; i++){
            int res = 0;
            if(map[i][0] != 0){
                res = map[i][0] * map[i][1];
            }else{
                res = arr[i];
            }
            System.out.print(res+" ");
        }


    }

}
