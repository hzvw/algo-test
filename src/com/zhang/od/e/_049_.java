package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _049_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/11 22:17
 * @Version 1.0
 */
public class _049_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int m = sc.nextInt();

        int left = 1;
        int right = arr[n-1] - arr[0];

        int ans = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(check(arr, n, m, mid)){
                //right = mid-1;
                ans = mid;
                left = mid+1;
            }else{
//                left = mid+1;
                right = mid-1;
            }
        }
        System.out.println(ans);
    }

    static boolean check(int[] arr, int n, int m, int mid){
        int last = 0;
        int count = 1;
        for (int  i = 1; i < n; i++) {
            if(arr[i] - arr[last] >= mid){
                count++;
                last = i;
            }
        }
        return count >= m;
    }

//    ConcurrentHashMap

}
