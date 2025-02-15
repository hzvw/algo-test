package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _069_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/15 22:56
 * @Version 1.0
 */
public class _069_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = arr.length;



    }

    static int m1(int i, int n){
        if(i < 0){
            return i+n;
        }
        if(i > n-1){
            return i % n;
        }
        return i;
    }

}
