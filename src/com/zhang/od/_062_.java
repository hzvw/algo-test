package com.zhang.od;

import java.util.*;
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
public class _062_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        String regex = "(\\d+)(CNY|HKD|JPY|EUR|GBP|fen|cents|sen|eurocents|pence)";
        Pattern p = Pattern.compile(regex);

        Map<String, Double> map = new HashMap<>();
        map.put("CNY",100.00);
        map.put("HKD",(100.00/123)*100.00);
        map.put("JPY",(100.00/1825)*100.00);
        map.put("EUR",(100.00/14)*100.00);
        map.put("GBP",(100.00/12)*100.00);
        map.put("fen",1.00);
        map.put("cents",(100.00/123));
        map.put("sen",(100.00/1825));
        map.put("eurocents",(100.00/14));
        map.put("pence",(100.00/12));

        double sum = 0.0;
        for (String s : list) {
            Matcher m = p.matcher(s);
            while (m.find()){

                sum += Double.parseDouble(m.group(1)) * map.get(m.group(2));
            }
        }
        System.out.println((int)sum);
    }

}
