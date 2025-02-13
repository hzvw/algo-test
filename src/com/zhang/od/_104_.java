package com.zhang.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: _104_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/23 22:31
 * @Version 1.0
 */
public class _104_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        Pattern p = Pattern.compile("\\((.*?)\\)");
        Matcher m = p.matcher(line);

        List<String> buffer = new ArrayList<>();
        while(m.find()){
            buffer.add(m.group(1));
        }

        //buffer.stream().forEach(System.out::println);

        int max_dis = 0;
        int m_x = 0;
        int m_y = 0;
        for(String str : buffer){
            String[] words = str.split(",");
            if(words[0].length() > 1 && words[0].startsWith("0")){
                continue;
            }
            if(words[1].length() > 1 && words[1].startsWith("0")){
                continue;
            }

            int x = Integer.parseInt(words[0]);
            int y = Integer.parseInt(words[1]);
            if(x <= 0 || x>= 1000 || y <= 0 || y >= 1000){
                continue;
            }

            int dis = x * x + y * y;
            if(dis > max_dis){
                max_dis = dis;
                m_x = x;
                m_y = y;
            }
        }
        System.out.println("(" + m_x + "," + m_y + ")");


    }


}
