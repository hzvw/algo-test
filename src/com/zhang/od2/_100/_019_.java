package com.zhang.od2._100;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: _019_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/31 14:49
 * @Version 1.0
 */
public class _019_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String reg = sc.nextLine();

        List<Set<Character>> list = new ArrayList<>();
        Set<Character> tmp = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < reg.length(); i++) {
            char c = reg.charAt(i);
            if(c == '['){
                flag = true;
            }else if(c == ']'){
                flag = false;
                list.add(tmp);
                tmp = new HashSet<>();
            }else{
                if(flag){
                    tmp.add(c);
                }else{
                    tmp = new HashSet<>();
                    tmp.add(c);
                    list.add(tmp);
                }
            }
        }

        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            int j = 0;
            for (; j < list.size() && i + j < str.length(); j++) {
                if(!list.get(j).contains(str.charAt(i + j)) ){
                    break;
                }
            }
            if(j == list.size()){
                index = i;
                break;
            }
        }
        System.out.println(index);



    }
}
