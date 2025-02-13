package com.zhang.od;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName: _082_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/21 20:48
 * @Version 1.0
 */
public class _082_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(br.readLine());

        List<String> buffer = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String str = br.readLine();
            buffer.add(str);
        }

        buffer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Long.compare(p2(o1), p2(o2));
            }
        });

        buffer.forEach(System.out::println);
    }

    static long p2(String str){
        String[] words = str.split("[:.]");
        long h = Long.parseLong(words[0]) * 1000 * 60 * 60;
        long m = Long.parseLong(words[1]) * 1000 * 60;
        long s = Long.parseLong(words[2]) * 1000;
        long ms = Long.parseLong(words[3]);

        return h + m + s + ms;
    }

}
