package other;

import java.util.*;
/*
public class _16_partition_to_k_equal_sum_subsets {
    boolean res = false;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] bucket = new int[k];
        int sum = 0;
        for(int i=0;i<nums.length; i++){
            sum += nums[i];
        }
        if(sum % k != 0){
            return false;
        }
        int target = sum / k;

        return backtrace(nums, 0, target, bucket);
        //return res;
    }

    boolean backtrace(int[] nums, int i, int target, int[] bucket){
        if(i == nums.length){
            return false;
        }
        for(int j = 0; j<k; j++){
            // nums[i] 是否要放在j号桶里
            bucket[j] += nums[i];
            backtrace(nums, i+1);
            bucket[j] -= nums[i];
        }
    }

    void traverse1(int[] nums){
        for(int i = 0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    void traverse2(int[] nums, int i){
        if(i == nums.length) return;
        System.out.println(nums[i]);
        traverse2(nums,i+1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        _16_partition_to_k_equal_sum_subsets obj = new _16_partition_to_k_equal_sum_subsets();
        obj.traverse1(nums);
        obj.traverse2(nums,0);
    }
}
 */
