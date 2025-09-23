package com.zhang._0508;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: _solve_
 * Package: com.zhang._0508
 * Description:
 *
 * @Author Harizon
 * @Create 2025/5/8 19:29
 * @Version 1.0
 */
//题目描述
//        给定一个字符串，仅含英文字母和数字，请按如下规则对其进行排序：
//
//        排序后，原位置是数字的，排序后仍然是数字；原位置是字母的，排序后仍然是字母。
//        数字：按 0-9 升序。
//        英文字母：大写字母大于小写字母，小写字母按 a-z 升序，大写字母按 A-Z 升序。
//
//        输入
//        输入为一行字符串，长度范围 [1,1000)，字符串中不会出现除英文字母、数字以外的别的字符。
//
//        输出
//        输出排序后的字符串。
//
//        样例
//        输入样例a2CB1c
//        输出样例a1cB2C
public class _solve_ {

    public static void main(String[] args) {
        List<Character> nums = new ArrayList<>();

        List<Character> lows = new ArrayList<>();

        String str = "a2CB1c";

        char[] cs = str.toCharArray();
        Set<Integer> numInx = new HashSet<>();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if(Character.isDigit(c)){
                numInx.add(i);
                nums.add(c);
            }else{
                lows.add(c);
            }
        }

        nums.sort((a,b) -> a-b);
        lows.sort((a,b) ->{
            if(Character.isLowerCase(a) && Character.isLowerCase(b)){
                return a-b;
            }else if(Character.isUpperCase(a) && Character.isUpperCase(b)){
                return a-b;
            }else if(Character.isLowerCase(a) && Character.isUpperCase(b)){
                return -1;
            }else{
                return 1;
            }
        });

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int index1 = 0;
        int index2 = 0;
        while (i < str.length()){
            if(numInx.contains(i)){
                sb.append(nums.get(index1++));
            }else{
                sb.append(lows.get(index2++));
            }
            i++;
        }
        System.out.println(sb.toString());




    }
}
