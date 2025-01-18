package com.zhang.od;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _052_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/18 22:25
 * @Version 1.0
 */
public class _052_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split(" ");

        Long[] arr = new Long[words.length];
        for(int i = 0; i<words.length; i++){
            arr[i] = Long.parseLong(words[i]);
        }

        LinkedList<Long> buffer = new LinkedList<>();
        buffer.add(arr[0]);

        for(int i = 1; i<arr.length; i++){
            p(buffer, arr[i]);
        }

        for(int i = buffer.size()-1; i>=0; i--){
            System.out.print(buffer.get(i) + " ");
        }

    }

    static void p(LinkedList<Long> buffer,long num){
        long sum = 0;
        for(int i = buffer.size()-1; i>=0; i--){
            sum += buffer.get(i);

            if(sum == num){
                buffer.subList(i, buffer.size()).clear();
                long t = num * 2;
                p(buffer, t);
                return;
            }else if(sum > num){
                break;
            }else{
                continue;
            }
        }
        buffer.add(num);
    }

}
