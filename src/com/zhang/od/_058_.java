package com.zhang.od;

import java.util.*;

/**
 * ClassName: _058_
 * Package: com.zhang.od
 * Description:
 *
 * @Author 张汉至
 * @Create 2025/1/19 1:57
 * @Version 1.0
 */
public class _058_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        String[] words1 = s1.split(";");
        String[] words2 = s2.split(";");

        HashMap<String, P> map = new HashMap<>();
        for(String s : words1){
            String[] t = s.split(",");
            String stu_id = t[0];
            int score1 = Integer.parseInt(t[1]);

            map.put(stu_id, new P(stu_id.substring(0, 5), stu_id, score1, 0));;
        }

        List<P> buffer = new ArrayList<>();
        for(String s : words2){
            String[] t = s.split(",");
            String stu_id = t[0];
            int score2 = Integer.parseInt(t[1]);

            if(map.keySet().contains(stu_id)){
                P p = map.get(stu_id);
                p.score2 = score2;

                buffer.add(p);
            }
        }
        if(buffer.size() == 0){
            System.out.println("NULL");
            return ;
        }


        buffer.sort(new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                if(o1.clazz.equals(o2.clazz) ){
                    if(o1.score1 + o1.score2 == o2.score1 + o2.score2){
                        return o1.stu_id.compareTo(o2.stu_id);
                    }else if(o1.score1 + o1.score2 > o2.score1 + o2.score2){
                        return -1;
                    }else{
                        return 1;
                    }
                }else{
                    return o1.clazz.compareTo(o2.clazz);
                }


            }
        });

        List<Integer> tag = new ArrayList<>();
        tag.add(0);
        String last_clazz = buffer.get(0).clazz;
        for(int i = 0; i<buffer.size(); i++){
            if(!buffer.get(i).clazz.equals(last_clazz)){
                last_clazz = buffer.get(i).clazz;
                tag.add(i);
            }
        }

        tag.add(buffer.size());

        for(int i = 0; i<tag.size()-1; i++){
            int start = tag.get(i);
            int end = tag.get(i+1);

            List<P> i1 = buffer.subList(start, end);

            if(i1.size() != 0){
                my_print(i1);
            }
        }
    }

    static void my_print(List<P> i1){
        System.out.println(i1.get(0).clazz);
        for(int i = 0; i<i1.size(); i++){
            P p = i1.get(i);
            System.out.print(p.stu_id);
            if(i != i1.size()-1){
                System.out.print(";");
            }
        }
        System.out.println();
    }

    static class P{
        String clazz;
        String stu_id;
        int score1;
        int score2;

        public P(String clazz, String stu_id, int score1, int score2){
            this.clazz = clazz;
            this.stu_id = stu_id;
            this.score1 = score1;
            this.score2 = score2;
        }

    }


}
