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


    static class TreeNode{
        String dir;
        TreeNode fa;

        List<TreeNode> ch = null;

        public TreeNode(String dir, TreeNode fa, List<TreeNode> ch) {
            this.dir = dir;
            this.fa = fa;
            this.ch = ch;
        }
    }

    static class FS{
        TreeNode root = new TreeNode("/", null, new ArrayList<>());

        TreeNode cur = null;

        public FS() {
            cur = root;
        }

        public void mkdir(String dir_name){
            TreeNode t = new TreeNode(dir_name + "", cur, new ArrayList<>());
            cur.ch.add(t);
        }

        public void cd(String dir_name){
            if(dir_name.equals("..")){
               cur = cur.fa;
            }else{
                for(TreeNode treeNode : cur.ch){
                    if(dir_name.equals(treeNode.dir)){
                        cur = treeNode;
                        break;
                    }
                }
            }
        }

        public void pwd(){
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addFirst(cur);

            List<String> names = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode t = queue.removeLast();

                names.add(t.dir);
                TreeNode fa = t.fa;
                if(fa != null){
                    queue.addFirst(fa);
                }
            }
            Collections.reverse(names);
            StringBuilder sb = new StringBuilder("/");
            for(int i = 1; i<names.size(); i++){
                sb.append(names.get(i) + "/");
            }
            System.out.print(sb.toString());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> commands = new ArrayList<>();
        while(sc.hasNextLine()){
            commands.add(sc.nextLine());
        }

        FS fs = new FS();
        for(String command : commands){
            if(command.startsWith("mkdir")){
                String[] words = command.split(" ");
                fs.mkdir(words[1]);
            }else if(command.startsWith("cd")){
                String[] words = command.split(" ");
                fs.cd(words[1]);
            }else{
                fs.pwd();
            }
        }
    }

}
