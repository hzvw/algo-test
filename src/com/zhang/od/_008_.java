package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _008_
 * Package: com.zhang.od
 * Description:手机app防沉迷系统
 *
 * @Author Harizon
 * @Create 2025/1/14 14:04
 * @Version 1.0
 */
public class _008_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        List<App> input_list = new ArrayList<>();
        for(int i = 0; i<N; i++){
            String line = sc.nextLine();
            String[] words = line.split(" ");
            input_list.add(new App(words[0], Integer.parseInt(words[1]), convert(words[2]), convert(words[3])));
        }
        int t1 = convert(sc.nextLine());

        List<App> registered = new ArrayList<>();
        outer:
        for(int i = 0; i<N; i++){
            App app = input_list.get(i);
            if(app.start >= app.end){
                continue;
            }

            //待删除的app的列表
            List<Integer> to_delete = new ArrayList<>();
            for(int j = 0; j<registered.size(); j++){
                if(app.start>=registered.get(j).end || app.end <=registered.get(j).start){
                    continue;
                }
                if(app.i1 > registered.get(j).i1){
                    to_delete.add(j);
                }else{
                    continue outer;
                }
            }

            //清除异己
            for(int k = to_delete.size()-1; k>=0; k--){
                int index = to_delete.get(k);
                registered.remove(index);
                //registered.remove(to_delete.get(k));
            }
            registered.add(app);
        }

        String res = "NA";
        for(int i = 0; i<registered.size(); i++){
            if(t1 >=registered.get(i).start && t1 < registered.get(i).end){
                res = registered.get(i).name;
                break;
            }
        }
        System.out.println(res);
    }

    static int convert(String t){
        String[] words = t.split(":");
        return 60 * Integer.parseInt(words[0]) + Integer.parseInt(words[1]);
    }

    static class App{
        String name;
        int i1;
        int start;
        int end;

        public App(String name,int i1,int start,int end){
            this.name = name;
            this.i1 = i1;
            this.start = start;
            this.end = end;
        }
    }



}
