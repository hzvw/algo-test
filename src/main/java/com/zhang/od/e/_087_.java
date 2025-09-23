package com.zhang.od.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: _087_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/17 22:23
 * @Version 1.0
 */
public class _087_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int max = str.length();

        str = str + str;

        int status = 0b000;
        int[] map = new int[8];
        Arrays.fill(map, -2);
        map[0] = -1;
        int max_len = 0;
        for (int i = 0; i <str.length() ; i++) {
            char c = str.charAt(i);

            if(c == 'l'){
                status ^= 0b100;
            }else if(c == 'o'){
                status ^= 0b010;
            }else if(c == 'x'){
                status ^= 0b001;
            }
            if(map[status] != -2){
                if(i-map[status] <= max){
                    max_len = Math.max(max_len, i-map[status]);
                }
            }else{
                map[status] = i;
            }
        }
        System.out.println(max_len);
    }

}
