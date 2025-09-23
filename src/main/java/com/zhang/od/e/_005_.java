package com.zhang.od.e;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _005_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/26 22:49
 * @Version 1.0
 */
public class _005_ {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        MyQueue myQueue = new MyQueue();
        int len = k+1;

        int[] dp = new int[n];
        dp[0] = nums[0];
        myQueue.add(dp[0]);

        for(int i = 1; i < len && i< n; i++){
            dp[i] = myQueue.getFirst() + nums[i];
            myQueue.add(dp[i]);
        }

        for(int i = len; i<n; i++){
            if(dp[i-len] == myQueue.getFirst()){
                myQueue.removeFirst();
            }

            dp[i] = myQueue.getFirst() + nums[i];
            myQueue.add(dp[i]);
        }

        System.out.println(dp[n-1]);
    }

    static class MyQueue{
        LinkedList<Integer> buffer = new LinkedList<>();

        public void add(int x){
            while(!buffer.isEmpty() && x > buffer.getLast()){
                buffer.removeLast();
            }
            buffer.addLast(x);
        }

        public int getFirst(){
            return buffer.getFirst();
        }

        public void removeFirst(){
            buffer.removeFirst();
        }


    }


}
