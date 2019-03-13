package balanced_binary_tree;

//平衡二叉树 结点的子节点的深度差不会超过1
//递归
//以A为根结点的树 不是平衡二叉树包括一下几个方面
//(1) 左子树不是平衡二叉树
//(2) 右子树不是平衡二叉树
//(3) 左右子树的高度差超过了1
//实现一个辅助函数 当不是平衡树的时候返回-1 当是平衡树的时候返回树的高度
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return height(root) != -1;
    }

    private int height(TreeNode root){
        if(root == null) return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        if(lheight == -1){
            return -1;
        }
        if(rheight == -1){
            return -1;
        }
        return Math.abs(lheight - rheight) > 1 ? -1 : Math.max(lheight,rheight) + 1;
    }
}
