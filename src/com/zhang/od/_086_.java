package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _086_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/22 1:06
 * @Version 1.0
 */
public class _086_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        long[] arr = new long[n+1];
        for(int i = 1; i<=n;i++){
            arr[i] = arr[i-1] + sc.nextLong();
        }

        long cnt = 0;
        for(int i = 0; i<=n-1; i++){
            for(int j = i+1; j<=n; j++){
                if(arr[j] - arr[i] >= x){
                    long k = n-(j-1);
                    cnt = cnt + k;
                    break;
//                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

}
