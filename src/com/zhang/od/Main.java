package com.zhang.od;
import java.util.Scanner;

public class Main {
    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] msgs = new int[m][3];
        for (int i = 0; i < m; i++) {
            msgs[i][0] = sc.nextInt();
            msgs[i][1] = sc.nextInt();
            msgs[i][2] = sc.nextInt();
        }

        getResult(msgs, n, m);
    }

    public static void getResult(int[][] msgs, int n, int m) {
        // 如果第一行 n 和 m 的值超出约定的范围时，输出字符串”Null“。
        // 1<=n,m<100000
        if (n < 1 || n >= 100000 || m < 1 || m >= 100000) {
            System.out.println("NULL");
            return;
        }

        UnionFindSet ufs = new UnionFindSet(n + 1);

        for (int[] msg : msgs) {
            int a = msg[0], b = msg[1], c = msg[2];

            if (a < 1 || a > n || b < 1 || b > n) {
                // 当前行 a 或 b 的标号小于 1 或者大于 n 时，输出字符串‘da pian zi‘
                System.out.println("da pian zi");
                continue;
            }

            if (c == 0) {
                // c == 0 代表 a 和 b 在一个团队内
                ufs.union(a, b);
            } else if (c == 1) {
                // c == 1 代表需要判定 a 和 b 的关系，如果 a 和 b 是一个团队，输出一行’we are a team’,如果不是，输出一行’we are not a team’
                System.out.println(ufs.find(a) == ufs.find(b) ? "we are a team" : "we are not a team");
            } else {
                // c 为其他值，输出字符串‘da pian zi‘
                System.out.println("da pian zi");
            }
        }
    }
}

// 并查集实现
class UnionFindSet {
    int[] fa;

    public UnionFindSet(int n) {
        this.fa = new int[n];
        for (int i = 0; i < n; i++){
            fa[i] = i;
        }
    }

    public int find(int x) {
        if (fa[x] != x) {
            return find(fa[x]);
        }
        return x;
    }

    public void union(int x, int y) {
        int x_fa = find(x);
        int y_fa = find(y);

        if (x_fa != y_fa) {
            fa[y_fa] = x_fa;
        }
    }
}