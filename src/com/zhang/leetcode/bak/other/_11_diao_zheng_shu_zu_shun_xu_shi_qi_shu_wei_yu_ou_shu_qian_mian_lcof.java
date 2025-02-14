package other;

import java.util.Arrays;

public class _11_diao_zheng_shu_zu_shun_xu_shi_qi_shu_wei_yu_ou_shu_qian_mian_lcof {

    public int[] exchange(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return nums;
        }

        int i = 0;
        int j = nums.length - 1;

        while(i < j){
            while(i<nums.length && nums[i] % 2 == 1){
                i++;
            }
            while(j>=0 && nums[j] % 2 == 0){
                j--;
            }
            if(i < j){
                swap(nums, i , j);
            }

            //System.out.println(i + "  " + j);
        }
        return nums;
    }

    void swap(int[] nums, int i , int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        new _11_diao_zheng_shu_zu_shun_xu_shi_qi_shu_wei_yu_ou_shu_qian_mian_lcof().exchange(nums);
        System.out.println(Arrays.toString(nums));
    }
}
