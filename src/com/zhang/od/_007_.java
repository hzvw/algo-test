package com.zhang.od;

import java.util.*;
/**
 * ClassName: _007_
 * Package: com.zhang.od
 * Description:boss的收入
 *
 * @Author 张汉至
 * @Create 2025/1/14 11:55
 * @Version 1.0
 */
public class _007_ {
    // id 收入
    static Map<String, Integer> id_income = new HashMap<>();
    // id 上级id
    static Map<String, String> low_high = new HashMap<>();
    // id 下级id集合
    static Map<String, Set<String>> high_low = new HashMap<>();
    // id的集合
    static Set<String> id_set = new HashSet<>();

    // 记录入度
    static Map<String, Integer> indegree = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for(int i = 0; i<N; i++){
             String str = sc.nextLine();
             String[] words = str.split(" ");

             id_set.add(words[0]);
             id_set.add(words[1]);

             low_high.put(words[0], words[1]);
             id_income.put(words[0], Integer.parseInt(words[2]));
        }

        // 建立low_high映射
        for(String id : low_high.keySet()){
            //上级id
            String high_id = low_high.get(id);

            if(high_low.get(high_id) != null){
                high_low.get(high_id).add(id);
            }else{
                Set<String> tmp = new HashSet<>();
                tmp.add(id);
                high_low.put(high_id, tmp);
            }
        }

        //建立入度
        //补充收入映射
        for(String id : id_set){
            if(high_low.get(id) == null){
                indegree.put(id, 0);
            }else{
                indegree.put(id, high_low.get(id).size());
            }
            if(id_income.get(id) == null){
                id_income.put(id, 0);
            }
        }

        //开始干活
        LinkedList<String> queue = new LinkedList<>();
        for(String id : indegree.keySet()){
            if(indegree.get(id) == 0){
                queue.offer(id);
            }
        }

        int cnt = 0;
        while (queue.size() > 0){
            String id = queue.pop(); cnt++;
            if(cnt == id_set.size()){
                System.out.println(id + " "+id_income.get(id));
                return;
            }
            //当前节点的收入
            int i1 = id_income.get(id);
            String high_id = low_high.get(id);
            //上级节点的收入
            int i2 = id_income.get(high_id);
            //更新上级节点的收入
            id_income.put(high_id, 15 *(i1 / 100) + i2);
            //上级节点的入度-1
            indegree.put(high_id, indegree.get(high_id)-1);
            //检查上级节点的入度是否到了0
            if(indegree.get(high_id) == 0){
                queue.offer(high_id);
            }
        }



        //寻找根节点
//        String top_id = null;
//        for(String str : set){
//            if(map2.get(str) == null){
//                top_id = str;
//            }
//        }
//
//        System.out.println(top_id + " " + p(top_id));
    }

    //暴力递归
    static int p(String id){
        if(high_low.get(id) == null){
            return id_income.get(id);
        }

        int tax = 0;
        for(String low_id : high_low.get(id)){
            int t1 = p(low_id);
            tax += 15 * (t1 / 100);
        }
        return id_income.get(id) == null ? tax : tax + id_income.get(id);
    }

}
