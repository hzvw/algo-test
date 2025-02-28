package com.zhang.od;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _030_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/6 1:33
 * @Version 1.0
 */
public class _030_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        LinkedList<Integer> buffer = new LinkedList<>();
        List<Integer[]> res = new ArrayList<>();
        int i_u = 0;
        int i_a = 0;
        int i_c = 0;
        for(int i = 0; i<s.length(); i++){
            switch (s.charAt(i)){
                case 'q':
                    buffer.add(i);
                    break;
                case 'u':
                    if(1 + i_u <= buffer.size()) i_u++;
                    break;
                case 'a':
                    if(1 + i_a <= i_u) i_a++;
                    break;
                case 'c':
                    if(1 + i_c <= i_a) i_c++;
                    break;
                case 'k':
                    if(i_c >= 1) {
                        res.add(new Integer[]{buffer.removeFirst(), i});
                        i_u--;
                        i_a--;
                        i_c--;
                    }
                    break;
                default:
                    System.out.println(-1);
                    return;
            }

        }

        if(res.size() == 0){
            System.out.println(-1);
            return;
        }

        int max = 1;
        for(int i = 0; i<res.size(); i++){
            int cnt = 1;
            for(int j = i+1; j<res.size(); j++){
                if(res.get(i)[1] > res.get(j)[0]){
                    cnt++;
                }
            }
            if(cnt > max){
                max = cnt;
            }
        }
        System.out.println(max);

    }




}
