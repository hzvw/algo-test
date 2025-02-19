package com.zhang.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _045_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 21:59
 * @Version 1.0
 */
public class _045_ {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<TreeNode> n_queue = new LinkedList<>();

            for (TreeNode node : queue) {
                if(node.left != null){
                    n_queue.add(node.left);
                }
                if(node.right != null){
                    n_queue.add(node.right);
                }
            }
            res.add(queue.getLast().val);
            queue = n_queue;
        }
        return res;
    }
}
