package com.zhang.od.e;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _061_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/13 18:23
 * @Version 1.0
 */
public class _061_ {
    static HashMap<Integer, List<P>> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n =sc.nextInt();
        int total = sc.nextInt();
        map = new HashMap<>();
        int min_reli = 0;
        int max_reli = 0;
        for (int i = 0; i < total; i++) {
            int type = sc.nextInt();
            int reli = sc.nextInt();
            int price = sc.nextInt();
            min_reli = Math.min(min_reli, reli);
            max_reli = Math.max(max_reli, reli);

            P p = new P(type, reli, price);
            List<P> list = map.get(type);
            if(list == null){
                list = new LinkedList<>();
                list.add(p);
                map.put(type, list);
            }else{
                list.add(p);
            }
        }

        int left = min_reli;
        int right = max_reli;
        while(left <= right){
            int mid = (right + left ) / 2;
            if(check(mid, s, n)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(right);
    }

    static boolean check(int mid,int s, int n){
        List<List<P>> res = new LinkedList<>();
        dfs(0, new LinkedList<>(), n, res, s, mid);
        return res.size() > 0;
    }


    static void dfs(int level, LinkedList<P> buckets, int n, List<List<P>> res, int s, int mid){
        if(level == n){
            if(!buckets.isEmpty() && buckets.stream().map(x->x.price).reduce(Integer::sum).get() <= s){
                res.add(new LinkedList<>(buckets));
            }
            return;
        }

        List<P> list = map.get(level);
        for (P p : list) {
            if(p.reli < mid){
                continue;
            }

            buckets.addLast(p);
            dfs(level+1, buckets, n, res, s, mid);
            buckets.removeLast();
        }

    }

    static class P{
        int type;
        int reli;
        int price;

        public P(int type, int reli, int price) {
            this.type = type;
            this.reli = reli;
            this.price = price;
        }
    }

}
