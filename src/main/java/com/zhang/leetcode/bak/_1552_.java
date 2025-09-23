package com.zhang.leetcode.bak;

import java.util.Arrays;

/**
 * ClassName: _1552_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/5/7 11:13
 * @Version 1.0
 */
// 两球之间的磁力
public class _1552_ {
    public int maxDistance(int[] position, int m) {
         Arrays.sort(position);
         int n = position.length;

         int res = 0;
         int left = 1;
         int right = position[n-1] - position[0];
         while (left <= right){
             int mid = (left + right) / 2;
             if(check(mid, position, m)){
                 res = mid;
                 left = mid+1;
             }else{
                 right = mid-1;
             }
         }
        return res;
    }

    static boolean check(int mid, int[] position, int m){
        int count = 1;
        int last = position[0];
        for (int i = 1; i < position.length;) {
            int curLocation = position[i];
            if(curLocation - last >= mid){
                count++;
                last = curLocation;
            }else{
                i++;
            }
        }
        return count >= m;
    }

}
