package algo;

/**
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
import java.util.*;

public class _01_two_sum {

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];

        if(nums == null || nums.length == 0){
            return ret;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            //if(!map.containsKey(nums[i])){
                if(map.containsKey(target - nums[i])){
                    ret[0] = map.get(target - nums[i]);
                    ret[1] = i;
                }
                map.put(nums[i], i);

                System.out.println(nums[i] + "  " + i);
            //}
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;

        new _01_two_sum().twoSum(nums, target);


    }
}
