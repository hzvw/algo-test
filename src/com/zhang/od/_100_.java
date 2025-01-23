package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _100_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/23 13:38
 * @Version 1.0
 */
public class _100_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> buffer = new ArrayList<>();
        for(int i = 0; i<N; i++){
            buffer.add(sc.nextInt());
        }
        int M = sc.nextInt();

        buffer.sort((a,b) -> b-a);
        int i = 0;
        int j = N-1;
        int cnt = 0;
        while(i <= j){
            int a = buffer.get(i);
            int b = buffer.get(j);

            if(a >= M){
                i++;
                cnt++;
            }else{
                if(a+b >= M && i!=j){
                    i++;
                    j--;
                    cnt++;
                }else{
                    j--;
                }
            }
        }

        System.out.println(cnt);


    }

}
