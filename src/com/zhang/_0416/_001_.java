package com.zhang._0416;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: _001_
 * Package: com.zhang._0416
 * Description:
 *
 * @Author Harizon
 * @Create 2025/4/16 20:53
 * @Version 1.0
 */
public class _001_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        long res = 0l;
        String reg = "[0-9+\\-\\*]+";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);

        List<String> list = new ArrayList<>();
        while (m.find()){
            String s = m.group();

            if(list.size() > 0 && list.get(0).length() < s.length()){
                list.clear();
                list.add(s);
            }else{
                list.add(s);
            }
        }

        String s = list.get(0);
//        System.out.println((int)'*');//42
//        System.out.println((int)'+');//43
//        System.out.println((int)'-');//45
        System.out.println("s = " + s);
        try{
            res = calc(s);
            //System.out.println(s);
        System.out.println(res);
        }catch(Exception e){
            System.out.println(0);
        }

    }

    static int calc(String str){


        return 0;
    }

    static int calc01(String str) throws Exception{
        str += "$";

        int res = 0;
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();

        String num = "";
        int i = 0;
        while (i < str.length()){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                num += c;
            }else{
                if(!"".equals(num)){
                    nums.push(Integer.parseInt(num));
                    num = "";
                }

                if(c == '*'){
                    ops.push(c);
                }else{
                    if(!ops.isEmpty() && ops.peek() == 42){
                        ops.pop();
                        int a = nums.pop();
                        int b = nums.pop();
                        nums.push(a*b);
                    }

                    if(nums.size() >= 2){
                        int a = nums.pop();
                        int b = nums.pop();
                        if(c == 43){
                            nums.push(a+b);
                        }else{
                            nums.push(b-a);
                        }
                    }


                }
            }
            i++;
        }
        res = nums.peek();

        return res;
    }



}
