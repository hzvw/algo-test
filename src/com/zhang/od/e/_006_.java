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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int N = Integer.parseInt(sc.nextLine());

        int[] buckets = new int[N];
        List<Integer> arrayList = new ArrayList<>();
        for(int element : arr){
            arrayList.add(element);
        }
        arrayList.sort((a,b) -> b-a);

        List<Integer> res = new ArrayList<>();
        int attack = greedy(arr, N);
        res.add(attack);
        backtrack2(arrayList, 0, buckets, res, attack);
        int min = res.stream().min((a,b) -> a-b).get();
        System.out.println(min);
    }

    static void backtrack2(List<Integer> taskList, int i, int[] buckets, List<Integer> res, int attack){
        for(int j = 0; j<buckets.length; j++){
            if(buckets[j] >= attack){
                return;
            }
        }
        if(i == taskList.size()){
            res.add(Arrays.stream(buckets).max().getAsInt());
            return;
        }
        for(int id = 0; id<buckets.length; id++){
            if(id >0 && buckets[id-1] == buckets[id]){
                continue;
            }
            buckets[id] += taskList.get(i);

            backtrack2(taskList, i+1, buckets, res, attack);
            buckets[id] -= taskList.get(i);
        }
    }

    static int greedy(int[] arr, int N){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i<N; i++){
            queue.offer(0);
        }

        for(int i = arr.length-1; i>=0; i--){
            int cur = arr[i];
            int nm = queue.poll();
            queue.offer(nm + cur);
        }

        int max = 0;
        while(!queue.isEmpty()){
            max = Math.max(max, queue.poll());
        }
        return max;
    }

    static int backtrack(List<Integer> taskList, int buckets[], int i, List<Integer> res, int best_time){
        if(i == taskList.size()){
            return Arrays.stream(buckets).max().getAsInt();
        }

        int min_time = best_time;
        for(int j = 0; j<buckets.length; j++){
            if(j>1 && buckets[j] == buckets[j-1]){
                continue;
            }

            buckets[j] += taskList.get(i);
            int cur_time = Arrays.stream(buckets).max().getAsInt();
            if(cur_time < min_time){
                min_time = backtrack(taskList, buckets, i+1, res, min_time);
            }
            buckets[j] -= taskList.get(i);
        }
        return min_time;
    }


}
