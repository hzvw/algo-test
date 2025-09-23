package com.zhang.od;

import java.util.*;

/**
 * ClassName: _047_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/18 14:03
 * @Version 1.0
 */
public class _047_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        Map<String, String> map = new HashMap<>();
        for(int i = 0;i<N; i++){
            String line = sc.nextLine();
            String[] words = line.split( " ");
            map.put(words[0], words[1]);
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                for(int k = 0; k<9; k++){
                    for(int m = 0; m<9; m++){
                        String s = i+""+j+""+k+""+m;
                        int cnt = 0;
                        for(String st : map.keySet()){
                            if(!match(s, st).equals(map.get(st))){
                                break;
                            }else{
                                cnt++;
                            }
                        }
                        if(cnt == map.keySet().size()){
                            res.add(s);
                        }
                    }
                }
            }
        }
        if(res.size() == 1){
            System.out.println(res.get(0));
        }else{
            System.out.println("NA");
        }
//        System.out.println(match("3585", "8585"));;




    }

    //
    static String match(String s, String s1){
        boolean flag = false;
        int cnt = 0;
        int cnt0 = 0;

        List<Character> set1 = new ArrayList<>();
        List<Character> set2 = new ArrayList<>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == s1.charAt(i)){
                cnt++;
            }else{
                set1.add(s.charAt(i));
                set2.add(s1.charAt(i));
            }

        }

        for(Character c : set1){
            if(set2.remove(c)){
                cnt0++;
            }
        }
        return cnt+"A"+ (cnt0) + "B";
    }

}
