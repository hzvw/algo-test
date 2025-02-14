package tree;

import common.TreeNode;

import java.util.*;

/*什么玩意，花里胡哨的2022-01-24 23:35*/
public class _29_find_duplicate_subtrees {
    Map<Integer,TreeNode> map = new HashMap<Integer, TreeNode>();
    List<TreeNode> res = new ArrayList<TreeNode>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode r){
        if(r == null) return;
        if(map.containsKey(r.val)){
            if(isSame(r,map.get(r.val))){
                res.add(r);
            }
        }else{
            map.put(r.val, r);
        }
        traverse(r.left);
        traverse(r.right);
    }

    boolean isSame(TreeNode r1,TreeNode r2){
        if(r1 == null && r2 == null){
            return true;
        }else if(r1 != null && r2 == null){
            return false;
        }else if(r1 == null && r2 != null){
            return false;
        }else if(r1 != null && r2 != null){
            return r1.val == r2.val &&
                    isSame(r1.left,r2.left) && isSame(r1.right,r2.right);
        }
        return false;
    }

}
