package com.zhang.od;

import java.util.*;

/**
 * ClassName: _015_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/14 21:59
 * @Version 1.0
 */
public class _015_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //学生人数
        int n = sc.nextInt();
        //科目个数
        int m = sc.nextInt();

        Map<String, Integer> subject_id = new HashMap<>();
        for(int i = 0 ;i<m; i++){
            subject_id.put(sc.next(), i);
        }

        int[][] A = new int[n][m+1];
        String[] stu_name = new String[n];
        for(int i = 0; i<n; i++){
            stu_name[i] = sc.next();
            int sum = 0;
            for(int j = 0; j<m; j++){
                A[i][j] = sc.nextInt();
                sum+=A[i][j];
            }
            A[i][m] = sum;
        }

        String rank_ele = sc.next();
        int rank_id = 0;
        if(subject_id.get(rank_ele) == null){
            rank_id = m;
        }else{
            rank_id = subject_id.get(rank_ele);
        }
        final int rank_id2 = rank_id;

        List<Stu> stus = new ArrayList<>();
        for(int i = 0; i<stu_name.length; i++){
            String name = stu_name[i];
            int[] arr = A[i];
            stus.add(new Stu(name, arr));
        }

        stus.sort((a,b) -> b.A[rank_id2]-a.A[rank_id2] == 0 ? a.name.compareTo(b.name) : b.A[rank_id2] - a.A[rank_id2]);
        stus.forEach(x ->System.out.print(x.name + " "));
    }


    static class Stu{
        String name;
        int[] A;

        public Stu(String name, int[] A){
            this.name = name;
            this.A = A;
        }
    }

}
