package com.zhang._0416;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName: _003_
 * Package: com.zhang._0416
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/16 22:11
 * @Version 1.0
 */
public class _003_ {
    static int[] count = new int[14];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] cs = str.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            count[m1(c)]++;
        }

        System.out.println(dfs());

    }

    static Map<String, Integer> map = new HashMap<>();

    static int dfs(){
        String s = Arrays.toString(count);
        if(map.containsKey(s)){
            return map.get(s);
        }

        //System.out.println(s);
        int res = 0;
        for (int i = 1; i <=13 ; i++) {
            if(count[i] > 0){
                count[i] -= 1;
                res = Math.max(res, i + dfs());
                count[i] +=1;
            }
        }

        for (int i = 1; i <= 13 ; i++) {
            if(count[i] >= 2){
                count[i] -= 2;
                res = Math.max(res, i * 2 * 2 + dfs());
                count[i] += 2;
            }
        }

        for (int i = 1; i <= 13 ; i++) {
            if(count[i] >= 3){
                count[i] -= 3;
                res = Math.max(res, i * 3 * 2 + dfs());
                count[i] += 3;
            }
        }

        for (int i = 1; i <= 9 ; i++) {
            if(count[i] >= 1 && count[i+1] >= 1 && count[i+2] >= 1 && count[i+3] >= 1 &&count[i+4] >= 1){
                count[i] -= 1;
                count[i+1] -= 1;
                count[i+2] -= 1;
                count[i+3] -= 1;
                count[i+4] -= 1;
                res = Math.max(res, (i * 5 + 10)* 2 + dfs());
                count[i] += 1;
                count[i+1] += 1;
                count[i+2] += 1;
                count[i+3] += 1;
                count[i+4] += 1;
            }
        }

        for (int i = 1; i <= 13 ; i++) {
            if(count[i] >= 4){
                count[i] -= 4;
                res = Math.max(res, i * 4 * 3 + dfs());
                count[i] += 4;
            }
        }

        map.put(s, res);
        return res;
    }

    static int m1(char c){
        int res = 0;
        if(c >= '1' && c<= '9'){
            res = c - '0';
        }else if (c == '0'){
            res = 10;
        }else if(c == 'J'){
            res = 11;
        }else if(c == 'Q'){
            res = 12;
        }else if(c == 'K'){
            res = 13;
        }
        return res;
    }


}
