package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _086_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/17 18:42
 * @Version 1.0
 */
public class _086_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long max = sc.nextLong();
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long sum = Arrays.stream(arr).sum();
        if(sum <= max){
            System.out.println("[]");
        }else{
            System.out.println(m1(arr, max, sum));
        }

    }

    private static String m1(long[] arr, long max, long sum) {
        long left = 1;
        long right = Arrays.stream(arr).max().getAsLong();
        while(left <= right){
            long mid = (right + left)/2;
            if(check(mid, arr, max)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > right){
                res.add((arr[i]- right)+"" );
            }else{
                res.add(0 +"");
            }

        }
        return "[" + String.join(",", res) + "]";
    }

    private static boolean check(long maxCapacity, long[] arr, long max) {

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > maxCapacity){
                sum += maxCapacity;
            }else{
                sum += arr[i];
            }
        }
        return sum <= max;
    }

}
