package tree;

import common.TreeNode;

import java.util.*;
/**
 * 二叉树的先序遍历,迭代算法
 *
 *
 *
 *
 */
public class _03_binary_tree_preorder_traversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return ret;
        }

        stack.push(root);
        while(!stack.empty()){
            TreeNode n = stack.pop();
            ret.add(n.val);
            // 先放右子树再放左子树
            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }
        }
        return ret;
    }

}
