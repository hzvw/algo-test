package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _018_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/1 15:46
 * @Version 1.0
 */
public class _018_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Map<String,Node> map = new HashMap<>();
        for(int i = 0; i<N; i++){
            String[] names = sc.nextLine().split(" ");
            Node node1 = map.get(names[0]);
            Node node2 = map.get(names[1]);

            if(node1 == null){
                node1 = new Node();
                node1.name = names[0];
                map.put(names[0], node1);
            }
            if(node2 == null){
                node2 = new Node();
                node2.name = names[1];
                map.put(names[1], node2);
            }
            node2.child.add(node1);
        }
        String str = sc.nextLine();
        LinkedList<Node> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        queue.offer(map.get(str));
        while(!queue.isEmpty()){
            Node cur = queue.poll();

            list.add(cur.name);
            for(Node node : cur.child){
                queue.offer(node);
            }
        }

        if(list.size() > 0){
            list.remove(0);
        }
        list.sort((a,b) -> a.compareTo(b));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }

    static class Node{
        String name;
        List<Node> child = new ArrayList<>();
    }

}
