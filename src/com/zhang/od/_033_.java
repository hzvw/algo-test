package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _033_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/17 12:57
 * @Version 1.0
 */
public class _033_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] words = line.split(" ");

        List<Integer> i1 = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
            i1.add(Integer.parseInt(words[i]));
        }

        int min = Integer.MAX_VALUE;
        int len = i1.size();
        for(int i = 1; i<len/2; i++){
            int j = i + i1.get(i);
            int st = 2;

            while(j<len - 1){
                j += i1.get(j);
                st++;
            }

            if(j == len - 1){
                min = Math.min(min, st);
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }



    }

}
