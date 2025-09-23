package com.zhang.od.e;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: _083_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/16 23:43
 * @Version 1.0
 */
public class _083_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ca = sc.nextInt();
        int n = sc.nextInt();
        LFU l = new LFU(ca);
        for (int i = 0; i < n; i++) {
            String op = sc.next();
            if(op.equals("put")){
                l.put(sc.next(), sc.nextInt());
            }else{
                l.get(sc.next());
            }
        }
        System.out.println(l.print());
    }

    static class LFU{
        static class Node{
            String key;
            int value;
            int fre;//总的访问次数

            public Node(String key, int value, int fre) {
                this.key = key;
                this.value = value;
                this.fre = fre;
            }
        }

        TreeMap<String, Node> map = new TreeMap<>();
        TreeMap<Integer, LinkedList<Node>> fr = new TreeMap<>();

        int capacity;

        int currentCapacity = 0;

        public LFU(int capacity){
            this.capacity = capacity;
        }
        int get(String key){
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.fre++;
                increaseFr(true, node);
                return node.value;
            }
            return -1;
        }

        void put(String key, int value){
            if(value > capacity){
                return;
            }

            if(map.containsKey(key)){
//                Node node = map.get(key);
//                node.value = value;
//                node.fre ++;
//                currentCapacity += value;
//                increaseFr(true, node);
            }else{
                while(currentCapacity + value > capacity){
                    del();
                }
                Node node = new Node(key, value, 1);
                map.put(key, node);
                currentCapacity += value;
                increaseFr(false, node);
            }
        }

        void del(){
            int first_key = fr.firstKey();
            LinkedList<Node> list = fr.get(first_key);
            map.remove(list.getFirst().key);
            currentCapacity -= list.getFirst().value;
            list.removeFirst();
            if(list.isEmpty()){
                fr.remove(first_key);
            }
        }

        void increaseFr(boolean isExists, Node node){
            if(isExists){
                int before_fre= node.fre-1;
                fr.get(before_fre).remove(node);
                if(fr.get(before_fre).size() == 0){
                    fr.remove(before_fre);
                }

                fr.putIfAbsent(node.fre, new LinkedList<>());
                fr.get(node.fre).add(node);
            }else{
                fr.putIfAbsent(node.fre, new LinkedList<>());
                fr.get(node.fre).add(node);
            }
        }

        String print(){
            if(map.keySet().size() == 0){
                return "NONE";
            }
            List<String>  list = map.keySet().stream().collect(Collectors.toList());
            StringJoiner sj = new StringJoiner(",");
            list.forEach(x-> sj.add(x));

            return sj.toString();
        }


    }

}
