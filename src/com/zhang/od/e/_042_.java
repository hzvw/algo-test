package com.zhang.od.e;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ClassName: _042_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/2 19:24
 * @Version 1.0
 */
public class _042_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        str = str;

        LinkedList<String> charStack = new LinkedList<>();
        LinkedList<String> numStack = new LinkedList<>();

        String num = "";
        String seq = "";
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if(Character.isDigit(c)){
                num += c;
            }else if(c =='['){
                numStack.addLast(num);
                num = "";
                if(!seq.equals("")){
                    charStack.addLast(seq);
                    seq = "";
                }
            }else if(c == ']'){
                if(!seq.equals("")){
                    charStack.addLast(seq);
                    seq = "";
                }
                int x = Integer.parseInt(numStack.removeLast());
                String y = charStack.removeLast();
                String tmp = "";
                for (int j = 0; j < x; j++) {
                    tmp += y;
                }
                charStack.addLast((!charStack.isEmpty() ? charStack.removeLast() : "") + tmp);
            }else{
                seq += c;
            }
        }
        System.out.println(charStack.removeLast());
    }

}
