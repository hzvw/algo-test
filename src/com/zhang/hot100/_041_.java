package com.zhang.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: _041_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 19:04
 * @Version 1.0
 */
public class _041_ {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            LinkedList<TreeNode> n_queue = new LinkedList<>();

            List<Integer> list = new ArrayList<>();
            for (TreeNode node : queue) {
                list.add(node.val);

                if(node.left != null){
                    n_queue.offer(node.left);
                }
                if(node.right != null){
                    n_queue.offer(node.right);
                }
            }
            res.add(list);
            queue = n_queue;
        }

        return res;
    }

}
