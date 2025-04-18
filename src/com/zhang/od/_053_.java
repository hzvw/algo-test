package com.zhang.od;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _053_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/18 23:01
 * @Version 1.0
 */
public class _053_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();

        if(M <= 1 || M >= 100){
            System.out.println("ERROR!");
            return;
        }

        LinkedList<Integer> buffer = new LinkedList<>();
        for(int i = 1; i<=100; i++){
            buffer.addLast(i);
        }

        int num = 1;
        while (buffer.size() >= M){
            int id = buffer.removeFirst();

            if(num == M){
                num = 1;
            }else{
                buffer.addLast(id);
                num++;
            }
        }

        buffer.sort((x,y)->x-y);
        for(int i = 0; i<buffer.size(); i++){
            System.out.print(buffer.get(i));
            if(i != buffer.size()-1){
                System.out.print(",");
            }
        }





    }

}
