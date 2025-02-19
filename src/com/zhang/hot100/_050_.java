package com.zhang.hot100;

/**
 * ClassName: _050_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 1:16
 * @Version 1.0
 */
public class _050_ {

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int left_max = Math.max(dfs(root.left), 0);
        int right_max = Math.max(dfs(root.right), 0);

        int cur_max = left_max + right_max + root.val;
        ans = Math.max(ans, cur_max);
        return Math.max(left_max, right_max) + root.val;
    }
}
