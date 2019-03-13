package path_sum;

//递归 判断以左孩子为根结点 以右孩子为根节点 是否存在sum-root.val的路径
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && (sum - root.val) == 0) return true;
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
