package tree;
import common.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 *
 * 给定一个仅包含数字0-9的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
 * 例如根节点到叶子节点的一条路径是1->2->3,那么这条路径就用123来代替。
 * 找出根节点到叶子节点的所有路径表示的数字之和
 *
 *
 */
public class _04_sum_root_to_leaf_numbers {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> buffer = new ArrayList<Integer>();

    boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null){
            return true;
        }else{
            return false;
        }
    }

    public int sumNumbers(TreeNode root) {
        if(root == null /*|| root.val == 0*/){
            return 0;
        }
        inOrder(buffer, root);
        int sum = 0;
        for(List<Integer> buff : ret){
            int ele = 0;
            for(int i = 0; i<buff.size(); i++){
                int x = buff.get(i);
                int y = buff.size() - 1 - i;
                ele += x * Math.pow(10, y);
            }

            //System.out.println("ele = " + ele);
            sum += ele;
        }
        return sum;
    }

    void inOrder(List<Integer> buffer, TreeNode root){
        if(root == null){
            return;
        }
        buffer.add(root.val);
        if(isLeaf(root)){
            ret.add(new ArrayList<Integer>(buffer));
        }
        inOrder(buffer, root.left);
        inOrder(buffer, root.right);
        buffer.remove(buffer.size() - 1);
    }


    List<TreeNode> buffer2 = new ArrayList<TreeNode>();
    List<List<TreeNode>> ret2 = new ArrayList<List<TreeNode>>();
    void solution(TreeNode root, TreeNode current){
        if(root == null){
            ret2.add(new ArrayList<TreeNode>(buffer2));
        }

        buffer2.add(root);
        if(root == current){

            System.out.println(root.val + " " + buffer2.size());
            ret2.add(new ArrayList<TreeNode>(buffer2));
        }
        if(root.left != null){
            solution(root.left, current);
        }
        if(root.right != null){
            solution(root.right, current);
        }
        buffer2.remove(buffer2.size()-1);
    }

    /**
     *
     * 查询一棵二叉树上任意两个节点的路径重合部分
     *
     *
     *
     * @param root
     * @param a
     * @param b
     * @return
     */
    List<TreeNode> findParents(TreeNode root,TreeNode a,TreeNode b){
        solution(root, a);
        solution(root, b);

        for(TreeNode node : ret2.get(0)){
            System.out.print(node.val + " ");
        }
        System.out.println();

        for(TreeNode node : ret2.get(1)){
            System.out.print(node.val + " ");
        }

        //System.out.println(list1.size() + " " + list2.size());
        return null;
    }

    @Test
    public void testFindParents() {
        _04_sum_root_to_leaf_numbers obj = new _04_sum_root_to_leaf_numbers();


        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        findParents(node1, node4, node5);
    }

}
