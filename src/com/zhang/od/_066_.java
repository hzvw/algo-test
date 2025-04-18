package com.zhang.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _066_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 21:30
 * @Version 1.0
 */
public class _066_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(p(arr));
    }

    static int p(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        boolean[] color = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(color[i]){
                continue;
            }
            color[i] = true;
            for (int j = i+1; j < n; j++) {
                if(!color[j] && arr[j] % arr[i] == 0){
                    color[j] = true;
                }
            }
            count++;
        }


        return count;
    }

}
