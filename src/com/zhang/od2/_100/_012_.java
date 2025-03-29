package com.zhang.od2._100;

import java.util.*;

/**
 * ClassName: _011_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 16:12
 * @Version 1.0
 */
public class _012_ {
    static String[] content = {"absent", "late","leaveearly", "present"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        for (String s : list) {
            String[] words = s.split(" ");

            if(check1(words) && check2(words) && check3(words)){
                System.out.print(true + " ");
            }else{
                System.out.print(false + " ");
            }
        }

    }

    static boolean check1(String[] words){
        int count = 0;
        for (String word : words) {
            if(content[0].equals(word)){
                count++;
            }
        }
        return count <= 1;
    }

    static boolean check2(String[] words){
        String last = "";
        for (String word : words) {
            if((word.equals(content[1])) || (word.equals(content[2]))){
                if((last.equals(content[1])) || (last.equals(content[2]))){
                    return false;
                }
            }
            last = word;
        }
        return true;
    }

    static boolean check3(String[] words){
        Set<String> set = new HashSet<>();
        set.add(content[0]);
        set.add(content[1]);
        set.add(content[2]);

        if(words.length <= 7){
            int count = 0;
            for (String word : words) {
                if(set.contains(word)){
                    count++;
                }
            }
            if(count > 3){
                return false;
            }
        }else{
            int count = 0;
            for (int i = 0; i < 7; i++) {
                if(set.contains(words[i])){
                    count++;
                }
            }
            if(count > 3){
                return false;
            }
            for (int i = 7; i < words.length; i++) {
                String in = words[i];
                String out = words[i-7];
                if(set.contains(in)){
                    count++;
                }
                if(set.contains(out)){
                    count--;
                }
                if(count > 3){
                    return false;
                }
            }

        }
        return true;
    }

}
