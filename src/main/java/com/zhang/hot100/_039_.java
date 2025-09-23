package com.zhang.hot100;

/**
 * ClassName: _039_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 18:39
 * @Version 1.0
 */
public class _039_ {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    boolean isSymmetric(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 != null){
            return false;
        }else if(r1 == null && r2 == null){
            return true;
        }else if(r1 != null && r2 == null){
            return false;
        }else{
            if(r1.val == r2.val){
                return isSymmetric(r1.left, r2.right) && isSymmetric(r1.right, r2.left);
            }else{
                return false;
            }
        }
    }
}
