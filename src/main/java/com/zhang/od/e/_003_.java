package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _003_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/26 1:49
 * @Version 1.0
 */
public class _003_ {
    static int[] inOrder = null;//中序
    static int[] preOrder = null;//先序

    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();//存放中序遍历中，元素与位置的关系

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inOrder = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        preOrder = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i< inOrder.length; i++){
            map.putIfAbsent(inOrder[i], new ArrayList<Integer>());
            map.get(inOrder[i]).add(i);
        }
        TreeNode root = build(0, inOrder.length-1, 0, preOrder.length-1);

        p(root);
        res.sort((a,b) ->a.i - b.i);
        for(int i = 0; i<res.size(); i++){
            System.out.print((res.get(i).sum - inOrder[i]) + " ");
        }
    }

    static List<TreeNode> res = new ArrayList<>();

    static int p(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            root.sum = root.val;
            res.add(root);
            return root.sum;
        }
        int left_sum = p(root.left);
        int right_sum = p(root.right);

        root.sum = root.val + left_sum + right_sum;
        res.add(root);
        return root.sum;
    };

    /*
     */
    static TreeNode build(int i1, int j1, int i2, int j2){
        if(i2 > j2 || i1 > j1){
            return null;
        }

        int rootNum = preOrder[i2];
        ArrayList<Integer> list = map.get(rootNum);

        int root_index = -1;
        int left_len = -1;
        int right_len = -1;
        for(int index : list){
            left_len = index-i1;
            right_len = j1 - index;
            boolean isLeftVaild = false;
            if(left_len == 0){
                isLeftVaild = true;
            }else if(left_len < 0){
                isLeftVaild = false;
            }else{
                isLeftVaild = check(i1, index-1, i2+1, i2+left_len);
            }

            boolean isRightVaild = false;
            if(right_len == 0){
                isRightVaild = true;
            }else if(right_len < 0){
                isRightVaild = false;
            }else{
                isRightVaild = check(index+1,j1, j2-right_len+1,j2);
            }
            if(isLeftVaild && isRightVaild){
                root_index = index;
                break;
            }
        }

        TreeNode root = new TreeNode(root_index,rootNum);
        TreeNode left = build(i1,root_index-1, i2+1, i2+left_len);
        TreeNode right = build(root_index+1,j1, j2-right_len+1,j2);

        root.left = left;
        root.right = right;
        return root;
    }

    static boolean check(int i1, int j1, int i2, int j2){
        int[] t1 = new int[j1-i1+1];
        int[] t2 = new int[j2-i2+1];

        for(int k = 0; k<j1-i1+1; k++){
            t1[k] = inOrder[k+i1];
            t2[k] = preOrder[k+i2];
        }

        int[] t11 = Arrays.stream(t1).sorted().toArray();
        int[] t22 = Arrays.stream(t2).sorted().toArray();

        for(int k = 0; k<t11.length; k++){
            if(t11[k] != t22[k]){
                return false;
            }
        }
        return true;
    }

    static class TreeNode{
        int i;//在中序遍历数组中的索引

        int sum = -1;
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int i, int val){
            this.i = i;
            this.val = val;
        }
    }

}
