### 数组链表
### 栈/队列
### 数据结构设计
### 二叉树
1.二叉树的最小深度
```java
int run(TreeNode root){
	if(root == null){
	    return 0;
	}
	if(root.left == null && root.right == null){
	    return 1;
	}else if(root.left != null && root.right == null){
	    return 1 + run(root.left);
	}else if(root.left == null && root.right != null){
	    return 1 + run(root.right);
	}else {
	    return 1 + Math.min(run(root.left), run(root.right));
	}
}
```
2.二叉树的后序遍历，迭代写法
```java
public ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    if(root == null){
        return ret;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while(!stack.empty()){
        TreeNode node = stack.pop();
        ret.add(node.val);

        if(node.left != null){
            stack.push(node.left);
        }
        if(node.right != null){
            stack.push(node.right);
        }
    }

    Collections.reverse(ret);
    return ret;
}
```
3.二叉树的先序遍历，迭代写法
```
public ArrayList<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if(root == null){
        return ret;
    }

    stack.push(root);
    while(!stack.empty()){
        TreeNode n = stack.pop();
        ret.add(n.val);
        // 先放右子树再放左子树
        if(n.right != null){
            stack.push(n.right);
        }
        if(n.left != null){
            stack.push(n.left);
        }
    }
    return ret;
}
```

### 二叉搜索树
### DFS
### BFS
### 回溯
### 动规
### 数学问题


