package tree;

import common.TreeNode;
import org.junit.Test;

import java.util.*;


/**
 *
 * 给出一棵树的前序遍历和中序遍历，请构造这颗二叉树
 */
public class _14_construct_binary_tree_from_preorder_and_inorder_traversal {
    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length-1, 0,inorder.length-1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int i1, int j1, int i2, int j2){
        if(i1 > j1) return null;
        TreeNode root = new TreeNode(preorder[i1]);
        int mid = map.get(root.val);
        int leftLength = mid - i2;
        int rightLength = j2-mid;
        TreeNode left = build(preorder, inorder, i1+1, i1+leftLength, i2, i2+leftLength-1);
        TreeNode right = build(preorder, inorder, j1-rightLength+1, j1, j2-rightLength+1, j2);
        root.left = left;
        root.right = right;
        return root;
    }

}
