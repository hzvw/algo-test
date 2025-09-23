package com.zhang.leetcode.bak.tree;

import com.zhang.leetcode.bak.common.TreeNode;
import java.util.*;

public class _27_flatten_binary_tree_to_linked_list {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = right;
    }



}
