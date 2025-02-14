package tree;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 判断给定的二叉树是否是平衡的
 * 在这个问题中，定义平衡二叉树为每个节点的左右两个子树高度差的绝对值不超过1的二叉树
 *
 *
 */
public class _11_balanced_binary_tree {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int le = depth(root.left);
        int ri = depth(root.right);
        if(le - ri < -1 || le - ri > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int le = depth(root.left);
        int ri = depth(root.right);

        return 1 + Math.max(le, ri);
    }
}
