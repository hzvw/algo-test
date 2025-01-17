package com.zhang.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _031_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/17 12:12
 * @Version 1.0
 */
public class _031_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int sum = arr[0];
        int x = arr[0];
        for(int i = 1; i<N; i++){
            sum += arr[i];
            x = x ^ arr[i];//
        }

        if(x == 0){
            System.out.println(sum - arr[0]);
        }else{
            System.out.println(-1)
            ;
        }


    }

}
