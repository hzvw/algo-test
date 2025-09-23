package com.zhang.leetcode.bak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _157_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 14:23
 * @Version 1.0
 */
public class _157_ {
    LinkedList<Character> buckets = new LinkedList<>();

    int n ;

    List<String> list = new ArrayList<>();

    char[] cs;

    boolean[] visited;

    void dfs(int level){
        if(level == n){
            list.add((buckets.stream().map(x->x+"").reduce("", String::concat)));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(visited[i]){
                continue;
            }
            if(i-1>=0 && cs[i] == cs[i-1] && !visited[i-1]){
                continue;
            }


            buckets.addLast(cs[i]);
            visited[i] = true;

            dfs(level+1);

            buckets.removeLast();
            visited[i] = false;
        }


    }


    public String[] goodsOrder(String goods) {
        cs = goods.toCharArray();
        Arrays.sort(cs);

        n = goods.length();
        visited = new boolean[n];

        dfs(0);

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
