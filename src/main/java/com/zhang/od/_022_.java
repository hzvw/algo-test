package com.zhang.od;

import java.util.*;

/**
 * ClassName: _022_
 * Package: com.zhang.od
 * Description:数组拼接
 *
 * @Author Harizon
 * @Create 2025/1/16 18:57
 * @Version 1.0
 */
public class _022_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 每次固定读取的长度
        int len = Integer.parseInt(sc.nextLine());
        //
        int x = Integer.parseInt(sc.nextLine());
        LinkedList<LinkedList<Integer>> arr = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i<x; i++){
            LinkedList<Integer> i1 = new LinkedList<>();
            String line = sc.nextLine();
            String[] words = line.split(",");
            for(int j = 0; j<words.length; j++){
                if(words[j].equals("")){
                    continue;
                }
                i1.add(Integer.parseInt(words[j]));
                cnt++;
            }
            arr.add(i1);
        }

        List<Integer> buffer = new ArrayList<>();
        int i = 0;
        while(buffer.size() < cnt){
            int j = 0;
            while(j < len && arr.get(i).size() != 0){
                int val = arr.get(i).removeFirst();
                buffer.add(val);
                j++;
            }
            i++;
            if(i >= arr.size()){
                i = 0;
            }
        }

        List<String> buffer2 = new ArrayList<>();
        buffer.forEach(k -> buffer2.add(k + ""));
        System.out.println(String.join(",", buffer2));

    }




}
