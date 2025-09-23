package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _028_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/16 21:56
 * @Version 1.0
 */
public class _028_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];
        for(int i = 0; i<M; i++){
            arr[i] = sc.nextInt();
        }
        int K = sc.nextInt();

        int[] A = new int[N];
        for(int i = 0; i<M; i++){
            A[arr[i]-1] = 1;
        }
        // 1 代表没有种活
        int max = 0;
        if(K >= arr.length){
            max = N;
        }else{
            for(int i = 0; i<=M-K; i++){
                for(int j = 0; j<K; j++){
                    A[arr[i+j]-1] = 0;
                }
                int res = p(A);
                if(res > max){
                    max = res;
                }
                for(int j = 0; j<K; j++){
                    A[arr[i+j]-1] = 1;
                }
//                if(i == 0){
//                    max = Math.max(max, arr[K]);
//                }else if(i == M-K){
//                    max = Math.max(max, N - 1 - arr[M-K-1]);
//                }else{
//                    max = Math.max(max, );
//                }

            }
        }

        System.out.println(max);
    }

    // 返回数组中最多有多少个连续的0
    static int p(int[] A){
        int max = 0;
        int cnt = 0;
        for(int i = 0; i<A.length;i++){
            if(A[i] == 0){
                cnt++;
            }else{
                if(cnt > max){
                    max = cnt;
                }
                cnt = 0;
            }
        }
        if(cnt > max){
            max = cnt;
        }
        return max;
    }

}
