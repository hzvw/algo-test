package com.zhang.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: _082_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/22 0:41
 * @Version 1.0
 */
public class _082_ {
    public static void main(String[] args) {
        new _082_().generate(5);

    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> last_list = new ArrayList<>();
        last_list.add(1);
        res.add(last_list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 0; j < i-1; j++) {
                int left = j;
                int right = j+1;
                list.add(last_list.get(left) + last_list.get(right));
            }
            list.add(1);
            res.add(list);
            last_list = list;
        }

//        for (List<Integer> list : res) {
//            for (Integer ele : list) {
//                System.out.print(ele + " ");
//            }
//            System.out.println();
//        }
        return res;
    }
}
