package tree;

import common.TreeNode;

public class _30_serialize_and_deserialize_binary_tree {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        pre_order(root, sb);
        return sb.toString();
    }

    public void pre_order(TreeNode r, StringBuilder sb){
        if(r == null){
            sb.append("#");
            return;
        }
        sb.append(r.val + ",");
        pre_order(r.left,sb);
        pre_order(r.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));


        return null;
    }

}
