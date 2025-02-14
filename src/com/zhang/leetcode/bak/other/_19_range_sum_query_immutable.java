package other;
/* leetcode 303 */
public class _19_range_sum_query_immutable {
    static class NumArray {
        int[] preSum;
        public NumArray(int[] nums) {
            preSum = new int[nums.length + 1];
            preSum[0] = 0;
            for(int i = 1; i<=nums.length; i++){
                preSum[i] = preSum[i-1] + nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right+1]-preSum[left];
        }
    }


}
