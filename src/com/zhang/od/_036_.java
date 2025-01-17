package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _036_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/17 15:37
 * @Version 1.0
 */
public class _036_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(",");
        int N = words.length;
        int[] arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(words[i]);
        }

        int sum = Integer.parseInt(sc.nextLine());

        int[] sum_1 = new int[N+1];
        for(int i = 1; i<N+1; i++){
            sum_1[i] = sum_1[i-1] + arr[i-1];
        }

        int max_len = -1;
        for(int i = 1; i<N+1; i++){
            for(int j = i; j<N+1; j++){
                if(sum_1[j] - sum_1[i-1] == sum){
                    max_len = Math.max(max_len, j - i + 1);
                }
            }
        }
        System.out.println(max_len);


    }

}
