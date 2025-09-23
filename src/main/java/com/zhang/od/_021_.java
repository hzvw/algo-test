package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _021_
 * Package: com.zhang.od
 * Description:计算三叉搜索树的高度
 *
 * @Author Harizon
 * @Create 2025/1/15 19:07
 * @Version 1.0
 */
public class _021_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i<N; i++) {
            arr[i] = sc.nextInt();
//            root = p(root, arr[i]);
        }
        TreeNode root = new TreeNode(arr[0]);
        for(int i = 1; i<N; i++){
            p(root, arr[i]);
        }
        System.out.println(high(root));
    }

    static int high(TreeNode cur){
        if(cur == null){
            return 0;
        }
        if(cur.l == null && cur.m == null && cur.r == null){
            return 1;
        }else{
            return 1 + Math.max(high(cur.m), Math.max(high(cur.l), high(cur.r)));
        }
    }

    static TreeNode p(TreeNode cur, int val){
        if(cur == null){
            return new TreeNode(val);
        }

        TreeNode l = cur.l;
        TreeNode m = cur.m;
        TreeNode r = cur.r;
        //是叶子节点
        if(val < cur.val - 500){
            if(cur.l == null){
                cur.l = new TreeNode(val);
                return cur.l;
            }else{
                return p(cur.l, val);
            }
        }else if(val > cur.val + 500){
            if(cur.r == null){
                cur.r = new TreeNode(val);
                return cur.r;
            }else{
                return p(cur.r, val);
            }
        }else{
            if(cur.m == null){
                cur.m = new TreeNode(val);
                return cur.m;
            }else{
                return p(cur.m, val);
            }
        }
    }

    static class TreeNode{
        int val;
        TreeNode l;
        TreeNode m;
        TreeNode r;

        public TreeNode(int val){
            this.val = val;
        }
    }


}
