package com.zhang.od;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * ClassName: _114_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/24 22:54
 * @Version 1.0
 */
public class _114_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int taskA = arr[0];
        int taskB = arr[1];
        int num = arr[2];

        if(taskA > taskB){
            int t = taskA;
            taskA = taskB;
            taskB = t;
        }

        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i<=num; i++){
            int cost = i * taskA + (num-i) * taskB;
            if(cost != 0){
                set.add(cost);
            }
        }
        System.out.println(set);





    }


}
