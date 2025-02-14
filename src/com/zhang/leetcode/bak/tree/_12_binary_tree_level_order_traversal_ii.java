package tree;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 给定一个二叉树，返回该二叉树由底层到顶层的层序遍历，（从左向右，从叶子节点到根节点，一层一层的遍历）
 *
 */
public class _12_binary_tree_level_order_traversal_ii {

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        // 记录当前行有多少还在队列中
        int x = 1;

        // 记录下一行有多少在队列中
        int y = 0;

        ArrayList<Integer> buffer = new ArrayList<Integer>();
        while(queue.size() > 0){
            TreeNode node = queue.poll();
            x--;
            buffer.add(node.val);

            if(node.left != null){
                queue.offer(node.left);
                y++;
            }
            if(node.right != null){
                queue.offer(node.right);
                y++;
            }
            if(x == 0){
                x = y;
                y = 0;
                ret.add(buffer);
                buffer = new ArrayList<Integer>();
            }
        }

        Collections.reverse(ret);
        return ret;
    }

    @Test
    public void testLevelOrderBottom(){
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(0);
        TreeNode node11 = new TreeNode(8);
        TreeNode node12 = new TreeNode(8);
        TreeNode node13 = new TreeNode(7);

        //TreeNode node8 = new TreeNode(1);
        // TreeNode node9 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;

        node5.left = node9;
        node5.right = node10;

        node7.left = node11;
        node7.right = node12;

        node10.left = node13;

        ArrayList<ArrayList<Integer>> ret = new _12_binary_tree_level_order_traversal_ii()
                .levelOrderBottom(node1);

        System.out.println(Arrays.toString(ret.toArray()));
    }
}
