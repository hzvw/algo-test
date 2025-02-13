package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: _081_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/21 20:18
 * @Version 1.0
 */
public class _081_ {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");

        if(arr.length > 999){
            System.out.println("ERROR");
            return;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int last_class = 1;
        int last_id = Integer.parseInt(arr[0].split("/")[0]);
        list1.add(last_id);

        String YN_1 = arr[0].split("/")[1];
        if(!"N".equals(YN_1)){
            System.out.println("ERROR");
            return;
        }

        for(int i = 1; i<arr.length; i++){
            String str = arr[i];
            String[] words = str.split("/");
            if(words.length != 2){
                System.out.println("ERROR");
                return;
            }

            int id = Integer.parseInt(words[0]);

            if(id <0 || id > 999){
                System.out.println("ERROR");
                return;
            }

            String YN = words[1];

            if(!(YN.equals("Y") || YN.equals("N"))){
                System.out.println("ERROR");
                return;
            }

            if(YN.equals("Y") && last_class == 1){
                list1.add(id);
                last_class = 1;
                last_id = id;
            }else if(YN.equals("Y") && last_class == 2){
                list2.add(id);
                last_id = id;
                last_class = 2;
            }else if(YN.equals("N") && last_class == 1){
                list2.add(id);
                last_id = id;
                last_class = 2;
            }else{
                // N 2
                list1.add(id);
                last_id = id;
                last_class = 1;
            }
        }

        list1.sort((a,b)->a-b);
        list2.sort((a,b)->a-b);

        if(list1.size() == 0){
            List<Integer> t = list1;
            list1 = list2;
            list2 = t;
        }

        if(list1.size() != 0 && list2.size() != 0){
            int i1 = list1.get(0);
            int i2 = list2.get(0);
            if(i1 < i2){

            }else{
                List<Integer> t = list1;
                list1 = list2;
                list2 = t;
            }
        }

        for(int i = 0; i<list1.size(); i++){
            System.out.print(list1.get(i));
            if(i != list1.size()-1){
                System.out.print(" ");
            }
        }
        System.out.println();

        for(int i = 0; i<list2.size(); i++){
            System.out.print(list2.get(i));
            if(i != list2.size()-1){
                System.out.print(" ");
            }
        }
        System.out.println();

    }

}
