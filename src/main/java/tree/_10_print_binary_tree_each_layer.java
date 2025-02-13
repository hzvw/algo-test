package tree;

import common.TreeNode;

import java.util.*;

public class _10_print_binary_tree_each_layer {
    //层序遍历二叉树 2020-11-25
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int x = 1;
        int y = 0;
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        while(queue.size() > 0){
            TreeNode current = queue.poll();
            TreeNode left = current.left;
            TreeNode right = current.right;

            buffer.add(current.val);
            x--;

            if(left != null){
                queue.offer(left);
                y++;
                //buffer.add(current.left.val);
            }
            if(right != null){
                queue.offer(right);
                y++;
                //buffer.add(current.right.val);
            }

            if(x == 0){
                x = y;
                y = 0;
                ret.add(buffer);
                buffer = new ArrayList<Integer>();
            }
        }

        return ret;
    }

    public int minDeletionSize (String[] A) {
        // write code here
        int count = 0;
        int row = A[0].length();
        int column = A.length;

        int[] ret = new int[row];
        for(int i = 0; i<row; i++){
            for(int j = 0; j< column-1; j++){
                if(A[j].charAt(i) > A[j+1].charAt(i)){
                    ret[i] = 1;
                    continue;
                }
            }
        }

        int index = -1;
        for(int i = 0; i<ret.length; i++){
            if(ret[i] == 0){
                index = i;
                break;
            }
        }

        if(index == -1){
            //count = ret.length;
            return ret.length;
        }

        for(int i = 0; i<=index; i++){
            if(ret[i] == 1){
                count++;
            }
        }

        System.out.println(Arrays.toString(ret));
        System.out.println(count);
        System.out.println(index);
        return count;
    }

    /**
     *
     * @param A int整型一维数组
     * @return int整型
     */
    public int maxWidth (int[] A) {
        // write code here
        for(int width = A.length-1; width>= 1; width--){
            for(int i = 0; i<A.length-width; i++){
                if(A[i] <= A[i + width]){
                    return width;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"zyx", "wvu", "tsr"};
        String[] A2 = new String[]{"xc", "yb", "za"};
        String[] A3 = new String[]{"ca", "bb", "ac"};
        int count = new _10_print_binary_tree_each_layer().minDeletionSize(A);
        System.out.println(count );
    }



}
