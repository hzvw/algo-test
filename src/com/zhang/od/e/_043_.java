package com.zhang.od.e;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _043_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/2/2 22:17
 * @Version 1.0
 */
public class _043_ {

    static int M;//行数
    static int N;//列数

    static int[][] arr;

    static boolean[][] visited;

    static int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};

    static LinkedList<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            list.add(str.split(" "));
        }

        M = list.size();
        N = list.get(0).length;
        visited = new boolean[M][N];
        arr = new int[M][N];
        int bad = 0;
        int good = 0;
        for(int i = 0; i<M; i++){
            for(int j=0; j<N; j++){
                String s = list.get(i)[j];
                if(s.equals("NA")){
                    arr[i][j] = -1;
                    bad++;
                }else if(s.equals("YES")){
                    arr[i][j] = 1;
                    good++;
                }else{
                    arr[i][j] = 0;
                }
            }
        }
        if(good == 0){
            System.out.println(-1);
            return;
        }

        for(int i = 0; i<M; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == 1){
                    queue.addLast(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int count = bfs();

        int isFalse = 0;
        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++){
                if(!visited[i][j]){
                    isFalse++;
                }
            }
        }
        System.out.println(isFalse == bad ? count : -1);
    }

    static int bfs(){
        int count = 0;
        while(queue.size() > 0){
            boolean flag = false;
            LinkedList<int[]> n_queue = new LinkedList<>();
            for(int[] ints : queue){
                 int x = ints[0];
                 int y = ints[1];
                for(int[] dir : directions){
                    int n_x = x + dir[0];
                    int n_y = y + dir[1];

                    if(n_x>=0 && n_x<M&& n_y>=0 && n_y<N && !visited[n_x][n_y] && arr[n_x][n_y] == 0){
                        n_queue.addLast(new int[]{n_x,n_y});
                        visited[n_x][n_y] = true;
                        flag = true;
                    }

                }
            }
            queue = n_queue;
            if(flag){
                count++;
            }
        }
        return count;
    }
}
