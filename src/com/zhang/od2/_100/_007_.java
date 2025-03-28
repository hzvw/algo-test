package com.zhang.od2._100;

import java.util.*;

/**
 * ClassName: _007_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 3:05
 * @Version 1.0
 */
public class _007_ {

    static Set<Integer> ids = new HashSet<>();// 记录所有的id
    static HashMap<Integer, Integer> id_income = new HashMap<>();

    static HashMap<Integer, Integer> id_boss = new HashMap<>();// 记录每个id的上级id

    static HashMap<Integer, List<Integer>> id_emp = new HashMap<>();// 记录每个id的下属


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int top_id = sc.nextInt();// 上级id
            int income = sc.nextInt();

            ids.add(id);
            ids.add(top_id);
            id_income.put(id, income);
            id_boss.put(id, top_id);
            id_emp.putIfAbsent(top_id, new ArrayList<>());
            id_emp.get(top_id).add(id);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer id : ids) {
            if(!id_emp.containsKey(id)){
                queue.offer(id);
            }
        }

        while (!queue.isEmpty()){
            int id = queue.poll();
            int boss = id_boss.get(id);
            List<Integer> emp = id_emp.get(boss);
            if(emp.isEmpty()){
                queue.offer(boss);
            }else{
                emp.remove(Integer.valueOf(id));
            }
            id_income.put(boss, id_income.getOrDefault(boss, 0) + 15 * (id_income.get(id) / 100));
        }

        int top_boss = 0;
        for (Integer id : ids) {
            if(!id_boss.containsKey(id)){
                top_boss = id;
            }
        }
        System.out.println(top_boss + " " + id_income.get(top_boss));
    }
}
