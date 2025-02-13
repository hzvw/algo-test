package algo;

/**
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class _02_three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return ret;
        }

        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            if(!cache.containsKey(nums[i])){
                cache.put(nums[i], 1);
            }else{
                int value = cache.get(nums[i]);
                if(value < 3){
                    changeValue(cache, nums[i], 1);
                }

            }
        }

        Map<Integer, Set<Integer>> repeatMap = new HashMap<Integer, Set<Integer>>();
        Set<Integer> keySet = cache.keySet();

        int[] map = new int[keySet.size()];
        int k = 0;
        for(Integer i : keySet){
            map[k] = i;
            k++;
        }

        for(int i = 0; i<map.length; i++){
            int k1 = map[i];
            changeValue(cache, k1, -1);

            for(int j = i; j<map.length; j++){
                int k2 = map[j];

                if(cache.get(k2) > 0){
                    changeValue(cache, k2, -1);
                    int remain = 0 - k1 - k2;

                    if(cache.containsKey(remain)){
                        if(cache.get(remain) > 0){
                            int max = Math.max(k1, Math.max(k2, remain));
                            int min = Math.min(k1, Math.min(k2, remain));

                            boolean flag = false;
                            if(!repeatMap.containsKey(max)){
                                flag = true;
                                Set<Integer> tmpSet = new HashSet<Integer>();
                                tmpSet.add(min);
                                repeatMap.put(max, tmpSet);
                            }else{
                                Set<Integer> tmpSet = repeatMap.get(max);
                                if(!tmpSet.contains(min)){
                                    flag = true;
                                    tmpSet.add(min);
                                }
                            }
                            if(flag){
                                List<Integer> list = new ArrayList<Integer>();
                                list.add(k1);
                                list.add(k2);
                                list.add(remain);

                                ret.add(list);
                            }
                        }
                    }
                    changeValue(cache, k2, 1);
                }
            }
            changeValue(cache, k1, 1);
        }
        return ret;
    }

    public void changeValue(Map<Integer, Integer> map, Integer key, int ince){
        Integer value = map.get(key);
        int intVal = value.intValue();
        map.put(key, value + ince);
    }

    public List<List<Integer>> threeSum02(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return ret;
        }

        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            if(!cache.containsKey(nums[i])){
                cache.put(nums[i], 1);
            }else{
                int value = cache.get(nums[i]);
                if(value < 3){
                    changeValue(cache, nums[i], 1);
                }

            }
        }

        Set<Integer> keySet = cache.keySet();

        int[] map = new int[keySet.size()];
        int k = 0;
        for(Integer i : keySet){
            map[k] = i;
            k++;
        }
        Arrays.sort(map);

        for(int i = 0; i<map.length-2; i++){
            int left = i;
            int right = map.length-1;

            while(left < right){
                int tmp = map[i] + map[left] + map[right];
                if(tmp == 0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(map[i]);
                    list.add(map[left]);
                    list.add(map[right]);
                }
            }
        }

        return ret;
    }

    // [-1,0,1,2,-1,-4]

    private long l;
    private _02_three_sum obj;

    @Before
    public void set(){
        obj = new _02_three_sum();
        l = System.currentTimeMillis();
    }

    @After
    public void clean(){
        l=System.currentTimeMillis()-l;
        System.out.println("运行时间是 " + l);
    }

    @Test
    public void testThreeSum(){
        int[] sums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ret = obj.threeSum(sums);
        System.out.println(Arrays.toString(ret.toArray()));
    }


}
