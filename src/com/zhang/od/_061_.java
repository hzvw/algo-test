package com.zhang.od;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: _061_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 18:01
 * @Version 1.0
 */
public class _061_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern p = Pattern.compile("(\\d+)(CNY|HKD|JPY|EUR|GBP|fen|cents|sen|eurocents|pence)");

        HashMap<String, Double> map = new HashMap<>();
        map.put("CNY", 100.0);
        map.put("HKD", 100 / 123.0 * 100);
        map.put("JPY", 100 / 1825.0 * 100);
        map.put("EUR", 100 / 14.0 * 100);
        map.put("GBP", 100 / 12.0 * 100);
        map.put("fen", 1.0);
        map.put("cents", 100/123.0);
        map.put("sen", 100 / 1825.0);
        map.put("eurocents", 100 / 14.0);
        map.put("pence", 100 / 12.0);

        int n = sc.nextInt();
        double sum = 0.0;

        for(int i = 0; i<n; i++){
            String str = sc.next();

            Matcher m = p.matcher(str);
            while (m.find()){
                Double am = Double.parseDouble(m.group(1));
                String t = m.group(2);

                sum += am * map.get(t);
            }
        }

        System.out.println((int) sum );


    }

}
