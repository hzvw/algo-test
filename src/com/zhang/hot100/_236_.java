package com.zhang.hot100;

/**
 * ClassName: _236_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/8 23:45
 * @Version 1.0
 */
public class _236_ {
    public static void main(String[] args) {




    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left == null){
            return right;
        }

        if(right == null ){
            return left;
        }
        return root;
    }


}
//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }
