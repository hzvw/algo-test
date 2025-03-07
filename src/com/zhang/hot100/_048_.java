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

    HashMap<Long, Integer> sumFreq = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        sumFreq.put(0l, 1);
        int curSum = root.val;
        dfs(root, curSum, targetSum);

        return ans;
    }

    void dfs(TreeNode root, long curSum, int target){
        if(sumFreq.containsKey(curSum - target)){
            ans += sumFreq.get(curSum - target);
        }

        sumFreq.put(curSum, sumFreq.getOrDefault(curSum, 0)+1);
        if(root.left != null){
            dfs(root.left, curSum + root.left.val, target);
        }
        if(root.right != null){
            dfs(root.right, curSum + root.right.val, target);
        }

        sumFreq.put(curSum, sumFreq.getOrDefault(curSum, 0)-1);
    }

}
