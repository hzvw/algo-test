package com.zhang.leetcode.bak;

import javax.swing.text.AbstractDocument;
import java.util.Arrays;

/**
 * ClassName: _698_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/5/6 21:28
 * @Version 1.0
 */
// 划分等和子集
public class _698_ {
    public static void main(String[] args) {
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0){
            return false;
        }
        this.capacity = sum / k;
        this.nums = nums;
        this.k = k;
        buckets = new int[k];
        return dfs(0);
    }

    int[] buckets;

    int k;

    int[] nums;

    int capacity;

    boolean dfs(int level){
        if(level == nums.length){
            return true;
        }

        for (int i = 0; i < k; i++) {
            if(i-1 >= 0 && buckets[i] == buckets[i-1]){
                continue;
            }

            if(nums[level] + buckets[i] <= capacity){
                buckets[i] += nums[level];
                if(dfs(level+1)){
                    return true;
                }
                buckets[i] -= nums[level];
            }
        }

        return false;
    }

}
