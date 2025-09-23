package com.zhang.hot100;

/**
 * ClassName: _042_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 19:13
 * @Version 1.0
 */
public class _042_ {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return p(nums, 0, nums.length-1);
    }

    TreeNode p(int[] nums, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = p(nums, start, mid-1);;
        root.right = p(nums, mid+1, end);;
        return root;
    }


}
