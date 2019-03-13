package symmetric_tree;

//递归
//都为空 一个为空 一个不为空
//都不为空比较值是否相等
//比较左右 右左
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode left,TreeNode right){
        if(left == null || right == null) return left == right;
        if(left.val != right.val) return false;
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
