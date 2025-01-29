package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _036_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/30 0:48
 * @Version 1.0
 */
public class _036_ {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static{
        map.put(2,5);
        map.put(5,2);
        map.put(6,9);
        map.put(9,6);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ints = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < ints.length; i++) {
            res.add(ints[i] + "");
            if(map.get(ints[i]) != null){
                res.add(map.get(ints[i]) + "");
            }
        }

        p(ints, 0, 2, new LinkedList<>(), res, new boolean[ints.length]);

        List<Integer> ret = new ArrayList<>();
        res.forEach(x -> ret.add(Integer.parseInt(x)));

        ret.sort((x,y) -> Integer.compare(x,y));

        System.out.println(ret.get(Arrays.stream(ints).boxed().max((a,b)->a-b).get()-1));
       // ret.forEach(System.out::println);

    }

    static void p(int[] ints,int level, int n, LinkedList<Integer> buckets, List<String> res, boolean[] visited){
        if(buckets.size() == n){
//            System.out.println(buckets.stream().map( x -> x+"").reduce("", String::concat));
            res.add(buckets.stream().map( x -> x+"").reduce("", String::concat));
            return ;
        }

        for(int i = 0; i<ints.length; i++){
            if(visited[i]){
                continue;
            }
            if(map.get(ints[i]) != null){
                int[] tmp = new int[]{ints[i], map.get(ints[i])};
                for(int j = 0; j<2; j++){
                    buckets.addLast(tmp[j]);
                    visited[i] = true;

                    p(ints, i+1, n, buckets, res, visited);
                    buckets.removeLast();
                    visited[i] = false;
                }
            }else{
                buckets.addLast(ints[i]);
                visited[i] = true;

                p(ints, i+1, n, buckets, res, visited);
                buckets.removeLast();
                visited[i] = false;
            }
        }

    }



}
