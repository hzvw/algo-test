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

        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
            nums.add(Integer.parseInt(words[i]));
        }

        int min = Integer.MAX_VALUE;
        int len = nums.size();
        // 第一步可以跳1至（len/2-1）
        for(int i = 1; i<=len/2-1; i++){
            int st = 1;
            int j = i + nums.get(i);
            st++;

            while(j<len - 1){
                j += nums.get(j);
                st++;
            }

            if(j == len - 1){
                min = Math.min(min, st);
            }else{
                // 跳飞出去了
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }



    }

}
