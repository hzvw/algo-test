package com.zhang.hot100;

/**
 * ClassName: _043_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 19:26
 * @Version 1.0
 */
public class _043_ {

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

//        System.out.println(new _043_().isValidBST(node1));

    }


    // 错误写法
//    public boolean isValidBST(TreeNode root) {
//        if(root == null){
//            return  true;
//        }
//        if(root.left != null && root.left.val >= root.val){
//            return false;
//        }
//        if(root.right != null && root.right.val <= root.val){
//            return false;
//        }
//        return isValidBST(root.left) && isValidBST(root.right);
//    }


    public boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null){
            return  true;
        }
        return root.val > min && root.val < max
                && isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
