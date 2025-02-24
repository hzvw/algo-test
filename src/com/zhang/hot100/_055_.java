package com.zhang.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _055_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 16:21
 * @Version 1.0
 */
public class _055_ {

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        visited = new boolean[nums.length];
        dfs(0, nums.length);
        return res;
    }

    int[] nums;
    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> buckets = new LinkedList<>();
    boolean[] visited;

    void dfs(int level, int n){
        if(level == n){
            res.add(new ArrayList<>(buckets));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visited[i]){
                continue;
            }
            buckets.addLast(nums[i]);
            visited[i] = true;

            dfs(level+1, n);

            buckets.removeLast();
            visited[i] = false;
        }

    }

}
