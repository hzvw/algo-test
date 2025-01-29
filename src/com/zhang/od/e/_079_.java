package com.zhang.od.e;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: _079_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/29 20:44
 * @Version 1.0
 */
public class _079_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toList());
        List<String> bad = Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toList());

        TreeMap<Integer, String> id_name = new TreeMap<>();
        HashMap<String, Integer> name_id = new HashMap<>();

        TreeMap<Integer, Node> map = new TreeMap<>();

        int id = 0;
        for(String s : list){
            String[] split = s.split("-");
            if(name_id.get(split[0]) == null){
                name_id.put(split[0], id);
                id_name.put(id, split[0]);

                map.put(id, new Node(id, split[0], new HashSet<>()));
                id++;
            }

            if(name_id.get(split[1]) == null){
                name_id.put(split[1], id);
                id_name.put(id , split[1]);
                map.put(id, new Node(id, split[1], new HashSet<>()));
                id++;
            }
        }

        // 建立依赖关系
        for(String s : list){
            String[] split = s.split("-");
            int id1 = name_id.get(split[0]);
            int id2 = name_id.get(split[1]);

            map.get(id1).dep.add(map.get(id2));
        }

//        p(map, );
        List<Integer> res = new ArrayList<>();
        bad.stream().forEach(x-> {res.add(name_id.get(x));});

        Set<Integer> res_set = res.stream().collect(Collectors.toSet());
        ArrayList<String> res_list = new ArrayList<>();
        for(int i : id_name.keySet()){
            if(!res_set.contains(i)){
                res_list.add(id_name.get(i));
            }
        }
        System.out.print(res_list.size() != 0 ? String.join(",", res_list) : ",");
    }

    static void p(Map<Integer, Node> map, int root, List<Integer> res){
        List<Integer> list = new ArrayList<>();
        for (int i : map.keySet()) {
            if(map.get(i).dep.contains(root)){
                list.add(i);
                p(map, i, res);
            }
        }
        if(list.size() == 0){
            return;
        }
        res.addAll(list);
    }

    static class Node{
        int id;
        String name;
        Set<Node> dep;

        public Node(int id, String name, Set<Node> dep){
            this.id = id;
            this.name = name;
            this.dep = dep;
        }
    }


}
