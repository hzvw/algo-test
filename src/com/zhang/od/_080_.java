package com.zhang.od;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _080_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/21 17:26
 * @Version 1.0
 */
public class _080_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeNode root = new TreeNode(arr[0]);
        p(arr, root);

        LinkedList<TreeNode> queue = new LinkedList<>();
        int max = root.val;
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode fa = queue.removeFirst();
            max = Math.max(max, fa.val);

            TreeNode l = fa.l;
            TreeNode r = fa.r;

            if(l != null){
                l.val = fa.val + l.val;
                queue.addLast(l);
            }
            if(r != null){
                r.val = fa.val + r.val;
                queue.addLast(r);
            }

        }
        System.out.println(max);


    }

    static TreeNode p(int[] arr, TreeNode root){
        if(root == null){
            return null;
        }

        int index = root.index;
        int l_i = index * 2 +1;
        int r_i = index * 2 +2;

        if(l_i < arr.length && arr[l_i] != -1){
            TreeNode t = new TreeNode(arr[l_i]);
            t.index = l_i;
            root.l = t;
        }

        if(r_i < arr.length && arr[r_i] != -1){
            TreeNode t = new TreeNode(arr[r_i]);
            t.index = r_i;
            root.r = t;
        }

        p(arr, root.l);
        p(arr, root.r);
        return root;
    }

    static class TreeNode{
        int index;
        int val;
        TreeNode l;
        TreeNode r;

        public TreeNode(int val){
            this.val = val;
        }
    }

}
