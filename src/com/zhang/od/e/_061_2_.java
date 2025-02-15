package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _061_2_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/15 12:40
 * @Version 1.0
 */
public class _061_2_ {
    static TreeMap<Integer, List<P>> map = new TreeMap<>();

    static int n;

    static int s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        n =sc.nextInt();
        int total = sc.nextInt();
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

        // 价格升序，map中的type也是升序的
        for (int i = 0; i < n; i++) {
            List<P> list = map.get(i);
            list.sort((a,b) -> a.price - b.price);
        }

        int ans = -1;
        int left = min_reli;
        int right = max_reli;
        while(left <= right){
            int mid = (right + left)/2;
            if(check(mid)){
                //如果取的这个可靠性
                //在不超过预算的情况下，请给出能够组成的设备的最大可靠性。
                //换句话说，可靠性越大越好
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        ans = right;
        System.out.println(ans);
    }

    static boolean check(int mid){
        //选择这种可靠性，则意味着这个可靠性是本组合中最小的，那就是说，这个组合中的所有器件的可靠性都大于等于mid
        int sum = 0;
        for (int i = 0; i < n; i++) {
            List<P> list = map.get(i);
            int index = binaryS(list, mid);
            if(index < 0){
                // 找到了合适的位置
                index = -index-1;
            }

            if(index == list.size()){
                return false;
            }
            sum += list.get(index).price;
        }
        return sum <= s;
    }

    static int binaryS(List<P> list, int target){
        int left = 0;
        int right = list.size()-1;
        while(left <= right){
            int t = (right + left )/2;
            int reli = list.get(t).reli;
            if(target > reli){
                left = t+1;
            }else if(target < reli){
                right = t-1;
            }else{
                return t;
            }
        }
        return -left-1;
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
