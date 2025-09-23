package com.zhang.hot100;

import java.util.*;

/**
 * ClassName: _239_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/26 19:22
 * @Version 1.0
 */
public class _239_ {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int[] res = new _239_().maxSlidingWindow(nums, k);
        Arrays.stream(res).forEach(System.out::println);
    }

    static void my_put(int i, int num, TreeMap<Integer, Set<Integer>> tree){
        Set<Integer> set = tree.get(num);
        if(set != null){
            set.add(i);
        }else{
            set = new HashSet<>();
            set.add(i);
            tree.put(num, set);
        }
    }

    static void my_remove(int i, int num, TreeMap<Integer, Set<Integer>> tree){
        Set<Integer> set = tree.get(num);
        if(set.size() == 1){
            tree.remove(num);
        }else{
            set.remove(i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Set<Integer>> tree = new TreeMap<>((a, b) -> b-a);

        LinkedList<int[]> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(nums.length < k){
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        }else{
            for(int i = 0; i<k; i++){
                queue.addFirst(new int[]{nums[i], i});
                my_put(i, nums[i], tree);
            }
            int max = tree.firstKey();
            res.add(max);

            int j = k;
            while(j<nums.length){
                int in = nums[j];// in
                int[] out = queue.removeLast();//out
                int b = out[0];
                int out_i = out[1];
                queue.addFirst(new int[]{in, j});

                my_put(j, in,tree);
                my_remove(out_i, b, tree);
                max = tree.firstKey();
                res.add(max);
                j++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Node{
        int value;
        Set<Integer> ids = new HashSet<>();
    }

    static class MyQueue{
        LinkedList<Integer> buffer = new LinkedList<>();

        public void add(int ele){
            while(!buffer.isEmpty() && buffer.getLast() < ele){
                buffer.removeLast();
            }
            buffer.addLast(ele);
        }

        public int getFirst(){
            return buffer.getFirst();
        }

        public void removeFirst(){
            buffer.removeFirst();
        }
    }

    public int[] maxSlidingWindow2(int[] nums, int k){
        List<Integer> res = new ArrayList<>();
        MyQueue myQueue = new MyQueue();
        for(int i = 0; i<k; i++){
            myQueue.add(nums[i]);
        }
        res.add(myQueue.getFirst());

        int j = k;
        while(j < nums.length){
            int in = nums[j];
            int out = nums[j-k];
            if(out == myQueue.getFirst()){
                myQueue.removeFirst();
            }

            myQueue.add(in);

            res.add(myQueue.getFirst());
            j++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

