package com.zhang.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _056_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 16:27
 * @Version 1.0
 */
public class _056_ {

    public static void main(String[] args) {
        new _056_().subsets(new int[]{1,2,3});

    }

    //返回所有的子集
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        visited = new boolean[nums.length];
        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(visited, false);
            dfs(0, i );
        }
        return res;
    }

    int[] nums ;

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> buckets = new LinkedList<>();
    boolean[] visited ;
    void dfs(int level, int n ){
        if(buckets.size() == n){
            res.add(new ArrayList<>(buckets));
            return;
        }

        for (int i = level; i < nums.length; i++) {
            if (visited[i]){
                continue;
            }

            buckets.addLast(nums[i]);
            visited[i] = true;

            dfs(i+1, n);

            buckets.removeLast();
            visited[i] = false;
        }
    }
}
