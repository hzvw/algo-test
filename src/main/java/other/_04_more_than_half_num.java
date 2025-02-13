package other;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 *
 */
import java.util.*;

public class _04_more_than_half_num {
    public int MoreThanHalfNum_Solution(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : A){
            if(!map.containsKey(i)){
                map.put(i, 1);
            }else{
                int value = map.get(i);
                map.put(i, value+1);
            }
        }
        Set<Integer> set = map.keySet();
        for(int i : set){
            if(map.get(i) > A.length / 2){
                return i;
            }
        }

        return 0;
    }

}
