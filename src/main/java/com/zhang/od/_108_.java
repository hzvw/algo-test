package com.zhang.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _108_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/24 15:20
 * @Version 1.0
 */
public class _108_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] arr = sc.nextLine().split(" ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].toLowerCase();
            char[] cs = arr[i].toCharArray();

            List<Character> list = new ArrayList<>();
            for (int i1 = 0; i1 < cs.length; i1++) {
                char c = cs[i1];
                if(c >= 'a' && c <= 'z'){
                    list.add(c);
                }
            }
            list.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o1.compareTo(o2);
                }
            });
            StringBuilder sb = new StringBuilder();
            list.forEach(x -> sb.append(x));
            if(s1.equals(sb.toString())){
                System.out.println(i+1);
                return;
            }


        }
        System.out.println(-1);
        return;


    }

}
