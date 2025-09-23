package com.zhang.od;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TaskAssignment {
    public static int minCompletionTime(int[] workloads, int developers) {
        // 将任务按降序排列（贪心策略）
        Arrays.sort(workloads);
        int n = workloads.length;
        
        // 使用最小堆来分配任务，存储开发人员的工作量
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // 初始化开发人员工作量为0
        for (int i = 0; i < developers; i++) {
            minHeap.add(0);
        }
        
        // 从最大任务到最小任务进行分配
        for (int i = n - 1; i >= 0; i--) {
            int currentWorkload = workloads[i];
            
            // 取出当前工作量最小的开发人员
            int minWork = minHeap.poll();
            
            // 分配任务后更新工作量
            minHeap.add(minWork + currentWorkload);
        }
        
        // 最终结果是开发人员中的最大工作量
        int maxTime = 0;
        while (!minHeap.isEmpty()) {
            maxTime = Math.max(maxTime, minHeap.poll());
        }
        
        return maxTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 读取任务工作量
        String[] input = scanner.nextLine().split(" ");
        int[] workloads = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        
        // 读取开发人员数量
        int developers = scanner.nextInt();
        
        // 计算最短完成时间
        int result = minCompletionTime(workloads, developers);
        System.out.println(result);
        
        scanner.close();
    }
}
