package com.zhang.od;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        sc.nextLine();

        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                if (b[j] - a[i] <= r) System.out.println(a[i] + " " + b[j]);
                i++;
            } else {
                j++;
            }
        }
    }
}