package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _106_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/24 0:36
 * @Version 1.0
 */
public class _106_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> buffer = new ArrayList<>();
        for(int i = 0; i<n; i++){
            buffer.add(sc.nextInt());
        }

        buffer.sort((a,b)->b-a);
        int i = 0;
        int j = buffer.size() - 1;
        int cnt = 0;
        while(i < j){
            int a = buffer.get(i);
            int b = buffer.get(j);
            if(a + b == m){
                cnt++;
                i++;
                j--;
            }else if(a + b < m){
                i++;
                j--;
                cnt++;
            }else{
                cnt++;
                i++;
            }
        }
        if(i == j){
            cnt++;
        }
        System.out.println(cnt);



    }

}
