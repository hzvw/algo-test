package com.zhang.hot100;

import java.util.HashMap;

/**
 * ClassName: _047_
 * Package: com.zhang.hot100
 * Description:
 *
 * @Author Harizon
 * @Create 2025/2/19 22:14
 * @Version 1.0
 */
public class _047_ {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = build(preorder, inorder, 0, n-1, 0, n-1);

        return root;
    }

    private TreeNode build(int[] preorder, int[] inorder, int i, int j, int k, int m) {
        if(i > j || k > m){
            return null;
        }

        int rootNum = preorder[i];
        int rootIndex = map.get(rootNum);
        TreeNode root = new TreeNode(rootNum);

        int leftLen = rootIndex - k;
        int rightLen = m - rootIndex;
        root.left = build(preorder, inorder, i+1, i+leftLen, k, rootIndex-1);
        root.right = build(preorder, inorder,j-rightLen+1 ,j,rootIndex+1, m );

        //root.right = build(preorder, inorder,i+1+leftLen ,j,rootIndex+1, m );
        return root;
    }


}
