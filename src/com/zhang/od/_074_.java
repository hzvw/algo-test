package com.zhang.od;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * ClassName: _074_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/20 22:03
 * @Version 1.0
 */
public class _074_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, TreeMap<String, Integer>> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            String str = sc.nextLine();

            String sec = str.substring(0, 19);
            String mSec = str;

            TreeMap<String, Integer> tmp = map.get(sec);
            if(tmp == null){
                tmp = new TreeMap<>();
                tmp.put(mSec, 1);
                map.put(sec, tmp);
            }else{
                tmp.put(mSec, tmp.getOrDefault(mSec, 0) + 1);
            }
            //map.put(sec, tmp);
        }

        int cnt = 0;
        for(TreeMap<String, Integer> tmp : map.values()){
            cnt += tmp.get(tmp.firstKey());
        }

        System.out.println(cnt);


    }

}
