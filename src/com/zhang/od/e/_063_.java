package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _063_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/15 16:09
 * @Version 1.0
 */
public class _063_ {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> out_map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> in_map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0){
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            in_map.put(b, in_map.getOrDefault(b, 0) +1);
            out_map.putIfAbsent(a, new ArrayList<>());
            out_map.get(a).add(b);
            set.add(a);
            set.add(b);
        }

        int head =0;
        Queue<Integer> queue = new LinkedList<>();
        for (Integer ele : set) {
            if(!in_map.containsKey(ele)){
                head = ele;
                queue.offer(ele);
                break;
            }
        }

        int count = 0;
        List<Integer> tails = new ArrayList<>();
        while(!queue.isEmpty()){
            int t = queue.poll();
            count++;

            List<Integer> list = out_map.get(t);
            if(list == null || list.size() == 0){
                tails.add(t);
                continue;
            }
            for (Integer next : list) {
                in_map.put(next, in_map.get(next)-1);
                if(in_map.get(next) == 0){
                    queue.offer(next);
                }
            }


        }

        if(set.size() != count){
            System.out.println(-1);
            return;
        }else{
            StringJoiner sj = new StringJoiner(" ");
            sj.add(head+"");
            for (Integer tail : tails) {
                sj.add(tail+"");
            }
            System.out.println(sj.toString());
            return;
        }


    }



}
