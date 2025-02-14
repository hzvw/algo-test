package tree;

import common.TreeNode;

public class _28_maximum_binary_tree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return sol(nums,0,nums.length-1);
    }

    TreeNode sol(int[] nums, int i , int j){
        //if(i == j) return new TreeNode(i);
        if(i > j) return null;
        int max_i = i;
        for(int k =i; k<=j; k++){
            if(nums[k] > nums[max_i]) max_i = k;
        }
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = sol(nums,i,max_i-1);
        root.right = sol(nums,max_i+1,j);
        return root;
    }

}
