package com.zhang.hot100;

import java.util.HashMap;

/**
 * ClassName: _048_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/9 2:32
 * @Version 1.0
 */
public class _048_ {
    public static void main(String[] args) {



    }

    int ans = 0;

    HashMap<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        map.put(0l, 1);
        dfs(root, root.val, targetSum);

        return ans;
    }

    void dfs(TreeNode root, long val, int target){
        if(map.containsKey(val - target)){
            ans += map.get(val - target);
        }

        map.put(val, map.getOrDefault(val, 0)+1);
        if(root.left != null){
            dfs(root.left, val + root.left.val, target);
        }
        if(root.right != null){
            dfs(root.right, val + root.right.val, target);
        }

        map.put(val, map.getOrDefault(val, 0)-1);
    }

}
