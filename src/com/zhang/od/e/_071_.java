package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _071_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/15 23:44
 * @Version 1.0
 */
public class _071_ {
    static Map<String, Integer> map = new HashMap<>();
    static{
        for (int i = 2; i <=10 ; i++) {
            map.put(i+"", i);
        }
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
    }

    //记录每种牌的次数
    static TreeMap<Integer, Integer> count = new TreeMap<>();

    // 记录花色
    static Set<String> set = new HashSet<>();

    static List<Integer> values;//记录次数，降序排序

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String a = sc.next();
            String b = sc.next();

            int i_a = map.get(a);

            set.add(b);
            count.put(i_a, count.getOrDefault(i_a, 0) +1);
        }
        values = new ArrayList<>(count.values());
        values.sort((a,b) -> b -a);

        if(m1()){
            System.out.println(1);
            return;
        }else if(m2()){
            System.out.println(2);
            return;
        }else if(m3()){
            System.out.println(3);
            return;
        }else if(m4()){
            System.out.println(4);
            return;
        }
        else if(m5()){
            System.out.println(5);
            return;
        }else if(m6()){
            System.out.println(6);
            return;
        }

    }

    static boolean m1(){
        //花色只有一种
        if(set.size() != 1){
            return false;
        }
        if(count.keySet().size() != 5){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : count.keySet()) {
            sb.append(integer+"");
        }
        if("234514".equals(sb.toString())){
            return true;
        }
        return count.lastKey() - count.firstKey() == 4;
    }
    static boolean m2(){
        return count.keySet().size() == 2 && values.get(0) == 4;
    }
    static boolean m3(){
        if(values.size() != 2){
            return false;
        }
        return count.keySet().size() == 2 && values.get(0) == 3 && values.get(1) == 2;
    }
    static boolean m4(){
        return set.size() == 1;
    }
    static boolean m5(){
        if(set.size() == 1){
            return false;
        }
        if(count.keySet().size() != 5){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : count.keySet()) {
            sb.append(integer+"");
        }
        if("234514".equals(sb.toString())){
            return true;
        }
        return count.lastKey() - count.firstKey() == 4;
    }
    static boolean m6(){
        return values.size() == 3 && values.get(0) == 3 && values.get(1) == 1 && values.get(2) == 1;
    }


}
