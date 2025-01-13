package com.zhang.hot100;

/**
 * ClassName: _226_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/9 1:16
 * @Version 1.0
 */
public class _226_ {
    public static void main(String[] args) {



    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        invertTree(left);
        invertTree(right);

        return root;
    }


}
