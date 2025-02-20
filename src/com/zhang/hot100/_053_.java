package com.zhang.hot100;

import java.util.*;

/**
 * ClassName: _053_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/20 14:08
 * @Version 1.0
 */
public class _053_ {
    public static void main(String[] args) {
        new _053_().canFinish(2, new int[][]{{1,0}});


    }

    HashMap<Integer, List<Integer>> out = new HashMap<>();
    HashMap<Integer, Integer> in_cnt = new HashMap<>();

    HashSet<Integer> set = new HashSet<>();

    public boolean canFinish(int n, int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];

            set.add(a);
            set.add(b);

            out.putIfAbsent(b, new ArrayList<>());

            out.get(b).add(a);
            in_cnt.put(a, in_cnt.getOrDefault(a,0) + 1);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (Integer ele : set) {
            if(!in_cnt.containsKey(ele)){
                queue.add(ele);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            int b = queue.poll();
            List<Integer> list = out.get(b);
            if(list == null || list.size() == 0){
                continue;
            }

            for (Integer a : list) {
                in_cnt.put(a, in_cnt.get(a)-1);
                if(in_cnt.get(a) == 0){
                    count++;
                    queue.add(a);
                }
            }
        }
        return in_cnt.size() == count;
    }
}
