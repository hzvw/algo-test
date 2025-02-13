package com.zhang.od;

import java.util.*;

/**
 * ClassName: _095_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/22 23:57
 * @Version 1.0
 */
public class _095_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] words = line.split(" ");
        List<String> buffer = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String s = p1(words[i]);
            buffer.add(s);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        buffer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) == map.get(o2)){
                    if(o1.length() == o2.length()){
                        return o1.compareTo(o2);
                    }else{
                        return o1.length() - o2.length();
                    }
                }else{
                    return map.get(o2) - map.get(o1);
                }
            }
        });

        System.out.println(String.join(" ", buffer));


    }

    static String p1(String s1){
        List<Character> buffer = new ArrayList<>();
        for(int i = 0; i<s1.length(); i++){
            char c = s1.charAt(i);
            buffer.add(c);
        }
        buffer.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.compare(o1, o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        buffer.forEach(x -> sb.append(x));
        return sb.toString();
    }

}
