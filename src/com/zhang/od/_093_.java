package com.zhang.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _093_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/22 23:03
 * @Version 1.0
 */
public class _093_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int tar = Integer.parseInt(sc.nextLine());

        int N = arr.length;

        Arrays.sort(arr);

        int i = 0 ;
        int min_diff = Integer.MAX_VALUE;
        for(; i<=N-3; i++) {
            int j = i+1;
            int k = N-1;
            int t = tar - arr[i];
            while (j < k) {
                if (arr[j] + arr[k] == t) {
                    min_diff = 0;
                    System.out.println(tar);
                    return;
                } else if (arr[j] + arr[k] < t) {
                    min_diff = Math.min(min_diff, t - (arr[j] + arr[k]));
                    j++;
                } else {
                    k--;
                }
            }

        }

        System.out.println(tar - min_diff != 0 ? tar- min_diff:-1);


    }

}
