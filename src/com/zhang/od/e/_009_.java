package com.zhang.od.e;

import java.util.*;

/**
 * ClassName: _009_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/27 23:28
 * @Version 1.0
 */
public class _009_ {
    static class Node{
        String name;
        Node fa;
        List<Node> ch;

        public Node(String name, Node fa, List<Node> ch) {
            this.name = name;
            this.fa = fa;
            this.ch = ch;
        }
    }

    static class FS{
        Node root = new Node("/", null, new ArrayList<>());
        Node cur = root;

        public FS() {
        }

        void mkdir(String name){
            Node t = new Node(name, cur, new ArrayList<>());
            cur.ch.add(t);
        }

        void cd(String name){
            if(name.equals("..")){
                if(cur != root) {cur = cur.fa;}
            }else{
                for (Node node : cur.ch) {
                    if(node.name.equals(name)){
                        cur = node;
                        break;
                    }
                }


            }


        }

        String pwd(){
            List<String> list = new ArrayList<>();
            Node p = cur;
            while (p != null){
                list.add(p.name);
                p = p.fa;
            }
            Collections.reverse(list);

            StringBuilder sb = new StringBuilder("/");
            for (int i = 1; i < list.size(); i++) {
                sb.append(list.get(i));
                sb.append("/");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FS fs = new FS();
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()){
            String comm = sc.nextLine();
            list.add(comm);
        }

        String last = null;
        for (String comm : list) {
            if(comm.startsWith("mkdir")){
                String[] words = comm.split(" ");
                fs.mkdir(words[1]);
                last = "/";
            }else if(comm.startsWith("cd")){
                String[] words = comm.split(" ");
                fs.cd(words[1]);
                last = "/";
            }else{
                last = fs.pwd();
            }
        }
        System.out.println(last);

    }



}
