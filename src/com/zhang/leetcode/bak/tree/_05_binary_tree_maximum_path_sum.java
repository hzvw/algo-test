package tree;

import common.TreeNode;

/**
 * 给定一个二叉树，请计算节点值之和最大的路径的节点值之和是多少。
 * 这个路径的开始节点和结束节点可以是二叉树中的任意节点
 *
 *
 */
public class _05_binary_tree_maximum_path_sum {

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftValue = maxPath(root.left);
        int rightValue = maxPath(root.right);

        int current = root.val;
        if(leftValue > 0){
            current += leftValue;
        }
        if(rightValue > 0){
            current += rightValue;
        }
        if(current > maxPathSum){
            maxPathSum = current;
        }
        maxPathSum(root.left);
        maxPathSum(root.right);
        return maxPathSum;
    }

    int maxPath(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int leftValue = maxPath(root.left);
            int rightValue = maxPath(root.right);
            int current = root.val;
            current += Math.max(0, Math.max(leftValue, rightValue));
            if(current > maxPathSum){
                maxPathSum = current;
            }
            return current;
        }
    }
}
