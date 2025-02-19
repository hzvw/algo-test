package com.zhang.hot100;


/**
 * ClassName: _040_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 18:46
 * @Version 1.0
 */
public class _040_ {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    int depth(TreeNode r){
        if(r == null){
            return 0;
        }
        int l_d = depth(r.left);
        int r_d = depth(r.right);

        res = Math.max(res, l_d + r_d);
        return 1 + Math.max(l_d, r_d);
    }

}
