package com.zhang.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _044_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/18 12:29
 * @Version 1.0
 */
public class _044_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        List<Integer> buffer = new ArrayList<>();
        for(int i = 0; i<n; i++){
            buffer.add(sc.nextInt());
        }

        buffer.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int diff1 = Math.abs(o1 - x);
                int diff2 = Math.abs(o2 - x);
                if(diff1 == diff2){
                    if(o1 < o2){
                        return -1;
                    }else{
                        return 1;
                    }
                }else if(diff1 < diff2){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        List<Integer> buffer2 = new ArrayList<>();
        for(int i= 0; i<k; i++){
            buffer2.add(buffer.get(i));
        }
        buffer2.sort((p,q) -> p-q);

        for(int i : buffer2){
            System.out.print(i + " ");
        }



    }
}
