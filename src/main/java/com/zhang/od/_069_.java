package com.zhang.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: _069_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 23:28
 * @Version 1.0
 */
public class _069_ {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> count = new HashMap<>();
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            try{
                int n = Integer.parseInt(str);
                List<String> list = count.entrySet().stream().sorted((a, b) -> {
                    if (a.getValue() != b.getValue()) {
                        return b.getValue() - a.getValue();
                    } else {
                        return a.getKey().compareTo(b.getKey());
                    }
                }).limit(n).map(x->x.getKey()).collect(Collectors.toList());
                System.out.println(String.join(",", list));
            }catch(Exception e){
                count.put(str, count.getOrDefault(str, 0) + 1);
            }

        }

    }

}
