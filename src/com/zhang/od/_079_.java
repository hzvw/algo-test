package com.zhang.od;

import java.util.*;

/**
 * ClassName: _079_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/21 17:11
 * @Version 1.0
 */
public class _079_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int size = arr.length;

        List<String> buffer = new ArrayList<>();
        if(size <=3 ){
            for(int i = 0; i<size; i++){
                buffer.add(arr[i] + "");
            }
        }else{
            for(int i = 0; i<3; i++){
                buffer.add(arr[i] + "");
            }
        }

        buffer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        for(String s : buffer){
            System.out.print(s);
        }

    }





}
