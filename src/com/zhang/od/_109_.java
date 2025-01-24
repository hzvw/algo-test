package com.zhang.od;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * ClassName: _109_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/24 16:25
 * @Version 1.0
 */
public class _109_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int[] count = new int[18];
        Arrays.fill(count, 4);

        String[] a1 = s1.split("-");
        String[] a2 = s2.split("-");
        for(String s : a1){
            count[p1(s)]--;
        }
        for(String s: a2){
            count[p1(s)]--;
        }
        for(int i = 15; i<=17; i++){
            count[i] = 0;
        }

        int l = 3;
        int r = 3;
        int maxLen = 0;
        int maxl = -1;
        while(r <= 15){
            if(count[r] > 0){
                r++;
            }else{
                if(r-l >= maxLen){
                    maxLen = r-l;
                    maxl = l;
                }
                r++;
                l = r;
            }
        }
        if(maxLen < 5){
            System.out.println("NO-CHAIN");
            return;
        }

        StringJoiner sj = new StringJoiner("-");
        for(int i = 0; i<maxLen; i++){
            sj.add(k_v.get(maxl + i));
        }
        System.out.println(sj.toString());
    }


    static HashMap<String, Integer> v_k = new HashMap<>();
    static{
        for(int i = 3; i<=10; i++){
            v_k.put(i+"", i);
        }
        v_k.put("J", 11);
        v_k.put("Q", 12);
        v_k.put("K", 13);
        v_k.put("A", 14);
        v_k.put("2", 15);
        v_k.put("B", 16);
        v_k.put("C", 17);
    }

    static HashMap<Integer, String> k_v = new HashMap<>();
    static{
        for(int i = 3; i<=10; i++){
            k_v.put(i, i+"");
        }
        k_v.put(11, "J");
        k_v.put(12, "Q");
        k_v.put(13, "K");
        k_v.put(14, "A");
        k_v.put(15, "2");
        k_v.put(16, "B");
        k_v.put(17, "C");
    }
    //牌面映射为索引
    static int p1(String s){
        return v_k.get(s);
    }

    //索引值映射为牌面
    static String p2(int i){
        return k_v.get(i);
    }

}
