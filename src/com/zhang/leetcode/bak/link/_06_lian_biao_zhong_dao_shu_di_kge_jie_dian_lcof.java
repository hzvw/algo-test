package link;

import common.ListNode;

public class _06_lian_biao_zhong_dao_shu_di_kge_jie_dian_lcof {

    public ListNode getKthFromEnd(ListNode h, int k) {
        ListNode p1 = h;
        ListNode p2 = h;
        for(int i = 0; i<k; i++){
            p2 = p2.next;
        }

        while(p2 .next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
