package com.zhang.hot100;

/**
 * ClassName: TreeNode
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/9 1:17
 * @Version 1.0
 */
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

}
