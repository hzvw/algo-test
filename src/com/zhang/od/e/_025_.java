package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _025_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/1 22:43
 * @Version 1.0
 */
public class _025_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int sum = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] pre = new int[m+1][n+1];
        for(int i = 1; i<m+1; i++){
            for(int j = 1; j<n+1; j++){
                pre[i][j] = pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + arr[i-1][j-1];
            }
        }
        int count = 0;
        for(int i = 0; i<m+1; i++){
            for(int j = 0; j<n+1; j++){
                int i1 = i;
                int j1 = j;
                int i2 = i+k;
                int j2 = j+k;

                if(i2 <m+1 && j2 <n+1){
                    if(pre[i2][j2] + pre[i1][j1] -(pre[i1][j2] + pre[i2][j1])>= sum){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

    }

    public static void test01() {
        int[] arr = {1,2,3,4,5};
        int N = arr.length;
        int[] pre = new int[N+1];

        for(int i = 1; i<N+1; i++){
            pre[i] = pre[i-1] + arr[i-1];
        }

        System.out.println(Arrays.toString(pre));

        // sum[L,R] = pre[R+1]- pre[L]
    }


}
