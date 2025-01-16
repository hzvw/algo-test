package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _026_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/16 20:26
 * @Version 1.0
 */
public class _026_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            String[] words = sc.nextLine().split(" ");
            int[] arr = new int[words.length];
            for(int i = 0; i<arr.length; i++){
                arr[i] = Integer.parseInt(words[i]);
            }
            for(int i = 0; i<arr.length-1; i++){
                boolean flag = false;
                if(i % 2 == 0){
                    flag = arr[i] < arr[i+1];
                }else{
                    flag = arr[i] > arr[i+1];
                }
                if(flag){
                    swap(arr, i, i+1);
                }
            }
            for(int i = 0; i<arr.length; i++){
                System.out.print(arr[i] + " ");
            }

        }catch(Exception e){
            System.out.println("[]");
        }


    }

    static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
