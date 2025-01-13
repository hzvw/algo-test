package com.zhang.od;

import java.util.*;
/**
 * ClassName: _090_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/8 1:37
 * @Version 1.0
 */
public class _090_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(",");
        int[] arr = new int[words.length];
        for(int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(words[i]);
        }
        //int[] arr = {92,-48,12,2,-4,-55,-15,-79,24,-57,1,18,5,3,-57,-65};
        System.out.println(p(arr, arr.length-1));

    }

    static int p(int[] arr, int i){
        if(i<0){
            return 0;
        }
        if(i == 0){
            return Math.max(arr[i], 0);
        }
        // 决策
        return Math.max(p(arr, i-3), arr[i] + p(arr, i-1));

    }


}
