package com.zhang.hot100;

/**
 * ClassName: _038_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 18:36
 * @Version 1.0
 */
public class _038_ {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode t = left;
        root.left = right;
        root.right = t;

        return root;
    }
}
