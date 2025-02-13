package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _004_
 * Package: com.zhang.od
 * Description:敏感字段加密
 *
 * @Author Harizon
 * @Create 2025/1/4 23:13
 * @Version 1.0
 */
public class _004_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        str = str + "_";
        List<String> res = new ArrayList<>();
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '"'){
                flag = !flag;
            }
            if(str.charAt(i) != '_'){
                sb.append(str.charAt(i));
            }
            if(str.charAt(i) == '_' && flag){
                sb.append(str.charAt(i));
            }
            if(str.charAt(i) == '_' && !flag){
                if(!sb.toString().equals("")){
                    //System.out.println(sb.toString());
                    res.add(sb.toString());
                }
                sb = new StringBuilder();
            }
        }
        if(k >= res.size()){
            System.out.println("ERROR");
        }else{
            res.set(k, "******");
            System.out.println(String.join("_", res));
        }


    }

    static void fullrank(StringBuilder sb){

    }


    //求全排列
    static void p(char[] chars, int i, ArrayList<String> ret){
        if(i == chars.length){
            ret.add(String.valueOf(chars));
            return;
        }

        for(int j = i; j<chars.length; j++){
            swap(chars, i , j);
            p(chars, i+1, ret);
            swap(chars, i, j);
        }


    }

    static void swap(char[] chars , int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }



}
