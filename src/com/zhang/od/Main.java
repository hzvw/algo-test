package com.zhang.od;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int m;
    static int n;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("[,\n]"); // 将逗号和换行符作为一次读取的截止符

        m = sc.nextInt();
        n = sc.nextInt();

        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(bfs());
    }

    // 上下左右四个方向对应的偏移量
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 记录路径中位置的几个状态
    static class Node {
        int x; // 位置横坐标
        int y; // 位置纵坐标
        int init; // 到达此位置所需的最少初始油量
        int remain; // 到达此位置时剩余可用油量
        boolean flag; // 到达此位置前有没有加过油

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs() {
        // 如果左上角和右下角不可达，则直接返回-1
        if (arr[0][0] == 0 || arr[m - 1][n - 1] == 0) {
            return -1;
        }

        // 广搜队列
        LinkedList<Node> queue = new LinkedList<>();

        // 起始位置
        Node src = new Node(0, 0);

        if (arr[0][0] == -1) {
            // 如果起始位置就是加油站，则到达(0,0)位置所需初始油量为0，且剩余可用油量为100，且需要标记已加油
            src.init = 0;
            src.remain = 100;
            src.flag = true;
        } else {
            // 如果起始位置不是加油站，则到达(0,0)位置所需的初始油量至少为matrix[0][0], 剩余可用油量为0，未加油状态
            src.init = arr[0][0];
            src.remain = 0;
            src.flag = false;
        }

        queue.add(src);

        // dist_init[x][y] 用于记录起点 (0, 0) 到达 (x, y) 的所有可达路径中最优路径（即初始油量需求最少的路径）的初始油量
        int[][] dist_init = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 由于需要记录每个位置的最少需要的初始油量，因此每个位置所需的初始油量初始化为一个较大值
                dist_init[i][j] = Integer.MAX_VALUE;
            }
        }

        // dist_remain 用于记录起点 (0,0) 到达 (x,y) 的所有可达路径中最优路径（即初始油量需求最少的路径）的最大剩余可用油量
        // 即如果存在多条最优路径，我们应该选这些路径中到达此位置剩余油量最多的
        int[][] dist_remain = new int[m][n];

        // 起点（0,0）到达自身位置（0,0）所需的最少初始油量和最多剩余油量
        dist_init[0][0] = src.init;
        dist_remain[0][0] = src.remain;

        // 广搜
        while (queue.size() > 0) {
            Node cur = queue.removeFirst();

            // 从当前位置cur开始向上下左右四个方向探路
            for (int[] offset : directions) {
                // 新位置
                int newX = cur.x + offset[0];
                int newY = cur.y + offset[1];

                // 新位置越界 或者 新位置是障碍，则新位置不可达，继续探索其他方向
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || arr[newX][newY] == 0) continue;

                // 如果新位置可达，则计算到达新位置的三个状态数据
                int init = cur.init; // 到达新位置所需的最少初始油量
                int remain = cur.remain; // 到达新位置时还剩余的最多可用油量
                boolean flag = cur.flag; // 是否加油了

                if (arr[newX][newY] == -1) {
                    // 如果新位置是加油站，则加满油
                    remain = 100;
                    // 标记加过油了
                    flag = true;
                } else {
                    // 如果新位置不是加油站，则需要消耗matrix[newX][newY]个油
                    remain -= arr[newX][newY];
                }

                // 如果到达新位置后，剩余油量为负数
                if (remain < 0) {
                    if (flag) {
                        // 如果之前已经加过油了，则说明到达此路径前是满油状态，因此我们无法从初始油量里面"借"油
                        continue;
                    } else {
                        // 如果之前没有加过油，则超出的油量（-remain），可以从初始油量里面"借"，即需要初始油量 init + (-remain) 才能到达新位置
                        init -= remain;
                        // 由于初始油量 init + (-remain) 刚好只能支持汽车到达新位置，因此汽车到达新位置后剩余可用油量为0
                        remain = 0;
                    }
                }

                // 如果到达新位置所需的初始油量超过了满油100，则无法到达新位置
                if (init > 100) {
                    continue;
                }

                // 如果可达新位置，则继续检查当前路径策略到达新位置(newX, newY)所需的初始油量init是否比其他路径策略更少
                if (init > dist_init[newX][newY]) {
                    // 如果不是，则无需探索新位置(newX, newY)
                    continue;
                }

                // 当前路径策略到达新位置(newX,newY)所需初始油量init更少，或者，init和前面路径策略相同，但是当前路径策略剩余可用油量remain更多
                if (init < dist_init[newX][newY] || remain > dist_remain[newX][newY]) {
                    // 则当前路径策略更优，记录更优路径的状态
                    dist_init[newX][newY] = init;
                    dist_remain[newX][newY] = remain;

                    // 将当前新位置加入BFS队列
                    Node next = new Node(newX, newY);
                    next.init = init;
                    next.remain = remain;
                    next.flag = flag;

                    queue.add(next);
                }
            }
        }

        // dist_init[m - 1][n - 1] 记录的是到达右下角终点位置所需的最少初始油量
        return dist_init[m - 1][n - 1] == Integer.MAX_VALUE ? -1 : dist_init[m - 1][n - 1];
    }
}