package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _006_
 * Package: com.zhang.od
 * Description:分披萨
 *
 * @Author Harizon
 * @Create 2025/1/14 0:39
 * @Version 1.0
 */
public class _006_ {
    static long[] A;
    static long[][] buffer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new long[N];
        buffer = new long[N][N];

        for(int i = 0; i<N; i++){
            A[i] = sc.nextInt();
        }

        long max = 0;
        for(int i = 0; i<N; i++){
            max = Math.max(max, A[i] + p(check(i-1),check(i+1)));
        }
        System.out.println(max);
    }


    static long p(int i, int j){
        if(A[i] > A[j]){
            i = check(i-1);
        }else{
            j = check(j+1);
        }
        if(buffer[i][j] > 0){
            return buffer[i][j];
        }

        if(i == j){
            buffer[i][j] = A[i];
            return A[i];
        }

        long i1 = A[i] + p( check(i-1), j);
        long i2 = A[j] + p( i, check(j+1));

        buffer[i][j] = i1 > i2 ? i1:i2;
        return buffer[i][j];
    }

    static int check(int i){
        if(i < 0){
            return A.length -1;
        }
        if(i > A.length-1){
            return 0;
        }
        return i;
    }



}
