package com.zhang.od;

import java.util.*;

/**
 * ClassName: _092_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/22 20:38
 * @Version 1.0
 */
public class _092_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().replaceAll("\\[|\\]", "");
        int[] nums = Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        reverse(nums);

        int sum = Arrays.stream(nums).sum();
        int k = nums.length;
        for (;k>=1; k--){
            if(sum % k != 0){
                continue;
            }
            int sub = sum / k;
            if(nums[0] > sub){
                continue;
            }

            boolean can = can(0, nums, new int[k], k, sub);
            if(can){
                System.out.println(k);
                return;
            }
        }
    }

    static boolean can(int index, int[] nums, int[] buckets, int k, int sub){
        if(index == nums.length){
            return true;
        }
        int selected = nums[index];
        for (int i = 0; i < k; i++) {
            if(i-1>= 0 && buckets[i] == buckets[i-1]){
                continue;
            }

            if(selected + buckets[i] <= sub){
                buckets[i] += selected;

                if(can(index+1, nums, buckets, k, sub)){
                    return true;
                }

                buckets[i] -= selected;
            }

        }

        return false;
    }

    static void reverse(int[] nums){
        int i = 0;
        int j = nums.length - 1;
        while (i< j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    static void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}
