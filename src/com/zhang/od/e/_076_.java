package com.zhang.od.e;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * ClassName: _076_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/16 16:32
 * @Version 1.0
 */
public class _076_ {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();

        int ans = compute(r) - compute(l-1);

        System.out.println(ans);

    }

    static int compute(int i){
        String str = Integer.toBinaryString(i);

        int[][][] dp = new int[str.length()][2][2];
        return dfs(true, 0, str.length(), str, dp,0,0);
    }

    static int dfs(boolean limit, int level, int n, String str, int[][][] dp, int pre, int prepre){
        if(level == n){
            return 1;
        }

        if(!limit && dp[level][pre][prepre] > 0){
            return dp[level][pre][prepre];
        }

        int count = 0;
        int max = limit ? (str.charAt(level) - '0') : 1;
        for (int i = 0; i <=max; i++) {
            if(i == 1 && pre == 0 && prepre == 1){
                continue;
            }
            count += dfs(limit && i == max, level+1, n, str, dp, i, pre);
        }

        if(!limit){
            dp[level][pre][prepre] = count;
        }
        return count;
    }



}
