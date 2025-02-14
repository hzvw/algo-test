package tree;

import common.TreeNode;

public class _24_maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode r) {
        if(r == null){
            return 0;
        }

        int le = maxDepth(r.left);
        int ri = maxDepth(r.right);

        return Math.max(le, ri) + 1;
    }

}
