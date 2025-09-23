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
        int n = Integer.parseInt(sc.nextLine());
        List<App> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] words = sc.nextLine().split(" ");
            list.add(new App(words[0], Integer.parseInt(words[1]), words[2], words[3]));
        }

        String time = sc.nextLine();
        List<App> registered = new ArrayList<>();

        outer:
        for (int i = 0; i < n; i++) {
            App app = list.get(i);
            if(app.start.compareTo(app.end) >= 0){
                continue;
            }

            List<Integer> to_delete = new ArrayList<>();
            for (int j = 0; j < registered.size(); j++) {
                if(app.end.compareTo(registered.get(j).start) <= 0 || app.start.compareTo(registered.get(j).end) >= 0){
                    continue;
                }
//                if(app.priority <= registered.get(j).priority){
//                    continue outer;
//                }
//                to_delete.add(j);
                if(app.priority > registered.get(j).priority){
                    to_delete.add(j);
                }else{
                    continue outer;
                }
            }
            for (int j = to_delete.size()-1; j >= 0 ; j--) {
                registered.remove(to_delete.get(j).intValue());
                //int index = to_delete.get(j);
                //registered.remove(index);
            }
            registered.add(app);
        }
        for (App app : registered) {
            if(app.start.compareTo(time) <= 0 && app.end.compareTo(time) > 0){
                System.out.println(app.name);
                return;
            }
        }
        System.out.println("NA");
    }

    static class App{
        String name;
        int priority;
        String start;
        String end;

        public App(String name, int priority, String start, String end) {
            this.name = name;
            this.priority = priority;
            this.start = start;
            this.end = end;
        }
    }



}
