package com.zhang.od.e;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _064_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/15 17:28
 * @Version 1.0
 */
public class _064_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        List<R> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new R(s,e));
        }
        System.out.println(Math.min(m1(m, list), m2(m, list)));;
    }

    private static int m2(int m, List<R> list) {
        //按照结束时间降序
        list.sort((a, b) -> b.e - a.e);
        LinkedList<LinkedList<R>> group = new LinkedList<>();
        LinkedList<R> list1 = new LinkedList<>();
        list1.add(list.get(0));
        group.add(list1);

        for (int i = 1; i < list.size(); i++) {
            R r = list.get(i);
            boolean flag = false;

            for (LinkedList<R> li : group) {
                R r1 = li.getLast();
                if(r.e <= r1.s && li.size() < m){
                    li.add(r);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                LinkedList<R> tmp  = new LinkedList<>();
                tmp.add(r);
                group.add(tmp);
            }
        }
        return group.size();
    }

    private static int m1(int m, List<R> list) {
        //按照开始时间升序
        list.sort((a, b) -> a.s - b.s);
        LinkedList<LinkedList<R>> group = new LinkedList<>();
        LinkedList<R> list1 = new LinkedList<>();
        list1.add(list.get(0));
        group.add(list1);

        for (int i = 1; i < list.size(); i++) {
            R r = list.get(i);
            boolean flag = false;

            for (LinkedList<R> li : group) {
                R r1 = li.getLast();
                if(r.s >= r1.e && li.size() < m){
                    li.add(r);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                LinkedList<R> tmp  = new LinkedList<>();
                tmp.add(r);
                group.add(tmp);
            }
        }
        return group.size();
    }

    static class R{
        int s;
        int e;

        public R(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

}
