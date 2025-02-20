package com.zhang.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _062_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 18:46
 * @Version 1.0
 */
public class _062_ {
    public static void main(String[] args) {
        int n = 4;
        new _062_().solveNQueens(n);
    }

    List<List<String>> res = new ArrayList<>();
    LinkedList<Integer> buckets = new LinkedList<>();
    boolean[][] visited;

    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        visited = new boolean[n][n];

        dfs(0);
        return res;
    }

    void dfs(int level){
        if(level == n){
            res.add(m1());
            return;
        }

        for (int j = 0; j < n; j++) {
            if(visited[level][j]){
               continue;
            }

            if(check(level, j)){
                buckets.addLast(j);
                visited[level][j] = true;

                dfs(level+1);

                buckets.removeLast();
                visited[level][j] = false;
            }
        }
    }

    boolean check(int i, int j){
        for (int k = 0; k < buckets.size(); k++) {
            int x = k;
            int y = buckets.get(k);

            if(y == j || Math.abs(y-j) == Math.abs(i-k)){
                return false;
            }
        }
        return true;
    }

    List<String> m1(){
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < buckets.size(); i++) {
            int index = buckets.get(i);
            for (int j = 0; j < n; j++) {
                sb.append(j == index ? "Q":".");
            }
            list.add(sb.toString());
            sb = new StringBuilder();
        }
        return list;
    }


}
