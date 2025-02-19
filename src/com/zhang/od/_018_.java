package com.zhang.od;

import java.util.*;

/**
 * ClassName: _018_
 * Package: com.zhang.od
 * Description:跳房子一
 *
 * @Author Harizon
 * @Create 2025/1/15 0:28
 * @Version 1.0
 */
public class _018_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int sum = Integer.parseInt(sc.nextLine());

        str = str.substring(1, str.length()-1);
        Map<Integer, Integer> map = new HashMap<>();
        String[] words = str.split(",");
        int[] A = new int[words.length];
        for(int i = 0; i<words.length; i++){
            A[i] = Integer.parseInt(words[i]);
            if(map.get(A[i]) == null){
                map.put(A[i], i);
            }
        }

        int index_sum = Integer.MAX_VALUE;
        List<Integer> buffer = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
            if(map.get(sum - A[i]) != null && map.get(sum - A[i]) != i){
                if(i + map.get(sum - A[i]) < index_sum){
                    buffer.clear();
                    buffer.add(i);
                    buffer.add(map.get(sum-A[i]));
                    index_sum = i + map.get(sum - A[i]);
                }
            }
        }
        buffer.sort((a,b) -> a-b);
        List<String> buffer2 = new ArrayList<>();
        buffer.forEach(x -> buffer2.add(A[x] + ""));

        System.out.println("["+String.join(", ", buffer2) + "]");

    }

}
