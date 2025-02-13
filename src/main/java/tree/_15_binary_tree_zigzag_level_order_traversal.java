package tree;

/**
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（从左向右，下一层从右向左，一直这样交替）
 */

import common.TreeNode;

import java.util.*;
public class _15_binary_tree_zigzag_level_order_traversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int x = 1;
        int y = 0;
        int flag = 1;

        ArrayList<Integer> buffer = new ArrayList<Integer>();
        while(queue.size() > 0){
            TreeNode node = queue.poll();
            buffer.add(node.val);
            x--;

            if(node.left != null){
                queue.offer(node.left);
                y++;
            }
            if(node.right != null){
                queue.offer(node.right);
                y++;
            }
            if(x == 0){
                x = y;
                y = 0;
                if(flag == -1){
                    Collections.reverse(buffer);
                }
                ret.add(buffer);
                buffer = new ArrayList<Integer>();
                flag = flag * (-1);
            }
        }
        return ret;
    }

}
