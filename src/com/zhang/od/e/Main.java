package com.zhang.od.e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int d = sc.nextInt();
 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
 
        System.out.println(solution(n, d, arr));
    }
 
    public static int solution(int n, int d, int[] arr) {
        // 实力数组升序
        Arrays.sort(arr);
 
        // segments用于记录所有分段
        ArrayList<ArrayList<Integer>> segments = new ArrayList<>();
 
        // segment用于记录某个分段
        ArrayList<Integer> segment = new ArrayList<>();
 
        for (int i = 1; i < n; i++) {
            // 相邻两队的实力差diff
            int diff = arr[i] - arr[i - 1];
 
            if (diff <= d) {
                segment.add(diff);
            } else if (!segment.isEmpty()) { // 如果diff > d，则当前分段截止, 如果当前分段不为空，则加入segments
                segments.add(segment);
                segment = new ArrayList<>();
            }
        }
 
        // 收尾
        if (!segment.isEmpty()) {
            segments.add(segment);
        }
 
        if (segments.isEmpty()) {
            // 若没有队伍可以匹配，则输出-1。
            return -1;
        } else {
            // 若有队伍可以匹配，则输出匹配队伍最多的情况下匹配出的各组实力差距的最小总和
            return segments.stream().map(x -> p(x, 0, x.size() % 2 == 0, 0)).reduce(Integer::sum).get();
        }
    }
 
    /**
     * 相邻元素不能选，且要实现最多选择的情况下，所有选中元素的最小和
     *
     * @param list       元素集合
     * @param index      当前可选位置
     * @param canAbandon 是否还有两跳的机会
     * @param sum        所有选中元素的和
     * @return 相邻元素不能选，且要实现最多选择的情况下，所有选中元素的最小和
     */
    public static int p(ArrayList<Integer> list, int index, boolean canAbandon, int sum) {
        if (index >= list.size()) {
            return sum;
        }
 
        // 记录最小和
        int minSum = Integer.MAX_VALUE;
 
        // 一跳
        // 选择index位置元素后，跳过index+1位置，下次从index+2位置开始选
        minSum = Math.min(minSum, p(list, index + 2, canAbandon, sum + list.get(index)));
 
        // 两跳
        // index位置是可选的，而index位置可选的前提是index-1必未被选择，因此index不选的话，
        // 那么就形成了两跳，即跳过了index-1，index两个位置，下次可以从index+1开始选
        if (canAbandon) { // 两跳的机会只有一次
            minSum = Math.min(minSum, p(list, index + 1, false, sum));
        }
 
        return minSum;
    }
}