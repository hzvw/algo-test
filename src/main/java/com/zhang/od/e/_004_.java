package com.zhang.od.e;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: _004_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/26 17:51
 * @Version 1.0
 */
public class _004_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 句子集合
        LinkedList<String> linkedList = Arrays.stream(sc.nextLine().split("[.;,]")).collect(Collectors.toCollection(LinkedList::new));
        // 单词集合
        Set<String> set = Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toSet());

        ArrayList<String> res = new ArrayList<>();
        while (!linkedList.isEmpty()){
            String s = linkedList.pollFirst();

            int j = s.length();
            while (j > 0){
                String tmp = s.substring(0, j);
                if(set.contains(tmp)){
                    res.add(tmp);
                    set.remove(tmp);
                    if(j != s.length()){
                        linkedList.addFirst(s.substring(j));
                    }
                    break;
                }
                j--;
            }

            if(j == 0){
                res.add(s.charAt(0) + "");
                if(s.length() > 1){
                    linkedList.addFirst(s.substring(1));
                }
            }

        }
        System.out.println(String.join(",", res));

    }

}
