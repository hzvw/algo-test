package com.zhang.leetcode.bak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _087_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/5/6 11:40
 * @Version 1.0
 */

// 复原ip地址
public class _087_ {
    public static void main(String[] args) {
        String s = "0000";
        List<String> list = new _087_().restoreIpAddresses(s);
        list.forEach(System.out::println);
    }

    List<String> res = new ArrayList<>();
    LinkedList<String> buckets = new LinkedList<>();

    String s;

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        dfs(0);
        return res;
    }

    void dfs(int level){
        if(level == s.length() && buckets.size() == 4){
            res.add(String.join(".", buckets));
            return;
        }


        for (int j = level+1; j <= s.length(); j++) {
            if(check(level,j) && buckets.size() < 4){
                buckets.addLast(s.substring(level, j));
                dfs(j);
                buckets.removeLast();
            }
        }
    }

    boolean check(int i, int j){
        if(s.charAt(i) == '0'){
            if(j - i == 1){
                return true;
            }else{
                return false;
            }
        }

        if(j - i > 3){
            return false;
        }
        int num = Integer.parseInt(s.substring(i, j));
        if(num >= 0 && num <= 255){
            return true;
        }else{
            return false;
        }
    }


}
