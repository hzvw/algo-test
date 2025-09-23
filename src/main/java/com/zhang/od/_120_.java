package com.zhang.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _120_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/27 0:59
 * @Version 1.0
 */
public class _120_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] arr = Arrays.stream(sc.nextLine().split(",")).mapToLong(Long::parseLong).toArray();
        int i = 0;
        int j = arr.length-1;
        long res = 0L;
        while (i < j){
            res = Math.max(res, (j-i) * Math.min(arr[i], arr[j]));
            if(arr[i] < arr[j]){
                i++;
            }else{
                j--;
            }

        }
        System.out.println(res);
    }
}
