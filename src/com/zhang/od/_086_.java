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
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

        long[] pre = new long[n+1];
        for (int i = 1; i <=n ; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }

        long cnt = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j <= n ; j++) {
                if(pre[j]- pre[i] >= x){
                    cnt += n-j+1;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

}
