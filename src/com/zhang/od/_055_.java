package com.zhang.od;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName: _055_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/19 0:00
 * @Version 1.0
 */
public class _055_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        char[] cs = new char[n];
        for(int i = 0; i<n; i++){
            cs[i] = (char)('0' + (i+1));
        }

        res = new ArrayList<>();
        p(cs, 0);
        res.sort((x,y)->x.compareTo(y));
        System.out.println(res.get(k-1));

        //res.forEach(System.out::println);

    }

    static ArrayList<String> res;

    static void p(char[] cs, int i){
        if(i == cs.length){
            res.add(String.valueOf(cs));
        }

        for(int j = i; j<cs.length; j++){
            swap(cs, i, j);
            p(cs, i+1);
            swap(cs, i, j);
        }
    }

    static void swap(char[] cs, int i, int j){
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }

}
