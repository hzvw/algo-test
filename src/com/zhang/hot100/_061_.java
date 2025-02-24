package com.zhang.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _061_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 18:24
 * @Version 1.0
 */
public class _061_ {
    List<List<String>> res = new ArrayList<>();

    LinkedList<String> buckets = new LinkedList<>();
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;

        dfs(0,  new StringBuilder());
        return res;
    }

    void dfs(int level , StringBuilder sb){
        if(level == s.length()){
            res.add(new ArrayList<>(buckets));
            return;
        }

        for (int i = level; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if(check(sb)){
                buckets.addLast(sb.toString());

                dfs(i+1,  new StringBuilder());

                buckets.removeLast();
            }
        }
    }


    boolean check(StringBuilder sb){
        int n = sb.length();

        for (int i = 0; i < n/2; i++) {
            if(sb.charAt(i) != sb.charAt(n-1-i)){
                return  false;
            }
        }
        return true;
    }


}
