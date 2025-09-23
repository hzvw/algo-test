package com.zhang.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _065_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 21:03
 * @Version 1.0
 */
public class _065_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int K = sc.nextInt();

        int window_len = 0;
        for(int val : arr){
            if(val < K){
                window_len++;
            }
        }

        int min = Integer.MAX_VALUE;
        int swap = 0;
        for(int i = 0; i<window_len; i++){
            if(arr[i] >= K){
                swap++;
            }
        }
        min = Math.min(swap, min);

        for(int i = 1; i<=arr.length-window_len; i++){
            int left = i;
            int right = i+window_len-1;

            //
            if(arr[left-1] >= K){
                swap--;
            }else{

            }

            if(arr[right] < K){

            }else{
                swap++;
            }

            min = Math.min(swap, min);
        }
        System.out.println(min);



    }

}
