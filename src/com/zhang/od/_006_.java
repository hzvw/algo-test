package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _006_
 * Package: com.zhang.od
 * Description:分披萨
 *
 * @Author 张汉至
 * @Create 2025/1/14 0:39
 * @Version 1.0
 */
public class _006_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N];

        for(int i = 0; i<N; i++){
            A[i] = sc.nextInt();
        }

        int max = 0;
        for(int i = 0; i<N; i++){
            max = Math.max(max, A[i] + p(check(i-1),check(i+1)));
        }
        System.out.println(max);


    }

    static int[] A;
    static int p(int i, int j){
        if(A[i] > A[j]){
            i = check(i-1);
        }else{
            j = check(j+1);
        }

        if(i == j){
            return A[i];
        }
        return Math.max(A[i] + p( check(i-1), j), A[j] + p( i, check(j+1)));
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
