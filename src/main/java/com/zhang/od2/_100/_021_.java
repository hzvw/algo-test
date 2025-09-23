package com.zhang.od2._100;

import java.util.Map;
import java.util.Scanner;

/**
 * ClassName: _021_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/31 15:51
 * @Version 1.0
 */
public class _021_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 1; i < n; i++) {
            insert(root, arr[i]);
        }
        System.out.println(depth(root));

    }

    static void insert(TreeNode root, int new_val){
        if(root == null){
            return;
        }

        if(new_val < root.value - 500){
            if(root.left == null){
                TreeNode cur = new TreeNode(new_val);
                root.left = cur;
            }else{
                insert(root.left, new_val);
            }
        }else if(new_val > root.value + 500){
            if(root.right == null){
                TreeNode cur = new TreeNode(new_val);
                root.right = cur;
            }else{
                insert(root.right, new_val);
            }
        }else{
            if(root.mid == null){
                TreeNode cur = new TreeNode(new_val);
                root.mid = cur;
            }else{
                insert(root.mid, new_val);
            }

        }

    }

    static int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + Math.max(depth(root.left), Math.max(depth(root.right), depth(root.mid)));
    }


    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode mid;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
