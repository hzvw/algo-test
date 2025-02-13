package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _057_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 1:35
 * @Version 1.0
 */
public class _057_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();

        boolean[] map = new boolean[4096];
        String[] words = str.split(",");
        for(String word : words){
            String[] ab = word.split("-");
            if(ab.length > 1){
                int start = Integer.parseInt(ab[0]);
                int end = Integer.parseInt(ab[1]);
                for(int i = start; i<=end; i++){
                    map[i] = true;
                }
            }else{
                map[Integer.parseInt(ab[0])] = true;
            }
        }

        map[k] = false;

        List<String> buffer = new ArrayList<>();
        String s = "";
        int last = 0;
        for(int i = 1; i<=4095; i++){
            if(map[i]){
                if("".equals(s)){
                    s+=i;
                    last = i;
                }
            }else{
                if(!"".equals(s)){
                    if(last != i-1){
                        s += "-";
                        s += i-1;
                    }else{

                    }
                    buffer.add(s);
                }
                s = "";
            }
        }

        System.out.println(String.join(",", buffer));


    }

}
