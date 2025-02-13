package tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _23_diameter_of_binary_tree {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode r) {
        depth(r);
        return max;
    }

    int depth(TreeNode r){
        if(r == null){
            return 0;
        }

        int le = depth(r.left);
        int ri = depth(r.right);

        max = Math.max(le+ri, max);
        return 1 + Math.max(le,ri);
    }
}
