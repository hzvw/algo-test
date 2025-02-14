package tree;

import java.util.*;
import common.TreeNode;

public class _26_er_cha_sou_suo_shu_de_di_kda_jie_dian_lcof {
    List<Integer> buffer = new ArrayList<Integer>();

    public int kthLargest(TreeNode r, int k) {
        in_order(r);
        return buffer.get(buffer.size()-k);
    }

    void in_order(TreeNode r){
        if(r == null){
            return;
        }
        in_order(r.left);
        buffer.add(r.val);
        in_order(r.right);
    }

}
