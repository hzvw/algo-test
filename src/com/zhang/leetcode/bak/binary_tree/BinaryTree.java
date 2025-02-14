package binary_tree;

import common.TreeNode;
import java.util.*;

public class BinaryTree {

    /*两种先序遍历算法，花里胡哨的，一种对应于回溯，一种对应于动规*/
    List<Integer> res = new LinkedList<Integer>();

    List<Integer> pre_order(TreeNode root){
        traverse(root);
        return res;
    }

    void traverse(TreeNode root){
        if(root == null) return;
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    List<Integer> pre_order2(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        res.add(root.val);
        res.addAll(pre_order2(root.left));
        res.addAll(pre_order2(root.right));
        return res;
    }



}
