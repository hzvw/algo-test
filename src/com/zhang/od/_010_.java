package com.zhang.od;

import java.util.*;

/**
 * ClassName: _010_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/14 16:45
 * @Version 1.0
 */
public class _010_ {
    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String str1 = sc.nextLine();

        line = line .replace("'"," ").replace(",","");
        String[] words = line.split(" ");

        List<Integer> res = new ArrayList<>();
        int max = 0;
        for(int i = 0; i<words.length; i++){
            int cnt = 0;
            int j = 0;
            int k = 0;
            while(j < words[i].length() && k<str1.length()){
                if(str1.charAt(k) == words[i].charAt(j)){
                    cnt++;
                }else{
                    break;
                }
                j++;
                k++;
            }
            if(cnt > max){
                max = cnt;
                res.clear();
                res.add(i);
            }else if(cnt == max){
                res.add(i);
            }

        }
        for(int i : res){
            System.out.print(words[i] + " ");
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String str1 = sc.nextLine();

        //line = line .replace("'"," ").replace(",","");
        String[] words = line.split("[^a-zA-Z]");

        TreeSet<String> set = new TreeSet<>();
        for(String s : words){
            if(s.startsWith(str1)){
                set.add(s);
            }
        }

        if(set.size() != 0){
            for(String s : set){
                System.out.print(s + " ");
            }
            System.out.println();
        }else{
            System.out.println(str1);
        }





    }

}
