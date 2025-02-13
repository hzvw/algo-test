package other;

import common.TreeNode;
import org.junit.Test;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 *
 */

import java.util.*;

public class _03_convert_bst_to_sorted_linked_list {
    public List<TreeNode> buffer = new ArrayList<TreeNode>();

    public TreeNode Convert(TreeNode root) {
        if(root == null){
            return null;
        }

        in_order(root);
        for(int i = 0; i<buffer.size()-1; i++){
            TreeNode node = buffer.get(i);
            TreeNode next = buffer.get(i+1);
            node.right = next;
        }

        for(int i = 0; i<buffer.size()-1; i++){
            TreeNode next = buffer.get(buffer.size()-i-1);
            TreeNode node = buffer.get(buffer.size()-i-2);

            next.left = node;
        }

        return buffer.get(0);
    }

    public void in_order(TreeNode root){
        if(root == null){
            return;
        }

        in_order(root.left);
        buffer.add(root);
        in_order(root.right);
    }

    @Test
    public void testConvert(){
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(1);

        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;

        _03_convert_bst_to_sorted_linked_list obj = new _03_convert_bst_to_sorted_linked_list();

        TreeNode ret = obj.Convert(node1);

        TreeNode current = ret;
        while(current != null){
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

}
