package com.zhang.od2._100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _014_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 17:24
 * @Version 1.0
 */
public class _014_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.add(a[i] + b[j]);
            }
        }
        list.sort((x,y) -> x-y);

        int  sum = 0;
        for (int i = 0; i < k; i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
