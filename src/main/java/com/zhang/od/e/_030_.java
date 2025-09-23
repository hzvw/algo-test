package com.zhang.od.e;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * ClassName: _030_
 * Package: com.zhang.od.e
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/2 15:32
 * @Version 1.0
 */
public class _030_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> collect = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        collect.sort((a,b) -> -((a+"") + (b+"")).compareTo((b+"")+(a+"")));

        String res = collect.stream().map(x -> x + "").reduce("", String::concat);
        System.out.println(res.replaceAll("^0+", "0"));

        //
//        String[] ints = new String[10];
//        Arrays.sort(ints, (a,b) -> a.compareTo(b));

//        Integer[] arr = new Integer[10];
//        Arrays.sort(arr, (a,b)->a.compareTo(b));
    }

}
