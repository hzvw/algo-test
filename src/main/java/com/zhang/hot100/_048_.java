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

    public int pathSum(TreeNode root, int targetSum){
        if(root == null){
            return 0;
        }
        this.targetSum = targetSum;
        sumFreq.put(0, 1);
        dfs(root, root.val);
        return res;
    }

    int targetSum = 0;

    HashMap<Integer, Integer> sumFreq = new HashMap<>();

    int res = 0;
    void dfs(TreeNode root, int curSum){
        if(sumFreq.containsKey(curSum - targetSum)){
            res += sumFreq.get(curSum - targetSum);
        }
        sumFreq.put(curSum, sumFreq.getOrDefault(curSum, 0) + 1);
        if(root.left != null){
            dfs(root.left, curSum + root.left.val);
        }
        if(root.right != null){
            dfs(root.right, curSum + root.right.val);
        }

        sumFreq.put(curSum, sumFreq.getOrDefault(curSum, 0) -1);
    }

}
