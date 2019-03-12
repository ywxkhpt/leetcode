package binary_tree_maximum_path_sum;

//递归函数返回值定义为以当前结点为根结点，到叶节点的最大路径之和.
//在递归函数中，如果当前结点不存在，那么直接返回0。否则就分别对其左右子节点调用递归函数，
//由于路径和有可能为负数，而我们当然不希望加上负的路径和，
//所以我们和0相比，取较大的那个，就是要么不加，加就要加正数。
//在递归过程中还需要不断比较最大值和横跨结点左右结点的路径值 并更新最大值
public class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        pathDown(root);
        return max;
    }

    public int pathDown(TreeNode root){//递归函数
        if(root == null) return 0;
        int left = Math.max(pathDown(root.left),0);
        int right = Math.max(pathDown(root.right),0);
        max = Math.max(left + right + root.val,max);
        return Math.max(left,right) + root.val;
    }
}
