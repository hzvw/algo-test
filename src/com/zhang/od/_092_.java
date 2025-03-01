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
        int m = sc.nextInt();
        List<Integer> buffer = new ArrayList<>();
        for(int i = 0; i<m; i++){
            buffer.add(sc.nextInt());
        }
        buffer.sort((a,b) -> b-a);

        int sum = 0;
        for(int i = 0; i<m; i++){
            sum += buffer.get(i);
        }

        int k = m;//桶的数量
        for(;k >= 1;k--){
            if(sum % k != 0){
                continue;
            }
            int subSum = sum / k;
            if(buffer.get(0) > subSum){
                continue;
            }

            int[] buckets = new int[k];
            if(canPartition(subSum, buffer, 0, buckets)){
                System.out.println(subSum);
                return;
            }
        }
    }

    static boolean canPartition(int sub, List<Integer> nums, int index , int[] buckets){
        if(index == nums.size()){
            return true;
        }
        int selected = nums.get(index);
        for(int i = 0; i<buckets.length; i++){
            if(i > 0 && buckets[i] == buckets[i-1]){
                continue;
            }
            if(buckets[i] + selected <= sub){
                buckets[i] += selected;
                if(canPartition(sub, nums, index+1, buckets)){return true;}
                buckets[i] -= selected;
            }
        }
        return false;
    }




}
