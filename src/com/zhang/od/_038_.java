package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _038_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/17 21:50
 * @Version 1.0
 */
public class _038_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        List<String> input = new ArrayList<>();
        for(int i = 0; i<2*N; i++){
            input.add(sc.nextLine());
        }

        int size = 0;
        boolean flag = true;
        int cnt = 0;

        for(int i = 0; i<input.size(); i++){
            String str = input.get(i);
            if(str.startsWith("head add")){
                if(size > 0 && flag){
                    flag = false;
                }
                size++;
            }else if(str.startsWith("tail add")){
                size++;
            }else{
                if(size <= 0){
                    continue;
                }
                if(!flag){
                    cnt++;
                    flag = true;
                }
                size--;
            }
        }
        System.out.println(cnt);


    }

}
