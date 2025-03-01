package com.zhang.od;

import java.util.*;

/**
 * ClassName: _111_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/24 20:58
 * @Version 1.0
 */
public class _111_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        List<String> buffer = new ArrayList<>();
        String[] words = s1.split("[0-9a-f]+");
        for (int i = 0; i < words.length; i++) {
            buffer.add(words[i]);
        }

        Set<Character> set2 = new HashSet<>();
        for (char c : s2.toCharArray()) {
            set2.add(c);
        }

        List<String> res = new ArrayList<>();
        int min_diff = Integer.MAX_VALUE;
        int size2 = set2.size();
        for(String str : buffer){
            Set<Character> set = new HashSet<>();
            for(char c : str.toCharArray()){
                set.add(c);
            }
            int size1 = set.size();
            if(size1 <= size2){
                if(size2 - size1 < min_diff ){
                    min_diff = size2 - size1;
                    res.clear();
                    res.add(str);
                }else if(size2 - size1 == min_diff){
                    res.add(str);
                }
            }

        }
        res.sort((a,b)-> a.compareTo(b));

        if(res.size() == 0 || res.get(0) == null || "".equals(res.get(0)) ){
            System.out.println("Not Found");
        }else{
            System.out.println(res.get(0));
        }



    }

}
