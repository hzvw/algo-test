package tree;

import common.TreeNode;

/**
 *
 * 给定一棵二叉树，判断琪是否是自身的镜像（即：是否对称）
 *
 */
public class _16_symmetric_tree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetrical(root.left, root.right);
    }

    boolean isSymmetrical(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null && root2 != null){
            return false;
        }else if(root1 != null && root2 == null){
            return false;
        }else{
            if(root1.val != root2.val){
                return false;
            }else{
                return isSymmetrical(root1.left, root2.right)
                        && isSymmetrical(root1.right, root2.left);
            }
        }
    }
}
