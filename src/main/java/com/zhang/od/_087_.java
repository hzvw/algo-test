package com.zhang.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: _087_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/22 1:18
 * @Version 1.0
 */
public class _087_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                sb.append(c);
            }
            if(c>='A' && c<='Z'){
                sb.append(c);
            }
        }
        str = sb.toString().toLowerCase();

        int[] count = new int[123];
        char[] cs = str.toCharArray();
        for(int i = 0 ;i<cs.length; i++){
            count[cs[i]]++;
        }

        int last_cnt = 1;
        char last_c = cs[0];
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cs[0]);
        count[cs[0]]--;
        for(int i = 1; i<cs.length; i++){
            char c = cs[i];
            count[c]--;
            if(c == last_c){
                last_cnt++;
            }else{
                if(last_cnt > 1){
                    sb2.append(last_cnt);
                }else{
                    sb2.append(count[last_c]);
                }
                sb2.append(c);
                last_cnt = 1;
                last_c = c;
            }
        }
        if(last_cnt > 1){
            sb2.append(last_cnt);
        }else{
            sb2.append(count[last_c]);
        }
        //System.out.println(sb2.toString());

        Pattern pattern = Pattern.compile("([a-z])(\\d+)");
        Matcher matcher = pattern.matcher(sb2.toString());

        List<P> buffer = new ArrayList<>();
        while(matcher.find()){
            String c = matcher.group(1);
            Integer cnt = Integer.parseInt(matcher.group(2));
            buffer.add(new P(c, cnt));
        }

        buffer.sort(new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                if(o1.cnt == o2.cnt){
                    return o1.c.compareTo(o2.c);
                }else{
                    return o2.cnt - o1.cnt;
                }
            }
        });

        buffer.forEach(x-> System.out.print(x.c + x.cnt));

    }

    static class P{
        String c;
        int cnt;
        public P(String c, int cnt){
            this.c = c;
            this.cnt = cnt;
        }
    }

}
