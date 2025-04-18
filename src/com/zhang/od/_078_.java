package com.zhang.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: _078_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/21 0:45
 * @Version 1.0
 */
public class _078_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int k = sc.nextInt();

        int count = 0;
        Deque<Character> st = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            while (!st.isEmpty() && c<st.peek() && count < k){
                st.pop();
                count++;
            }
            st.push(c);
        }

        while (st.size() > num.length() - k){
            st.pop();
        }

        ArrayList<Character> list = new ArrayList<>();
        while (!st.isEmpty()){
            list.add(st.pop());
        }
        Collections.reverse(list);
        while (list.size() > 1 && list.get(0) == '0'){
            list.remove(0);
        }

        for (Character c : list) {
            System.out.print(c);
        }

    }

}
