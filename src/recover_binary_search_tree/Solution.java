package recover_binary_search_tree;
//搜索二叉树中的两个元素位置错误 在不改变二叉搜索树的结构的前提下 恢复二叉搜索树
//利用二叉搜索树的中序遍历的有序性
//错误的二叉搜索树如下：6, 3, 4, 5, 2
//主要任务是在中序遍历的过程中找到两个错误的元素 并交换他们的值 第一个错误位置是比后面的元素大的位置
//第二个错误位置是比前面小的位置
public class Solution {
    TreeNode preTreeNode = new TreeNode(Integer.MIN_VALUE);//初始化
    TreeNode firstTreeNode = null;
    TreeNode secondTreeNode = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = firstTreeNode.val;
        firstTreeNode.val = secondTreeNode.val;
        secondTreeNode.val = temp;
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);

        //找到错误的位置
        if(firstTreeNode == null && preTreeNode.val > root.val){
            firstTreeNode = preTreeNode;
        }
        if(firstTreeNode != null && preTreeNode.val > root.val){
            secondTreeNode = root;
        }
        preTreeNode = root;
        //
        inorder(root.right);
    }
}
