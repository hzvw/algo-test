package com.zhang.od;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * ClassName: _091_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/8 19:14
 * @Version 1.0
 */
public class _091_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] cs = str.toCharArray();
        int cnt = 0;
        int N = cs.length;

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<N; i++){
            char c = cs[i];

            if( c == 'M'){
                //左边已经有了
                if(set.contains(i-1)){
                    continue;//不用放了
                }else{
                    if(i+1 < N  && cs[i+1]=='I'){
                        set.add(i+1);
                        cnt++;
                    }else{
                        //右边不能放，看看左边是否能放
                        if(i-1>=0 && i-1<N && cs[i-1] == 'I'){
                            set.add(i-1);
                            cnt++;
                        }else{
                            //左右都不能放，gg
                            cnt = -1;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);

    }

}
