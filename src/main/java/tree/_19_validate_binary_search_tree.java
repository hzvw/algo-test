package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断给出的二叉树是否是一个二叉搜索树（BST）
 * 二叉搜索树的定义如下
 * 一个节点的左子树上节点的值都小于自身的节点值
 * 一个节点的右子树上节点的值都小于自身的节点值
 * 所有节点的左右子树都必须是二叉搜索树
 *
 */
public class _19_validate_binary_search_tree {

    List<Integer> buffer = new ArrayList<Integer>();

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        inorder(root);
        for(int i = 0; i<buffer.size()-1; i++){
            if(buffer.get(i) >= buffer.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        buffer.add(root.val);
        inorder(root.right);
    }

}
