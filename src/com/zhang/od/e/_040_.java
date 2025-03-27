package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _040_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/30 21:22
 * @Version 1.0
 */
public class _040_ {

    static int N;
    static int M;
    static int K;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                arr[i][j] = sc.nextInt();
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }

        int left = min;
        int right = max;
        int res = 0;
        while(left <= right){
            int mid = left + (right - left ) / 2;
            boolean isFound = check(mid);
            if(isFound){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(res);
    }

    static boolean check(int mid){
        int[] match = new int[M];
        Arrays.fill(match, -1);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean isFound = dfs(i, mid, new boolean[M], match);
            if(isFound){
                cnt++;
            }
        }
        return cnt >= N-K+1;
    }

    static boolean dfs(int i, int kth, boolean[] visited, int[] match){
        for (int j = 0; j < M; j++) {
            if(arr[i][j] <= kth && !visited[j]){
                visited[j] = true;

                if(match[j] == -1 || dfs(match[j],kth, visited, match)){
                    match[j] = i;
                    return true;
                }
            }
        }
        return false;
    }





    static int binary(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    static void p(int[] nums, int n, int level, LinkedList<Integer> buckets, List<List<Integer>> res, boolean[] visited){
        if(buckets.size() == n){
            res.add(new ArrayList<>(buckets));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(visited[i]){
                continue;
            }

            buckets.addLast(nums[i]);
            visited[i] = true;

            p(nums, n, level + 1, buckets, res, visited);
            buckets.removeLast();
            visited[i] = false;
        }

    }




}
