package com.zhang.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _046_2_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 22:09
 * @Version 1.0
 */
public class _046_2_ {
    public void flatten(TreeNode root) {
        preorder(root);

        TreeNode n_head = new TreeNode(-1);
        TreeNode pre = n_head;
        for (TreeNode node : list) {
            pre.right = node;
            pre.left = null;
            pre = node;
        }
        return;
    }

    void preorder(TreeNode r){
        if(r == null){
            return;
        }

        list.add(r);
        preorder(r.left);
        preorder(r.right);
    }

    List<TreeNode> list = new ArrayList<>();
}
