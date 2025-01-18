package com.zhang.od;

import java.util.*;

/**
 * ClassName: _046_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/18 13:37
 * @Version 1.0
 */
public class _046_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String[] words1 = str1.split(",");

        String str2 = sc.nextLine();
        String[] words2 = str2.split(",");

        List<String> res = new ArrayList<>();
        for(int i = 0; i<words1.length; i++){
            String word = words1[i];
            String p1 = p(word);

            int j = 0;
            boolean flag = false;
            for(; j<words2.length; j++){
                String p2 = p(words2[j]);
                if(p1.equals(p2)){
                    res.add(words2[j]);
                    flag = true;
                    //break;
                }
            }
            if(!flag){
                res.add("not found");
            }

        }

        System.out.println(String.join(",", res));



    }

    //将一个单词去重并排序
    static String p(String word){
        TreeSet<Character> set = new TreeSet<>();
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            set.add(c);
        }
        return set.toString();
    }

}
