package com.zhang.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _058_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 17:09
 * @Version 1.0
 */
public class _058_ {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        this.can = candidates;
        dfs(0, 0);
        return res;
    }

    List<List<Integer>> res = new LinkedList<>();

    LinkedList<Integer> buckets = new LinkedList<>();
    int target;

    int[] can;

    void dfs(int level,   int sum){
        if(sum == target){
            res.add(new ArrayList<>(buckets));
            return;
        }
        if(sum > target){
            return;
        }

        for (int i = level; i < can.length; i++) {
            buckets.addLast(can[i]);
            sum += can[i];

            dfs(i, sum);

            buckets.removeLast();
            sum -= can[i];
        }
    }

}
