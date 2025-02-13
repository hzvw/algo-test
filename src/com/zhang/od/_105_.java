package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _105_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/23 22:57
 * @Version 1.0
 */
public class _105_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if(n > 100){
            System.out.println(-1);
            return;
        }

        int[] mem = new int[100];
        while(sc.hasNextLine()){
            String[] words = sc.nextLine().split(" ");

            int start = Integer.parseInt(words[0]);
            int val = Integer.parseInt(words[1]);

            if(start < 0 || start > 99 || val > 100){
                System.out.println(-1);
                return;
            }

            for(int i = start; i<start+val; i++){
                if(mem[i] != 0){
                    System.out.println(-1);
                    return;
                }else{
                    mem[i] = 1;
                }
            }
        }
        List<Integer> i1 = new ArrayList<>();
        for(int i = 1; i<100; i++){
            if(mem[i-1] != 0 && mem[i] == 0){
                i1.add(i);
            }
        }

        int min_i = -1;
        int diff = -1;
        for(int i : i1){
            int cnt = check(mem, i, n);
            if(cnt != -1 &&cnt >=n){
                if(diff == -1){
                    diff = cnt - n;
                    min_i = i;
                }else {
                    if(cnt -n < diff){
                        diff = cnt - n;
                        min_i = i;
                    }
                }
            }
        }
        System.out.println(min_i);
    }

    static int check(int[] mem, int i, int val){
        for(int j = i; j<=i+val-1 && j < mem.length; j++){
            if(mem[j] == 1){
                return -1;
            }
        }

        int cnt = 0;
        for(int j = i; j<mem.length; j++){
            if(mem[j] == 0){
                cnt++;
            }else{
                break;
            }
        }
        return cnt;
    }

}
