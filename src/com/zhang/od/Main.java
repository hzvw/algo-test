package com.zhang.od;

import java.util.Arrays;


public class Main {
    public static void dijkstra(int[][] graph, int src) {
        int n = graph.length;  // 获取节点数

        int[] dist = new int[n];  // 存储源点到各个节点的最短路径
        boolean[] visited = new boolean[n];  // 标记已访问的节点

        // 初始化距离数组，所有距离设为 "无穷大"，源点到自身距离设为 0
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // 处理所有节点
        for (int i = 0; i < n; i++) {
            // 1. 找到当前未访问节点中距离最短的节点
            int u = findMinDistance(dist, visited);

            // 如果找不到可达节点（即所有节点已访问或剩余节点不可达），跳出循环
            if (u == -1) break;

            // 2. 标记该节点为已访问
            visited[u] = true;

            // 3. 更新邻接节点的最短路径
            for (int v = 0; v < n; v++) {
                if (graph[u][v] > 0 && !visited[v]) {  // 存在边，并且节点未访问
                    int newDist = dist[u] + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;  // 更新到 v 的最短距离
                    }
                }
            }
        }

        // 输出结果
        System.out.println("Node\tDistance from Source");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t\t" + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    // 找到未访问节点中最小距离的索引
    private static int findMinDistance(int[] dist, boolean[] visited) {
        int minDist = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 0, 30, 0},
                {10, 0, 50, 0, 0},
                {0, 50, 0, 20, 10},
                {30, 0, 20, 0, 60},
                {0, 0, 10, 60, 0}
        };
        dijkstra(graph, 0);  // 源点为 0
    }
}
