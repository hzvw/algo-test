package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _072_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/30 19:47
 * @Version 1.0
 */
public class _072_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int N = arr.length;

        int l = N-M-1;
        int r = N-M;
        int max = arr[N-1];
        while (l >= 0){
            max = Math.max(max, arr[l]+arr[r]);
            r++;
            l--;
        }
        System.out.print(max);


    }

}
