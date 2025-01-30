package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

public class HungarianAlgorithm {
    static int n, m;  // 左、右集合的大小
    static boolean[][] graph;  // 二分图的邻接矩阵
    static int[] match;  // 记录右侧节点匹配的左侧节点
    static boolean[] visited;  // 记录访问状态，避免重复访问

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 左侧集合大小
        m = sc.nextInt();  // 右侧集合大小
        int edges = sc.nextInt();  // 边的数量
        graph = new boolean[n][m];
        match = new int[m];
        visited = new boolean[n];

        // 初始化匹配数组，-1表示没有匹配
        Arrays.fill(match, -1);

        // 读取边
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();  // 左侧点编号
            int v = sc.nextInt();  // 右侧点编号
            graph[u][v] = true;  // 连接二分图
        }

        // 寻找最大匹配
        int result = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            if (dfs(i)) {
                result++;  // 匹配数加一
            }
        }

        System.out.println("最大匹配数：" + result);
    }

    static boolean dfs(int u) {
        for (int v = 0; v < m; v++) {
            if (graph[u][v] && !visited[v]) {
                visited[v] = true;  // 标记访问
                // 若 v 还没有匹配，或者它的匹配对象可以另找匹配
                if (match[v] == -1 || dfs(match[v])) {
                    match[v] = u;  // 让 u 和 v 匹配
                    return true;
                }
            }
        }
        return false;
    }
}
