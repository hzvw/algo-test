package com.zhang.od.e;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: _073_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/16 0:49
 * @Version 1.0
 */
public class _073_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            Node na = map.get(a);
            Node nb = map.get(b);
            if(nb == null){
                nb = new Node(b, null);
                map.put(b, nb);
            }

            if(map.get(a) == null){
                na = new Node(a, nb);
                map.put(a,na);
            }else{
                na.fa = nb;
            }
        }

        int del = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(del);
        while (!queue.isEmpty()){
            int del_id = queue.poll();
            map.remove(del_id);

            for (Integer id : map.keySet()) {
                if(map.get(id).fa != null && map.get(id).fa.id == del_id){
                    queue.offer(id);
                }
            }
        }
        List<Integer> collect = map.keySet().stream().collect(Collectors.toList());
        collect.sort((a,b) -> a-b);
        if(collect.size() > 0 && collect.get(0) == 0){
            collect.remove(0);
        }
        StringJoiner sj = new StringJoiner(" ");
        collect.forEach(x -> sj.add(x + ""));
        System.out.println(sj.toString());
    }

    static class Node{
        int id;
        Node fa;

        public Node(int id, Node fa) {
            this.id = id;
            this.fa = fa;
        }
    }
}
