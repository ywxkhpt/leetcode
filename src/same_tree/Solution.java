package same_tree;

//递归 比较根的值是否相等 比较左子树 比较右子树
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p,q);
    }

    private boolean helper(TreeNode p, TreeNode q){
        if(p == null || q == null) return p == q;
        if(p.val != q.val) return false;
        return helper(p.left,q.left) && helper(p.right,q.right);
    }
}
