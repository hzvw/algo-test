package com.zhang.od;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: _076_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/20 23:50
 * @Version 1.0
 */
public class _076_ {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<String> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            list.add(sc.nextLine()) ;
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Long.compare(p(o1), p(o2));
            }
        });

        for(String str : list){
            System.out.println(str);
        }
    }

//    public static void main(String[] args) {
//
//        System.out.println(p("950T544M848M"));
//
//
//    }


    static HashMap<String, Integer> buffer = new HashMap<>();
    static{
        buffer.put("M", 1);
        buffer.put("G", 1024);
        buffer.put("T", 1024 * 1024);
    }

    static long p(String str){
        Pattern p = Pattern.compile("(\\d+)(M|G|T)");
        Matcher m = p.matcher(str);

        long sum = 0;
        while(m.find()){
            String d = m.group(1);
            String dw = m.group(2);

            sum += Long.parseLong(d) * buffer.get(dw);
        }
        return sum;
    }



}
