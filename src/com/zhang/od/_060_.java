package com.zhang.od;

import java.util.*;

/**
 * ClassName: _060_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/1 0:56
 * @Version 1.0
 */
public class _060_ {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = Arrays.stream(arr).sum();
        dfs(0);
        int minDiff = Integer.MAX_VALUE;
        for (Integer ele : res) {
            minDiff = Math.min(minDiff, Math.abs(sum-ele-ele));
        }
        System.out.println(minDiff);
    }

    static List<Integer> res = new ArrayList<>();
    static LinkedList<Integer> buckets = new LinkedList<>();

    static void dfs(int level){
        if(buckets.size() == 5){
            res.add(buckets.stream().reduce(0, Integer::sum));
            return;
        }

        for (int i = level; i < 10; i++) {
            buckets.addLast(arr[i]);
            dfs(i+1);
            buckets.removeLast();
        }
    }

}
