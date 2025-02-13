package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _040_1_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/3 18:51
 * @Version 1.0
 */
public class _040_1_ {
     //匈牙利算法
    static boolean[][] arr ;
    static int m = 0;
    static int n = 0;

    static boolean[] visited;

    static int[] match;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        m = sc.nextInt();//女
        n = sc.nextInt();//男
        arr = new boolean[m][n];

        for(int i = 0; i<k; i++){
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            arr[x][y] = true;
        }


        //match是循环外的
        match = new int[n];

        Arrays.fill(match, -1);

        int result = 0;
        for(int i = 0; i<m; i++){
            // visited是循环内的
            visited = new boolean[n];
            Arrays.fill(visited, false);
            boolean flag = dfs(i);
//            if(flag){
//                result++;
//            }
        }
        for(int ele : match){
            if(ele != -1){
                result++;
            }
        }

        System.out.println(result);
    }

    // 给第i个女生找对象，找对象算法
    static boolean dfs(int i){
        // 从m个男生里面找
        for(int j = 0; j<n; j++){
            //两个人互相还有好感
            if(arr[i][j] && !visited[j]){
                visited[j] = true;

                //如果这个男生还没对象，或者说有对象，但是其现在的对象能找到他之外的人配对
                if(match[j] == -1 || dfs(match[j])){
                    match[j] = i;

                    System.out.println(i + "找到了"+j);
                    return true;//找到了一个，拜拜
                }
            }
        }
        return false;
    }
}

//6 3 3
//1 1
//1 2
//1 3
//2 1
//2 3
//3 1
//0
