package common;

import java.util.*;

public class TreeNode {
    public int val;

    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static ArrayList<ArrayList<Integer>> printTree(TreeNode root){
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

        //Collections.reverse(ret);
        return ret;

    }

}
