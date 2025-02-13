package com.zhang.od;

import java.util.*;

/**
 * ClassName: _012_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/14 18:41
 * @Version 1.0
 */
public class _012_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        List<String> input = new ArrayList<>();
        for(int i = 0; i<N; i++){
            input.add(sc.nextLine());
        }
        Set<String> set = new HashSet<>();
        set.add("late");
        set.add("leaveearly");

        for(String s : input){
            boolean flag = true;
            String[] words = s.split(" ");
            int cnt = 0;

            for(int i = 0; i<words.length; i++){
                if(words[i].equals("absent")){
                    cnt++;
                }
                if(cnt > 1){
                    flag = false;
                    break;
                }
                int j = i+1;
                if(j < words.length){
                    if(set.contains(words[i]) && set.contains(words[j])){
                        flag = false;
                        break;
                    }
                }

                int k = Math.min(i+7, words.length-1);
                int cnt0 = 0;
                for(int m = i; m<k; m++){
                    if(words[m].equals("absent") || words[m].equals("late") || words[m].equals("leaveearly")){
                        cnt0++;
                    }
                }
                if(cnt0 > 3){
                    flag = false;
                    break;
                }
            }
            System.out.print(flag + " ");
        }


    }

}
