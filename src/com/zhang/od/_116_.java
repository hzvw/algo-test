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
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        LinkedList<LinkedList<Integer>> link = new LinkedList<>();
        LinkedList<Integer> init = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            init.add(i);
        }
        link.addFirst(init);

        while (link.get(0).size() > 1){
            LinkedList<Integer> win = new LinkedList<>();
            LinkedList<Integer> lose = new LinkedList<>();

            LinkedList<Integer> tmp = link.removeFirst();
            for (int i = 0; i+1 < tmp.size(); i+=2) {
                int a = nums[tmp.get(i)];
                int b = nums[tmp.get(i+1)];

                if(a>b){
                    win.add(tmp.get(i));
                    lose.add(tmp.get(i+1));
                }else if(a<b){
                    win.add(tmp.get(i+1));
                    lose.add(tmp.get(i));
                }else{
                    win.add(tmp.get(i));
                    lose.add(tmp.get(i+1));
                }
            }
            if(tmp.size() % 2 == 1){
                win.add(tmp.getLast());
            }
            link.addFirst(lose);
            link.addFirst(win);
        }
        int first = link.get(0).getFirst();
        int second = link.get(1).getFirst();

        link.get(2).sort((a,b) -> nums[a] != nums[b] ? nums[b]- nums[a] : a-b);
        int thred = link.get(2).getFirst();

        System.out.println(first + " " + second + " " + thred);

    }

}
