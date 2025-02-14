package tree;


import common.TreeNode;

/**
 * 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 */
public class _01_minimum_depth_of_binary_tree {

    int run(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left != null && root.right == null){
            return 1 + run(root.left);
        }else if(root.left == null && root.right != null){
            return 1 + run(root.right);
        }else {
            return 1 + Math.min(run(root.left), run(root.right));
        }
    }


}
