package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _103_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/23 21:29
 * @Version 1.0
 */
public class _103_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        List<List<String>> buffer = new ArrayList<>();
        for(int i =0; i<n; i++){
            buffer.add(new ArrayList<>());
        }

        int k = 0;//列表索引
        boolean flag = false;//是否该拐弯了
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);

            if(!flag){
                k = i % n;
                buffer.get(k).add(c+"");
            }else{
                k = n-1 - (i%n);
                buffer.get(k).add(c+"");
            }
            if((i+1) % n == 0){
                flag = !flag;
            }

        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<buffer.get(i).size(); j++){
                System.out.print(buffer.get(i).get(j));
            }
            if(i != n-1){
                System.out.println();
            }
        }

    }

}
