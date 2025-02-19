package com.zhang.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _036_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 18:31
 * @Version 1.0
 */
public class _036_ {
    public static void main(String[] args) {


    }

    public List<Integer> inorderTraversal(TreeNode root) {
        p(root);
        return res;
    }

    List<Integer> res = new ArrayList<>();
    void p(TreeNode root){
        if(root == null){
            return;
        }

        p(root.left);
//        System.out.println(root.val);
        res.add(root.val);
        p(root.right);
    }
}
