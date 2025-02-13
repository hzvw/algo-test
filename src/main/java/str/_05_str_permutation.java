package str;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 */
import java.util.*;

public class _05_str_permutation {

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> buffer = new ArrayList<Integer>();
        sol(nums, buffer);
        return res;
    }

    void sol(int[] nums, List<Integer> buffer){
        if(buffer.size() == nums.length) {
            res.add(new ArrayList<>(buffer));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(buffer.contains(nums[i])) continue;
            buffer.add(nums[i]);
            sol(nums, buffer);
            buffer.remove(buffer.size()-1);
        }
    }

}
