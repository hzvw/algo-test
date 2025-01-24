package com.zhang.od;

import java.util.*;

/**
 * ClassName: _113_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/24 22:01
 * @Version 1.0
 */
public class _113_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //TNode root = new TNode(arr[0]);
        List<TNode> list = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            TNode node = new TNode(arr[i]);
            node.index = i;
            list.add(node);
        }
        if(list.size() == 1){
            System.out.println(list.get(0).val);
            return;
        }

        LinkedList<TNode> queue = new LinkedList<TNode>();
        queue.addLast(list.get(0));
        while(queue.size() > 0){
            TNode cur = queue.removeFirst();
            int index = cur.index;
            if(index * 2 + 1 < list.size()){
                cur.l = list.get(index*2 +1);
            }
            if(index*2 +2 < list.size()){
                cur.r = list.get(index*2 + 2);
            }
            if(cur.l != null){
                queue.addLast(cur.l);
            }
            if(cur.r != null){
                queue.addLast(cur.r);
            }
        }
        p(list.get(0));



    }

    static void p(TNode root){
        if(isLeafOrNull(root)){
            return;
        }

        p(root.l);
        p(root.r);
        System.out.print(root.val + " ");
    }


    static boolean isLeafOrNull(TNode node){
        if(node == null){
            return true;
        }
        if(node.l == null && node.r == null){
            return true;
        }
        return false;
    }


    static class TNode{
        int index;
        int val;
        TNode l;
        TNode r;

        public TNode(int val){
            this.val = val;
        }
    }
}
