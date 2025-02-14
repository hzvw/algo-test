package tree;

import common.TreeNode;

public class _25_invert_binary_tree {

    public TreeNode invertTree(TreeNode r) {
        if(r == null){
            return null;
        }

        TreeNode t = r.left;
        r.left = r.right;
        r.right = t;

        invertTree(r.left);
        invertTree(r.right);
        return r;
    }
}
