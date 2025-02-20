package com.zhang.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _059_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 17:24
 * @Version 1.0
 */
public class _059_ {
    public List<String> generateParenthesis(int n) {
        dfs( new LinkedList<>(), n, 0, 0);
        return res;
    }

    List<String> res = new ArrayList<>();

    void dfs(LinkedList<Character> buckets, int n, int p, int q){
        if(p < q){
            return;
        }

        if(p > n || q > n){
            return;
        }

        if(p == n && q == n){
            res.add(buckets.stream().map(x->x+"").reduce("", String::concat));
            return;
        }

        buckets.addLast('(');
        dfs( buckets, n, p+1, q);
        buckets.removeLast();

        buckets.addLast(')');
        dfs( buckets, n, p, q+1);
        buckets.removeLast();
    }
}
