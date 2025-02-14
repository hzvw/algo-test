package tree;

import common.TreeNode;

import java.util.*;
/**
 *
 * 二叉搜索树（BST）中的两个节点被错误地交换了，
 * 请在不改变树的结构的情况下恢复这棵树。
 * 用O(n)的空间解决这个问题的方法太暴力了，你能设计一个常数级空间复杂度的算法么？
 *
 */
public class _18_recover_binary_search_tree {
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        //TreeNode node1 = null;
        //TreeNode node2 = null;
        //boolean flag = false;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.size() > 0){
            TreeNode node = queue.poll();

            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }

    }

    private List<TreeNode> buffer = new ArrayList<TreeNode>();

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        buffer.add(root);
        inorder(root.right);
    }

}
