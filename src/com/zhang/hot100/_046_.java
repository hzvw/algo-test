package com.zhang.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _046_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/9 2:19
 * @Version 1.0
 */
public class _046_ {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        List<List<Integer>> res = new _046_().permute(arr);

//        List<List<Integer>> res = new ArrayList<>();
//        p2(arr, 2, new LinkedList<Integer>(),res, -1);
        res.forEach(x ->{
            x.forEach(a -> System.out.print(a + " "));
            System.out.println();
        });
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        p(nums, 0, nums.length, res,new LinkedList<Integer>(), visited);
        return res;
    }

    // 求排列
    static void p(int[] nums, int level, int n, List<List<Integer>> res, LinkedList<Integer> buckets, boolean[] visited){
        if(buckets.size() == n){
            res.add(new ArrayList<>(buckets));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(visited[i]){
                continue;
            }

            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            buckets.addLast(nums[i]);
            visited[i] = true;
            p(nums, level+1, n, res,buckets, visited);

            buckets.removeLast();
            visited[i] = false;
        }
    }

    // 求组合
    static void p2(int[] nums, int n, LinkedList<Integer> buckets, List<List<Integer>> res, int pre){
        if(buckets.size() == n){
            res.add(new ArrayList<>(buckets));
            return;
        }

        for(int i = pre+1; i<nums.length; i++){
            buckets.addLast(nums[i]);
            p2(nums, n, buckets, res, i);
            buckets.removeLast();
        }


    }
}
