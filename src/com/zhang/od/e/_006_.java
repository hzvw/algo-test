package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _006_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/25 8:12
 * @Version 1.0
 */
public class _006_ {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // nums.length个球，球的大小是nus[i]
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        reverse(nums);
        // n个桶
        n = Integer.parseInt(sc.nextLine());

        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();

        int res = right;
        while (left <= right){
            int mid = (left+right)/2;

            if(check(0, mid, nums, new int[n])){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }

        }
        System.out.println(res);

    }

    static void reverse(int[] nums){
        int i = 0;
        int j = nums.length-1;
        while (i < j){
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

    static boolean check(int level, int mid, int[] nums, int[] buckets){
        if(level == nums.length){
            return true;
        }
        for (int i = 0; i < n; i++) {
            if(i > 0 && buckets[i] == buckets[i-1]){
                continue;
            }

            if(buckets[i] + nums[level] <= mid){
                buckets[i] += nums[level];

                if(check(level+1, mid, nums, buckets)){
                    return true;
                }

                buckets[i] -= nums[level];
            }

        }
        return false;
    }


}
