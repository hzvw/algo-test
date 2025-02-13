package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _067_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 21:43
 * @Version 1.0
 */
public class _067_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        try{
            System.out.println(p(str));
        }catch(Exception e){
            System.out.println("invalid IP");
        }
    }

    static long p(String str) throws Exception{
        String[] words = str.split("#");
        if(words.length != 4){
            throw new Exception();
        }

        int[][] ab = new int[][]{{1,128},{0,255},{0,255},{0,255}};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<4; i++){
            if(words[i].length() > 1 && words[i].startsWith("0")){
                throw new Exception();
            }
            int val = Integer.parseInt(words[i]);

            if(val < ab[i][0] || val > ab[i][1]){
                throw new Exception();
            }
            String s = String.format("%2s", Integer.toHexString(val)).replace(" ", "0");
            sb.append(s);
        }
        return Long.parseLong(sb.toString(), 16);
    }

}
