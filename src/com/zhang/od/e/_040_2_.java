package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _040_2_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/3 21:11
 * @Version 1.0
 */
public class _040_2_ {
    static int k;
    static int m;
    static int n;
    static boolean[][] arr;
    static int[] match;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        m = sc.nextInt();
        n = sc.nextInt();
        //m个女生，n个男生，m<=n

        arr = new boolean[m][n];
        match = new int[n];//每个男生的匹配情况
        Arrays.fill(match, -1);

        for (int i = 0; i < k; i++) {
            arr[sc.nextInt()-1][sc.nextInt()-1] = true;
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            boolean isFound = dfs(i, new boolean[n]);
            if(isFound){
                cnt++;
            }
        }
        System.out.println(cnt);


    }

    static boolean dfs(int i, boolean[] visited){

        for (int j = 0; j < n; j++) {
            // i 和j 互相有好感，并且j还没有访问过
            if(arr[i][j] && !visited[j]){
                visited[j] = true;
                if(match[j] == -1 || dfs(match[j], visited)){
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }

}
