package com.zhang.od;

/**
 * ClassName: _019_
 * Package: com.zhang.od
 * Description:增强的strstr
 *
 * @Author Harizon
 * @Create 2025/1/15 1:18
 * @Version 1.0
 */

import java.util.*;

public class _019_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        List<Set<Character>> buffer = new ArrayList<>();
        Set<Character> tmp = new HashSet<>();
        boolean flag = false;
        for(int i = 0; i<str2.length(); i++){
            char c = str2.charAt(i);
            if(c == '['){
                flag = true;
            }else if(c == ']'){
                flag = false;
                buffer.add(tmp);//收网
                tmp = new HashSet<>();
            }else{
                // 说明在中括号内
                if(flag){
                    tmp.add(c);//继续收集
                }else{ //不在中括号内
                    tmp = new HashSet<>();
                    tmp.add(c);
                    buffer.add(tmp);
                }
            }
        }

        int index = -1;
        for(int i = 0; i<=str1.length()-buffer.size(); i++){
            int j = 0;
            for(; j<buffer.size(); j++){
                Set<Character> set = buffer.get(j);
                Character c = str1.charAt(i+j);
                if(!set.contains(c)){
                    break;
                }
            }
            // 已到最后
            if(j == buffer.size()){
                index = i;
                System.out.println(index);
                return;
            }
        }
        System.out.println(index);
        return;
    }
}
