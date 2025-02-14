package tree;

import common.TreeNode;

public class _17_same_tree {

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
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
                return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
            }

        }
    }

}
