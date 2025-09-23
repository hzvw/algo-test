package com.zhang.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _122_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/27 16:02
 * @Version 1.0
 */
public class _122_ {
    public static void main01(String[] args) {
        System.out.println(Integer.MAX_VALUE);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = nums[0];
        int n = nums[1];
        int r = nums[2];

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] brr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int i = 0;
        int j = 0;
        while (i<m && j<n) {
            if(brr[j] >= arr[i] ){
                if(brr[j] - arr[i] <= r){
                    System.out.println(arr[i] + " " + brr[j]);
                }
                i++;
            }else{
                j++;
            }
        }

    }


}
