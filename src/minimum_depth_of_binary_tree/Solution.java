package minimum_depth_of_binary_tree;

public class Solution {
    public int run(TreeNode root) {
        if(root == null) return 0;
        int left = run(root.left);
        int right = run(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }
}
