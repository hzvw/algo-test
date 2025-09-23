package com.zhang.od2._100;

import java.util.*;

/**
 * ClassName: _018_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/30 18:14
 * @Version 1.0
 */
public class _018_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int sum = Integer.parseInt(sc.nextLine());

        int[] nums = Arrays.stream(str.replaceAll("\\[|\\]", "")
                .split(",")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new TreeSet<>());
            map.get(nums[i]).add(i);
        }

        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(sum - nums[i])){
                TreeSet<Integer> set = map.get(sum - nums[i]);
                if(set.size() == 1){
                    if(set.first() != i){
                        if(i + set.first() < min){
                            min = i + set.first();
                            if(i < set.first()){
                                res[0] = nums[i];
                                res[1] = nums[set.first()];
                            }else{
                                res[1] = nums[i];
                                res[0] = nums[set.first()];
                            }

                        }
                    }
                }else{
                    for (Integer ele : set) {
                        if(ele != i){
                            if(i + ele < min){
                                min = i + ele;
                                if(i < ele){
                                    res[0] = nums[i];
                                    res[1] = nums[ele];
                                }else{
                                    res[1] = nums[i];
                                    res[0] = nums[ele];
                                }


                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(res));

    }
}
