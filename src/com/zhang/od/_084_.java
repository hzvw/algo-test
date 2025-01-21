package com.zhang.od;

import java.util.LinkedList;

/**
 * ClassName: _084_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/21 22:39
 * @Version 1.0
 */
public class _084_ {
    public static void main01(String[] args) {
        String s = "1+2-3-4";

        s = "(" + s + ")";

        LinkedList<Integer> stack1 = new LinkedList<>();//数字栈
        LinkedList<Character> stack2 = new LinkedList<>();//符号栈

        char[] cs = s.toCharArray();
        for(int i = 0; i<cs.length; i++){
            char c = cs[i];
            if(c >='0' && c<='9'){// 是数字
                int j = i;
                StringBuilder sb = new StringBuilder();
                while(j<cs.length && cs[j] >= '0' && cs[j] <= '9'){
                    sb.append(cs[j]);
                    j++;
                }
                stack1.addLast(Integer.parseInt(sb.toString()));
                i = j-1;
            }else if(c == '('){//
                stack2.addLast(c);
            } else if(c == ')'){
                while(!stack2.isEmpty()){
                    char c2 = stack2.removeLast();
//                    char c2 = stack2.getLast();
                    if(c2 != '('){
                        int i1 = stack1.removeLast();
                        int i2 = stack1.removeLast();
                        if(c2 == '+'){
                            stack1.addLast(i1+i2);
                        }else{
                            stack1.addLast(i2-i1);
                        }
                    }
                }
            }else{
                // 加减号
                stack2.addLast(c);
            }
        }
        System.out.println(stack1.removeLast());
    }

    // 优先级
    static int p(char c){
        if(c == '*' || c == '/'){
            return 100;
        }else{
            return 1;
        }
    }







}
