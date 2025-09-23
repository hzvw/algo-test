package com.zhang.od.e;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _041_ {
//    AtomicInteger

    static class R{
        int start;
        int end;

        public R(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "R{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void test01() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        PriorityQueue<R> pq = new PriorityQueue<>((a,b)-> a.end != b.end ? b.end-a.end : b.start - a.start);
        for (int i = 0; i < n; i++) {
            pq.add(new R(sc.nextInt(), sc.nextInt()));
        }

        int last_end = Integer.MAX_VALUE;
        int cnt = 0;
        while(pq.size() > 0){
            R r = pq.poll();

            if(last_end > r.end){
                last_end = r.end;
                cnt++;
            }else if(last_end > r.start){
                r.end = last_end-1;
                pq.add(r);
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }
        //结束时间降序
        Arrays.sort(arr, (a,b)-> b[1]-a[1]);

        //开始时间降序
        PriorityQueue<Integer> start_pq = new PriorityQueue<>((a,b) -> b-a);
        int pq_end = Integer.MAX_VALUE;
        int count = 0;
        for(int[] ints : arr){
            int start = ints[0];
            int end = ints[1];

            while(start_pq.size() > 0 && end < pq_end){
                int start_t = start_pq.poll();
                if(start_t <= pq_end){
                    count++;
                    pq_end--;
                }
            }

            start_pq.add(start);
            pq_end = end;
        }
        while(start_pq.size() > 0){
            int start_t = start_pq.poll();
            if(start_t <= pq_end){
                count++;
                pq_end--;
            }
        }
        System.out.println(count);
    }


    private static int getResult2(int[][] tasks) {
        // 任务按开始时间升序
        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
        // 优先队列存储结束时间，升序
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        int idx = 0, n = tasks.length, ans = 0;

        for (int cur = 1; cur <= 100000 + 5; cur++) {
            // 遍历任务，所有 cur 时间可以开始执行的任务都入队
            // idx 控制任务只会共完整遍历一次
            while (idx < n && tasks[idx][0] <= cur) {
                q.add(tasks[idx][1]);
                idx++;
            }
            // 去除过期任务
            while (!q.isEmpty() && q.peek() < cur) {
                q.poll();
            }
            // cur 时间选择执行队首任务
            if (!q.isEmpty()) {
                ans++;
                q.poll();
            }
        }
        return ans;
    }


}
