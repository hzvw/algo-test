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

        List<List<String>> res = new ArrayList<>();
        for(int i =0;i<n; i++){
            for(int j = 0; j<n; j++){
                dfs(i,j,0, new LinkedList<>(), st.length(), res);
            }
        }
        if(res.size() > 0){
            System.out.println(String.join(",", res.get(0)));
        }else{
            System.out.println("N");
        }

    }

    static void dfs(int i, int j, int k, LinkedList<String> buckets, int len, List<List<String>> res){
        if(i<0 || i>=n || j<0 || j>=n || k > len){
            return;
        }
        if(buckets.size() == len){
            res.add(new ArrayList<>(buckets));
            return;
        }
        if(arr[i][j] != st.charAt(k)){
            return;
        }
        buckets.addLast(i + "," + j);
        visited[i][j] = true;

        dfs(i,j-1,k+1,buckets,len,res);
        dfs(i-1,j,k+1,buckets,len,res);
        dfs(i,j+1,k+1,buckets,len,res);
        dfs(i+1,j,k+1,buckets,len,res);


        buckets.removeLast();
        visited[i][j] = false;

    }

}
