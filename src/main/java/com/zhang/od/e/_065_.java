package com.zhang.od.e;

import java.sql.SQLOutput;
import java.util.*;

/**
 * ClassName: _065_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/15 17:57
 * @Version 1.0
 */
public class _065_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        LinkedList<Node> list = new LinkedList<>();
        list.add(new Node(-1));//废节点
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            list.add(node);
        }
        int i = 1;
        while(i < list.size()){
            if(i *2 < list.size()){
                list.get(i).left = list.get(i * 2).val == -1 ? null : list.get(i * 2);
            }
            if(i*2 +1 < list.size()){
                list.get(i).right = list.get(i * 2 + 1).val == -1 ? null : list.get(i*2 + 1);
            }
            i++;
        }
        list.removeFirst();
        Node root = list.get(0);
        LinkedList<LinkedList<Node>> res = new LinkedList<>();
        dfs(root, new LinkedList<>(), res);
        res.sort((a,b) -> a.getLast().val - b.getLast().val);
        StringJoiner sj = new StringJoiner(" ");
        res.get(0).stream().forEach(x -> sj.add(x.val+""));
        System.out.println(sj.toString());
    }

    static void dfs(Node root, LinkedList<Node> buckets, LinkedList<LinkedList<Node>> res){
        if(root == null){
            return;
        }
        buckets.addLast(root);

        if(isLeaf(root)){
            res.add(new LinkedList<>(buckets));
        }else{
            dfs(root.left, buckets, res);
            dfs(root.right, buckets, res);
        }
        buckets.removeLast();
    }

    static boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }

    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
