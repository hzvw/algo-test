package tree;


import common.TreeLinkNode;
import common.TreeNode;

import java.util.*;


public class TreeAlgo {

    // 判断一棵二叉树是否平衡
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }else{
            //return depth(root.left) - depth(root.right) ;
        }
        return false;
    }

    // 计算一棵二叉树的最大高度
    int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left != null && root.right == null){
            return 1 + depth(root.left);
        }else if(root.left == null && root.right != null){
            return 1 + depth(root.right);
        }else{
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
    }


}
