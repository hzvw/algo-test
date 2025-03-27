package com.zhang.od.e;

import java.util.*;
import java.util.stream.Stream;

/**
 * ClassName: _008_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/27 3:48
 * @Version 1.0
 */
public class _008_ {
    static List<String> res = new ArrayList<>();
    static boolean[] visited;
    static LinkedList<Character> buckets = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        String s = words[0];
        int n = Integer.parseInt(words[1]);
        visited = new boolean[s.length()];
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if(!Character.isLowerCase(cs[i])){
                System.out.println(0);
                return;
            }
        }

        Arrays.sort(cs);
        dfs(0, n, cs, -1);

        System.out.println(res.size());
    }

    static void dfs(int level, int n, char[] cs, int pre){
        if(level == n){
            res.add((buckets.stream().map(x-> x+"").reduce("", String::concat)));
            return;
        }

        for (int i = 0; i < cs.length; i++) {
            if(visited[i]){
                continue;
            }
            // 相同的字符不能相邻
            if(pre >= 0 && cs[i] == cs[pre]){
                continue;
            }

            // 树层去重（去除重复排列）
            if(i-1>= 0 && cs[i-1] == cs[i] && !visited[i-1]){
                continue;
            }

            buckets.addLast(cs[i]);
            visited[i] = true;

            dfs(level+1, n, cs, i);

            buckets.removeLast();
            visited[i] = false;

        }


    }



}
