package com.zhang.hot100;

/**
 * ClassName: _037_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 18:34
 * @Version 1.0
 */
public class _037_ {
    public static void main(String[] args) {


    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
