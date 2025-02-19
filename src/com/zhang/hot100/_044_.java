package com.zhang.hot100;

/**
 * ClassName: _044_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 21:53
 * @Version 1.0
 */
public class _044_ {

    int res = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        in_order(root, k);
        return res;
    }

    void in_order(TreeNode r, int k){
        if(r == null){
            return;
        }

        in_order(r.left, k);
        if(++count == k){
            res = r.val;
            return;
        }

        in_order(r.right, k);
    }
}
