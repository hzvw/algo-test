package tree;

import common.TreeLinkNode;

import java.util.*;

/**
 *
 *
 * 继续思考"Populating Next Right Pointers in Each Node".这道题
 * 如果给定的树可以是任意的二叉树呢?你之前的给出的算法还有效吗?
 */
public class _07_populating_next_right_pointers_in_each_node_ii {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        List<TreeLinkNode> tmp = new ArrayList<TreeLinkNode>();
        queue.offer(root);
        // 当前行在队列中剩余的元素个数
        int x = 1;

        // 下一行在队列中的个数
        int y = 0;

        while(queue.size() > 0){
            TreeLinkNode node = queue.poll();
            tmp.add(node);
            x--;

            if(node.left != null){
                queue.offer(node.left);
                y++;
            }
            if(node.right != null){
                queue.offer(node.right);
                y++;
            }

            if(x == 0){
                for(int i = 0; i<tmp.size()-1; i++){
                    TreeLinkNode treeLinkNode = tmp.get(i);
                    TreeLinkNode next = tmp.get(i+1);
                    treeLinkNode.next = next;
                }
                tmp.clear();

                x = y;
                y = 0;
            }
        }
    }

}
