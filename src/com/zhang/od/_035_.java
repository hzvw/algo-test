package com.zhang.od;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * ClassName: _035_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/17 14:48
 * @Version 1.0
 */
public class _035_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<TreeNode> pq = new PriorityQueue<>((x,y)->x.val != y.val ? x.val-y.val : x.h - y.h);
        for(int i = 0; i<N; i++){
            pq.add(new TreeNode(sc.nextInt(), 0, null, null));
        }

        while(pq.size() > 1){
            TreeNode l = pq.poll();
            TreeNode r = pq.poll();

            TreeNode t = new TreeNode(l.val + r.val, 1+Math.max(l.h, r.h), l, r);

            pq.offer(t);
        }

        p(pq.poll());
    }

    static void p(TreeNode root){
        if(root == null){
            return;
        }

        p(root.l);
        System.out.print(root.val + " ");
        p(root.r);
    }

    static class TreeNode{
        int val;
        int h;
        TreeNode l;
        TreeNode r;

        public TreeNode(int val, int h, TreeNode l, TreeNode r){
            this.val = val;
            this.h = h;
            this.l = l;
            this.r = r;
        }
    }

}
