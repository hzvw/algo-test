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

        //Set<String> set = new HashSet<>();
        HashMap<String, P> map = new HashMap<>();
        for(String s : words1){
            String[] t = s.split(",");
            String stu_id = t[0];
            int score1 = Integer.parseInt(t[1]);

            //set.add(stu_id);
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

        buffer.sort(new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                if(o1.score1 + o1.score2 > o2.score1 + o2.score2){
                    return -1;
                }else if(o1.score1 + o1.score2 == o2.score1 + o2.score2){
                    return o1.stu_id.compareTo(o2.stu_id);
                }else{
                    return 1;
                }
            }
        });

        List<Integer> tmp = new ArrayList<>();
        String clazz1 = buffer.get(0).clazz;
        String clazz2 = null;
        for(int i = 0; i<buffer.size();i++){
            if(!clazz1.equals(buffer.get(i).clazz)){
                clazz2 = buffer.get(i).clazz;
                tmp.add(i);
            }
        }




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
