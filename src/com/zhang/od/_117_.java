package com.zhang.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName: _117_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/25 22:04
 * @Version 1.0
 */
public class _117_ {
    public static void main01(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();

        char[] ca = A.toCharArray();
        char[] cb = B.toCharArray();

        int i = 0;
        int j = 0;
        int cnt = 0;
        while (true) {
            char a = ca[i];
            char b = cb[j];

            if (a == b) {
                ca[i] = '#';
                i++;
                j++;
            } else {
                i++;
            }
            if (j == cb.length) {
                i = 0;
                j = 0;
                cnt++;
            }

            if (i == ca.length && j < cb.length) {
                break;
            }
        }

        System.out.println(cnt);

    }

    public static void main(String[] args) {
        p();

    }

    static void p() {
        //创建，1，通过集合
        List<Integer> arrayList = new ArrayList<>();
        Stream<Integer> stream = arrayList.parallelStream();
//
//        //2.通过数组
//        Integer[] arr = new Integer[10];
//        Stream<Integer> stream1 = Arrays.stream(arr);
//
//        System.out.println("stream.filter(x -> x > 100) = " + stream.filter(x -> x > 100));
//
//        System.out.println("stream1 = " + stream1);
//
//        System.out.printf("", stream);
//
//        stream.distinct();

        //终止操作和中间操作

        //3.通过of方法
        Stream<String> stringStream = Stream.of("a a", "b b");
        List<String> list = stringStream.flatMap(x -> Arrays.stream(x.split(" "))).collect(Collectors.toList());
        list.forEach(System.out::println);


//        System.out.println(stringStream.reduce(_117_::function4).get());

//        System.out.println(stringStream.reduce(String::concat).get());
//        System.out.println("stringStream.allMatch(_117_::function3) = " + stringStream.allMatch(_117_::function3));

//        System.out.println(stringStream.count());

//        System.out.println(stringStream.min((a, b) -> a.compareTo(b)).get());
        //stringStream.map(x-> x.toLowerCase()).flatMap(x -> Arrays.stream(x.split(" "))).forEach(System.out::println);

        //stringStream.sorted((a,b) -> b.compareTo(a)).forEach(System.out::println);

        //匹配查找
        //规约
        //


        System.out.println(Stream.of(1.1, 1.2).min(Double::compare).get());


        //1.筛选切片


        //2.映射
        //3.排序
        //收集
        //collect




    }

    static String function(String input){
        return input.toLowerCase();
    }

    static Stream<String> function2(String input){
        String[] words = input.split(" ");
        return Arrays.stream(words);
    }

    static boolean function3(String str){
        return false;
    }

    static String function4(String s1 , String s2){
        return s1+s2;
    }
}