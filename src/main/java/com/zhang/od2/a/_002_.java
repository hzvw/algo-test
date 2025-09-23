package com.zhang.od2.a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _002_
 * Package: com.zhang.od2.a
 * Description:
 *
 * @Author Harizon
 * @Create 2025/3/31 16:34
 * @Version 1.0
 */
public class _002_ {
    static int version = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<LinkedList<File>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new LinkedList<>());
        }
        for (int i = 0; i < n; i++) {
            String command = sc.next();

            if(command.equals("IN")){
                int id = sc.nextInt();
                int priority = sc.nextInt();

                version++;
                File f = new File(version, priority);
                list.get(id-1).add(f);
                list.get(id-1).sort((a,b) -> a.priority != b.priority ? b.priority- a.priority : a.version - b.version);
            }else{
                int id = sc.nextInt();
                if(!list.get(id-1).isEmpty()){
                    System.out.println(list.get(id-1).removeFirst().version);
                }else{
                    System.out.println("NULL");
                }
            }
        }

    }

    static class File{
        int version;
        int priority;

        public File(int version, int priority) {
            this.version = version;
            this.priority = priority;
        }
    }

}
