package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * ClassName: _051_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/18 21:29
 * @Version 1.0
 */
public class _051_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            Integer cnt = map.get(c);
            if(cnt == null){
                cnt = 1;
                map.put(c, cnt);
            }else{
                cnt++;
                map.put(c ,cnt);
            }
        }
        List<P> buffer = new ArrayList<>();
        for(char c : map.keySet()){
            Integer cnt = map.get(c);
            buffer.add(new P(c, cnt));
        }
        buffer.sort((a,b)-> b.cnt != a.cnt ? b.cnt - a.cnt : p(a.c,b.c));
        for(int i = 0; i<buffer.size(); i++){
            System.out.print(buffer.get(i).c + ":" + buffer.get(i).cnt + ";");
        }

    }

    static int p(char c1, char c2){
        if(Character.isLowerCase(c1) && Character.isLowerCase(c2)){
            return c1 - c2;
        }else if(Character.isUpperCase(c1) && Character.isUpperCase(c2)){
            return c1 - c2;
        }else if(Character.isLowerCase(c1) && Character.isUpperCase(c2)){
            return -1;
        }else{
            return 1;
        }
    }

    static class P{
        char c;
        int cnt;
        public P(char c, int cnt){
            this.c = c;
            this.cnt = cnt;
        }



    }

}
