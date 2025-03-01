package com.zhang.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _116_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/25 20:38
 * @Version 1.0
 */
public class _116_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();

        int N = arr.length;
        //初始集合，只有一个
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<N; i++){
            list.add(i);
        }

        LinkedList<ArrayList<Integer>>  buffer = new LinkedList<>();
        buffer.addFirst(list);
        //冠军组的人数超过1，要继续比赛
        while(buffer.getFirst().size() > 1){
            ArrayList<Integer> firstList = buffer.removeFirst();

            ArrayList<Integer> win = new ArrayList<>();//获胜者分到这个组
            ArrayList<Integer> lose = new ArrayList<>();//失败者到这个组

            for(int i = 1;  i< firstList.size(); i += 2){
                int j1 = firstList.get(i-1);
                int j2 = firstList.get(i);

                if(arr[j1] >= arr[j2]){
                    win.add(j1);
                    lose.add(j2);
                }else{
                    win.add(j2);
                    lose.add(j1);
                }
            }
            if(firstList.size() % 2 == 1){
                win.add(firstList.get(firstList.size()-1));
            }


            buffer.addFirst(lose);
            buffer.addFirst(win);
        }
        int first = buffer.get(0).get(0);
        int second = buffer.get(1).get(0);

        buffer.get(2).sort((a,b)-> arr[a] != arr[b] ? Long.compare(arr[b], arr[a]) : a-b);

        int third = buffer.get(2).get(0);

        System.out.println(first + " " + second + " " + third);
    }

}
