package tree;

import common.TreeNode;

import java.util.*;

/**
 * 求给定的二叉树的后序遍历。迭代解法
 *
 *
 *
 *
 *
 */
public class _02_binary_tree_postorder_traversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root == null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            ret.add(node.val);

            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }

        Collections.reverse(ret);
        return ret;
    }



}
