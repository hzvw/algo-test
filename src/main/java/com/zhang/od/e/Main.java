package com.zhang.od.e;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("[,\n]");
 
        int n = Integer.parseInt(sc.nextLine());
 
        int[][] ranges = new int[n][2];
        for (int i = 0; i < n; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
 
        System.out.println(getResult(ranges));
    }
 
    public static int getResult(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
 
        LinkedList<int[]> stack = new LinkedList<>();
        stack.add(ranges[0]);
 
        for (int i = 1; i < ranges.length; i++) {
            int[] range = ranges[i];
 
            while (true) {
                if (stack.isEmpty()) {
                    stack.add(range);
                    break;
                }
 
                int[] top = stack.getLast();
                int s0 = top[0];
                int e0 = top[1];
 
                int s1 = range[0];
                int e1 = range[1];
 
                if (s1 <= s0) {
                    if (e1 <= s0) {
                        break;
                    } else if (e1 < e0) {
                        break;
                    } else {
                        stack.removeLast();
                    }
                } else if (s1 < e0) {
                    if (e1 <= e0) {
                        break;
                    } else {
                        stack.add(new int[]{e0, e1});
                        break;
                    }
                } else {
                    stack.add(range);
                    break;
                }
            }
        }
 
        return stack.size();
    }
}