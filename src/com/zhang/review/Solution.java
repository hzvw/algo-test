package com.zhang.review;

import com.zhang.hot100.ListNode;

import java.util.*;

/**
 * ClassName: Solution
 * Package: com.zhang.review
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/6 10:39
 * @Version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat","cats","and","sand","dog"};
        List<String> list = Arrays.asList(wordDict);
        List<String> res = new Solution().wordBreak(s, list);
        res.forEach(System.out::println);
    }

    public List<String> wordBreak(String s, List<String> wordDict){
        this.s = s;
        wordDict.forEach(x -> set.add(x));

        dfs(0);
        return res;
    }


    String s;

    LinkedList<String> buckets = new LinkedList<>();
    void dfs(int level){
        if(level == s.length()){
            res.add(String.join(" ", buckets));
            return;
        }
        for (int i = level+1; i <= s.length(); i++) {
            if(set.contains(s.substring(level, i))){
                buckets.addLast(s.substring(level, i));
                dfs(i);
                buckets.removeLast();
            }
        }
    }
    Set<String> set = new HashSet<>();
    List<String> res = new ArrayList<>();





}
