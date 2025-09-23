package com.zhang.od;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _055_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 0:00
 * @Version 1.0
 */
public class _055_ {
    static int n;

    static char[] cs;

    static boolean[] visited;

    static LinkedList<Character> buckets = new LinkedList<>();

    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();

        cs = new char[n];
        for(int i = 0; i<n; i++){
            cs[i] = (char)('0' + (i+1));
        }
        visited = new boolean[n];
        dfs(0);
        res.sort((a,b) -> a.compareTo(b));
        System.out.println(res.get(k-1));
    }

    static void dfs(int level){
        if(level == n){
            res.add(buckets.stream().map(x->x+"").reduce("", String::concat));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                buckets.addLast(cs[i]);
                visited[i] = true;

                dfs(level+1);

                buckets.removeLast();
                visited[i] = false;
            }
        }

    }


}
