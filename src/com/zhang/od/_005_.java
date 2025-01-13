package com.zhang.od;

import java.util.Scanner;

/**
 * ClassName: _005_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/14 0:03
 * @Version 1.0
 */
public class _005_ {
    public static void main(String[] args) {
        //System.out.println(Integer.parseInt("11", 16));;
        Scanner sc = new Scanner(System.in);
        String tag = sc.nextLine();
        String input = sc.nextLine();

        String[] words = input.split(" ");
        for(int i = 0; i<words.length; ){
            //System.out.println(i);
            String t = words[i];
            int len = Integer.parseInt(words[i+2] + words[i+1], 16);
            //System.out.println("len = " + len);
            int j = i +3;
            if(words[i].equals(tag)){
                for(int k = j; k<j+len; k++){
                    System.out.print(words[k] + " ");
                }
                System.out.println();
            }
            i += len + 3;
        }



    }

}
