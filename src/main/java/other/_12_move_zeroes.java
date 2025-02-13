package other;

import java.util.Arrays;

public class _12_move_zeroes {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return;
        }

        int i = 0;
        int j = 0;
        while(i <nums.length && j <nums.length){
            while (i<nums.length && nums[i] != 0){
                i++;
            }
            while(j<nums.length && nums[j] == 0){
                j++;
            }
            System.out.println(i + " "+j);
            if(i<nums.length && j<nums.length){
                swap(nums, i, j);
            }

        }
    }

    void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1,0};
        new _12_move_zeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
