package com.zhang.od2._100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * ClassName: _011_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 16:50
 * @Version 1.0
 */
public class _011_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine() + "-";
        int k = Integer.parseInt(sc.nextLine());

        Map<Character, Integer> count = new HashMap<>();

        char[] cs = str.toCharArray();
        char last = cs[0];
        int cnt = 1;
        for (int i = 1; i < cs.length; i++) {
            if(last == cs[i]){
                cnt++;
            }else{
                if(cnt > count.getOrDefault(last, 0)){
                    count.put(last, cnt);
                }
                cnt = 1;
            }
            last = cs[i];
        }
        List<Integer> list = count.values().stream().collect(Collectors.toList());
        list.sort((a,b) -> b-a);
        if(list.size() < k){
            System.out.println(-1);
            return;
        }else{
            System.out.println(list.get(k-1));
        }

    }
}
