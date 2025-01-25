package com.zhang.od.e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * ClassName: _003_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/26 1:49
 * @Version 1.0
 */
public class _003_ {
    static int[] arr1 = null;//中序
    static int[] arr2 = null;//先序

    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();//存放中序遍历中，元素与位置的关系

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i<arr1.length; i++){
            map.putIfAbsent(arr1[i], new ArrayList<Integer>());
            map.get(arr1[i]).add(i);
        }
        TreeNode root = build(0, arr1.length-1, 0, arr2.length-1);
    }
    /*
     */
    static TreeNode build(int i1, int j1, int i2, int j2){
        int rootNum = arr2[i2];
        ArrayList<Integer> list = map.get(rootNum);

        for(int index : list){

        }


        return null;
    }

    static class TreeNode{
        int val;
        int left;
        int right;

        public TreeNode(int val){
            this.val = val;
        }
    }

}
