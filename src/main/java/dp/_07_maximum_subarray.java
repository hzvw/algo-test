package dp;

import java.util.Arrays;

public class _07_maximum_subarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int ret = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(dp[i-1]<0){
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i-1] + nums[i];
            }
            if(dp[i] > ret){
                ret = dp[i];
            }
        }
        //System.out.println(ret);
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        new _07_maximum_subarray().maxSubArray(nums);


    }

}
