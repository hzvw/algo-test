package com.zhang.od;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _048_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/18 15:08
 * @Version 1.0
 */
public class _048_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K =  Integer.parseInt(sc.nextLine());
        int N = Integer.parseInt(sc.nextLine());

        List<String> buffer = new ArrayList<>();
        for(int i = 0; i<N; i++){
            buffer.add(sc.nextLine());
        }

        List<String> res = new ArrayList<>();
        res.add(buffer.remove(K));
        HashMap<Character,ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i <buffer.size(); i++){
            String str = buffer.get(i);
            char c = str.charAt(0);
            if(map.get(c) == null){
                ArrayList<String> t = new ArrayList<>();
                t.add(str);
                map.put(c, t);
            }else{
                map.get(c).add(str);
            }
            map.get(c).sort((a,b) -> a.length() != b.length() ? b.length()-a.length() : a.compareTo(b));
        }

        String last_word = res.get(res.size()-1);
        char last_c = last_word.charAt(last_word.length()-1);
        while(true){
            ArrayList<String> t = map.get(last_c);

            if(t != null && t.size() > 0){
                last_word = t.remove(0);
                last_c = last_word.charAt(last_word.length()-1);
                res.add(last_word);
            }else{
                break;
            }
        }

        System.out.println(String.join("", res));




    }

}
