package com.zhang.od.e;

import java.util.*;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _057_2_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/13 16:47
 * @Version 1.0
 */
public class _057_2_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        str = str.replaceAll("\\[|\\]", "");

        int[] arr = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
        int n = arr.length /2;
        List<P> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new P(arr[i*2], arr[i*2+1]));
        }
        list.sort((a,b) -> a.x != b.x ? a.x - b.x : b.y - a.y);
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i).y;
        }
        int ans = lengthLIS(nums);

        System.out.println(ans);
    }

    static int lengthLIS(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int n = nums.length;
        dp[0] = 1;
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    static class P{
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
