package com.zhang.od2._100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _008_
 * Package: com.zhang.od2._100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/29 3:27
 * @Version 1.0
 */
public class _008_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        App[] apps = new App[n];
        for (int i = 0; i < n; i++) {
            String[] words = sc.nextLine().split(" ");
            App app = new App(words[0], words[1], words[2], words[3]);
            apps[i] = app;
        }
        String query = sc.nextLine();// 要查询的时间
        List<App> register = new ArrayList<>();// 已经注册上的
        outer:
        for (App app : apps) {
            if(app.start.compareTo(app.end) >= 0){
                continue;
            }

            List<Integer> to_delete = new ArrayList<>();// 要删除的index
            for (int i = 0; i < register.size(); i++) {
                App t = register.get(i);
                if(app.start.compareTo(t.end)>=0 || app.end.compareTo(t.start) <= 0){
                    continue;
                }
                if(app.priority.compareTo(t.priority) > 0){
                    to_delete.add(i);
                }else{
                    continue outer;
                }

            }
            for (int j = to_delete.size()-1; j >= 0 ; j--) {
                register.remove(to_delete.get(j).intValue());
            }
            register.add(app);
        }

        for (App app : register) {
            if(query.compareTo(app.start) > 0 && query.compareTo(app.end) < 0){
                System.out.print(app.name);
                return;
            }
        }
        System.out.println("NA");


    }

    static class App{
        String name;
        String priority;
        String start;
        String end;

        public App(String name, String priority, String start, String end) {
            this.name = name;
            this.priority = priority;
            this.start = start;
            this.end = end;
        }
    }

}
