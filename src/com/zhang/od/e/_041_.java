package com.zhang.od.e;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _041_ {
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


}
