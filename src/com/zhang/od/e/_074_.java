package com.zhang.od.e;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName: _074_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/29 23:11
 * @Version 1.0
 */
public class _074_ {

    static int count[] = new int[14];
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        String str = "33445677";
        char[] cs = str.toCharArray();
        for(int i = 0; i<cs.length; i++){
            char c = cs[i];
            int t = (c == '0') ? 10:(c == 'J') ? 11  : (c == 'Q') ? 12 : (c == 'K') ? 13 : c-'0';
            count[t] ++;
        }
        System.out.println(dfs());
    }

    static int dfs(){
        String str = Arrays.toString(count);
        if(map.containsKey(str)){
            return map.get(str);
        }

        int result = 0;
        for(int i = 1; i<count.length; i++){
            if(count[i] >= 1){
                count[i]--;
                result = Math.max(result, i + dfs());
                count[i]++;
            }
        }

        for(int i = 1; i<count.length; i++){
            if(count[i] >= 2){
                count[i]-=2;
                result = Math.max(result, i*2*2 + dfs());
                count[i]+=2;
            }
            if(count[i] >= 3){
                count[i]-=3;
                result = Math.max(result, i*3*2 + dfs());
                count[i]+=3;
            }
        }
        for(int i = 1; i<=9; i++){
            if(count[i]>0 && count[i+1]>0 && count[i+2]>0 && count[i+3]>0 && count[i+4]>0){
                count[i]--;
                count[i+1]--;
                count[i+2]--;
                count[i+3]--;
                count[i+4]--;
                result = Math.max(result, i*10 + 20 + dfs());
                count[i]++;
                count[i+1]++;
                count[i+2]++;
                count[i+3]++;
                count[i+4]++;
            }
        }

        for(int i = 1; i<=13; i++){
            if(count[i] == 4){
                count[i] -= 4;
                result = Math.max(result, i * 4 * 3 + dfs());
                count[i] += 4;
            }
        }
        map.put(str, result);
        return result;
    };




}
