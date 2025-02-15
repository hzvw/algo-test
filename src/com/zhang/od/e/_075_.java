package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _075_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/16 1:24
 * @Version 1.0
 */
public class _075_ {
    //记录出度
    static HashMap<String, List<String>> out = new HashMap<>();

    //记录每个节点的入度个数
    static HashMap<String, Integer> in = new HashMap<>();

    //记录所有节点
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        for (int i = 0; i < words.length; i++) {
            String[] t = words[i].split("->");
            String a = t[0];
            String b = t[1];

            set.add(a);
            set.add(b);
            //b->a

            if(out.get(b) == null){
                out.put(b, new ArrayList<>());
            }
            out.get(b).add(a);
            in.put(a, in.getOrDefault(a, 0) +1);
        }

        LinkedList<String> queue = new LinkedList<>();
        for (String s : set) {
            if(!in.keySet().contains(s)){
                queue.offer(s);
            }
        }
        List<String> res = new ArrayList<>();
        while (queue.size() > 0){
            Collections.sort(queue, (a,b) -> a.compareTo(b));
            String s = queue.poll();

            res.add(s);

            List<String> list = out.get(s);
            if(list == null || list.size() == 0){
                continue;
            }

            for (String s1 : list) {
                in.put(s1, in.get(s1)-1);
                if(in.get(s1) == 0){
                    queue.offer(s1);
                }
            }

        }
        StringJoiner sj = new StringJoiner(" ");
        res.forEach(x -> sj.add(x));
        System.out.println(sj.toString());

    }
}
