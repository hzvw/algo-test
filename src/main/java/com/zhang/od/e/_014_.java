package com.zhang.od.e;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: _014_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/29 2:29
 * @Version 1.0
 */
public class _014_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

//        String str = "never(dont)give(run)up(f)()";
        String regex = "\\(([^()]+?)\\)";
        //\(\(^\){2,}?\)\)

        UnionSet unionSet = new UnionSet(128);

        Set<Character> set = new HashSet<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            String s = matcher.group(1);
            //System.out.println(s);
            if(s.length() < 1 ){
                continue;
            }

            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            for(int i = 0; i<cs.length; i++) {
                char c = cs[i];
                char c_up = Character.toUpperCase(c);
                char c_low = Character.toLowerCase(c);
                //括号间传递
                if(set.contains(c_up)){
                    unionSet.union(c, c_up);
                }
                if(set.contains(c_low)){
                    unionSet.union(c, c_low);
                }
                unionSet.union(cs[0], c);//括号内传递
                set.add(c);
            }
        }

        str = str.replaceAll("\\(.*?\\)", "");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            sb.append((char)unionSet.find(c));
        }
        System.out.println(sb.length() == 0 ? "0" : sb.toString());
    }

    static class UnionSet{
        int[] fa;

        public UnionSet(int n){
            fa = new int[n];
            for(int i = 0; i<n; i++){
                fa[i] = i;
            }
        }

        int find(int x){
            if(fa[x] == x){
                return fa[x];
            }else{
                return find(fa[x]);
            }
        }

        // 真的烧脑
        void union(int x, int y){
            int fa_x = find(x);
            int fa_y = find(y);

            if(fa_x <= fa_y){
                fa[fa_y] = fa_x;
            }else{
                fa[fa_x] = fa_y;
            }

        }
    }

}
