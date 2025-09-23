package com.zhang.od.e;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _013_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/1 0:39
 * @Version 1.0
 */
public class _013_ {

    static int n;
    static char[][] arr;

    static String st;

    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        arr = new char[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i<n; i++){
            String str = sc.nextLine();
            String[] words = str.split(",");
            for(int j = 0; j<n; j++){
                arr[i][j] = words[j].charAt(0);
            }
        }
        st = sc.nextLine();
        len = st.length();
        for(int i =0;i<n; i++){
            for(int j = 0; j<n; j++){
                dfs(i,j,0);
            }
        }
        if(res.size() > 0){
            System.out.println(String.join(",", res.get(0)));
        }else{
            System.out.println("N");
        }

    }

    static int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};

    static LinkedList<String> buckets = new LinkedList<>();

    static int len;

    static List<List<String>> res = new ArrayList<>();

    static void dfs(int i, int j, int level){
        if(level == len){
            res.add(new ArrayList<>(buckets));
            return;
        }
        if(arr[i][j] != st.charAt(level)){
            return;
        }
        buckets.addLast(i + "," + j);
        visited[i][j] = true;

        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];

            if(x>=0 && x<n && y>=0 && y< n){
                dfs(x,y, level+1);
            }
        }
        buckets.removeLast();
        visited[i][j] = false;

    }

}
