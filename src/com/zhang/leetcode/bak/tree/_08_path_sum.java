package tree;

import common.TreeNode;

/**
 * 给定一个二叉树和一个值sum，判断是否有从根节点到叶子节点的节点值之和等于sum的路径，
 *
 *
 */
public class _08_path_sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == sum;
        }else if(root.left == null && root.right != null){
            sum -= root.val;
            return hasPathSum(root.right, sum);
        }else if(root.left != null && root.right == null){
            sum -= root.val;
            return hasPathSum(root.left, sum);
        }else {
            sum -= root.val;
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
    }

}
