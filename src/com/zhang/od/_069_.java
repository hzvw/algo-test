package com.zhang.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: _069_
 * Package: com.zhang.od
 * Description:
 *
 * @Author Harizon
 * @Create 2025/1/19 23:28
 * @Version 1.0
 */
public class _069_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> map = new HashMap<>();

        while(sc.hasNextLine()){
            String line = sc.nextLine();

            try{
                int n = Integer.parseInt(line);
                List<String> buffer = map.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o1.getValue() == o2.getValue()){
                            return o1.getKey().compareTo(o2.getKey());
                        }else if(o1.getValue() > o2.getValue()){
                            return -1;
                        }else{
                            return 1;
                        }
                    }
                }).limit(n).map(x -> x.getKey()).collect(Collectors.toList());
                System.out.println(String.join(",", buffer));
            }catch(Exception e){
                map.put(line, map.getOrDefault(line , 0) + 1);
            }

//            Integer.compare();
        }

    }

}
