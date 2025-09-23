package com.zhang.od.e;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * ClassName: _062_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/15 15:08
 * @Version 1.0
 */
public class _062_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int la = 0;
        int ra = n-1;

        int lb = 0;
        int rb = n-1;

        int ans = 0;
        while(la  <= ra){
            // 先比较最快的马
            if(a[ra] > b[rb]){
                // 最快马能赢对方的对快马
                ans++;
                ra--;
                rb--;
            }else if(a[ra] < b[rb]){
                //最慢马必输，去消耗
                ans--;
                la++;
                rb--;
            }else {
                if(a[la] > b[lb]){
                    ans++;
                    la++;
                    lb++;
                }else{
                    if(a[la] < b[rb]){
                        ans--;
                    }
                    la++;
                    rb--;
                }
            }

        }
        System.out.println(ans);
    }
}
