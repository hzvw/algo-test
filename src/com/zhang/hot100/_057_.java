package com.zhang.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _057_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 16:51
 * @Version 1.0
 */
public class _057_ {


    boolean[] visited;

    String[] dic = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        char[] cs = digits.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            int index = cs[i] - '2';
            list.add(dic[index]);
        }
        visited = new boolean[list.size()];
        dfs(0, list.size(), list, new LinkedList<>());
        return res;
    }

    List<String> res = new ArrayList<>();

    void dfs(int level, int n, List<String> list, List<Character> buckets){
        if(n == level){
            if(!buckets.isEmpty()){
                res.add(buckets.stream().map(x -> x+"").reduce("", String::concat));
            }
            return;
        }

        for (int i = level; i < list.size(); i++) {
            if(visited[i]){
                continue;
            }

            char[] cs = list.get(i).toCharArray();
            for (int j = 0; j < cs.length; j++) {
                buckets.addLast(cs[j]);
                visited[i] = true;

                dfs(level+1, n, list, buckets);

                buckets.removeLast();
                visited[i] = false;
            }
        }

    }


}
