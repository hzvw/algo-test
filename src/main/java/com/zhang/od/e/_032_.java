package com.zhang.od.e;

import java.util.Scanner;

/**
 * ClassName: _032_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/2 16:49
 * @Version 1.0
 */
public class _032_ {
    static String[] dic = {" ",",.","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static boolean isNumMode = true;
    static int delayNum = -1;
    static int delayIdx = -1;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str + "/";

        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);

            if(c == '#'){
                isNumMode = !isNumMode;
            }

            if(c == '#' || c == '/'){
                interrupt(c);
                continue;
            }else if(isNumMode){
                sb.append(c);
            }else if(c - '0' == delayNum){
                delayIdx++;
                delayIdx = delayIdx % dic[delayNum].length();
            }else{
                interrupt(c);
            }
        }
        System.out.println(sb.toString());


    }

    static void interrupt(char c){
        if(delayNum != -1){
            sb.append(dic[delayNum].charAt(delayIdx));
        }

        if(c == '#' || c == '/'){
            delayNum = -1;
            delayIdx = -1;
        }else{
            delayNum = c-'0';
            delayIdx = 0;
        }
    }




}
