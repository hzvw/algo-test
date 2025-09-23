package com.zhang.leetcode.bak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _047_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/5/6 22:10
 * @Version 1.0
 */
// 全排列二
public class _047_ {

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> bucket = new LinkedList<>();

    int[] nums;

    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        dfs(0);
        return res;
    }

    void dfs(int level){
        if(level == nums.length){
            res.add(new ArrayList<>(bucket));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]){
                continue;
            }

            if(i-1>=0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }

            bucket.addLast(nums[i]);
            visited[i] = true;

            dfs(level+1);

            bucket.removeLast();
            visited[i] = false;
        }

    }

}
