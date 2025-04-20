package com.zhang.leetcode.bak;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: _662_
 * Package: com.zhang.leetcode.bak
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/20 17:06
 * @Version 1.0
 */
public class _662_ {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int res = 0;
        LinkedList<MyNode> queue = new LinkedList<>();
        queue.offer(new MyNode(root, 1));
        while (!queue.isEmpty()){
            res = Math.max(res, queue.getLast().index - queue.getFirst().index + 1);
            LinkedList<MyNode> n_queue = new LinkedList<>();

            for (MyNode myNode : queue) {
                int index = myNode.index;
                TreeNode node = myNode.node;

                if(node.left != null){
                    n_queue.offer(new MyNode(node.left, index * 2));
                }
                if(node.right != null){
                    n_queue.offer(new MyNode(node.right, index * 2 + 1));
                }
            }

            queue = n_queue;
        }


        return res;
    }

    static class MyNode{
        TreeNode node;
        int index;

        public MyNode(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}




