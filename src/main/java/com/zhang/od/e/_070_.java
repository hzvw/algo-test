package com.zhang.od.e;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: _070_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/30 1:32
 * @Version 1.0
 */
public class _070_ {

    // 字符串列表
    static LinkedList<String> queue;
    static List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queue = Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toCollection(LinkedList::new));
        while(!queue.isEmpty()){
            dfs(0);
        }
        System.out.println(res.size());
        for(List<String> list : res){
            for(String str : list){
                System.out.print(str + " ");
            }
            System.out.println();
        }

    }

    static void dfs(int level){
        String msg = queue.poll();
        int cnt = Integer.parseInt(queue.poll());

        if(level == res.size()){
            res.add(new ArrayList<>());
        }
        res.get(level).add(msg);

        for(int i = 0; i<cnt; i++){
            dfs(level+1);
        }

    }


}
