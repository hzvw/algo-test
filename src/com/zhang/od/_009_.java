package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _009_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/14 16:01
 * @Version 1.0
 */
public class _009_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();

        List<String> buffer = new ArrayList<>();

        String[] words = input.split("-");
        int cnt0 = words[0].length();
        int cnt1 = words.length - 1;

        String s = "";
        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i) != '-'){
                s += input.charAt(i);
            }
        }

        buffer.add(words[0]);
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j <s.length()-cnt0; j++){
            sb.append(s.charAt(cnt0+j));
            if((j+1) % K == 0){
                buffer.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if(!sb.toString().equals("")){
            buffer.add(sb.toString());
        }
        for(int m = 1; m<buffer.size(); m++){
            String str = buffer.get(m);
            int i = 0;
            int j = 0;
            for(int k = 0; k<str.length(); k++){
                if(str.charAt(k)>='a' && str.charAt(k) <= 'z'){
                    i++;
                }
                if(str.charAt(k)>='A' && str.charAt(k) <= 'Z'){
                    j++;
                }
            }
            if(i>j){
                //大写转小写
                str = str.toLowerCase();
                buffer.set(m, str);
            }else if(i < j){
                //小写转大写
                str = str.toUpperCase();
                buffer.set(m, str);
            }
        }

        System.out.println(String.join("-", buffer));



    }



}
