package validate_binary_search_tree;

//利用中序遍历的有序性
//发现前面元素不小于后面元素 则设置标志位为false
public class Solution {
    TreeNode preTreeNode = new TreeNode(Integer.MIN_VALUE);//初始化
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);

        //找到错误的位置
        if(preTreeNode.val >= root.val){
            flag = false;
        }
        preTreeNode = root;
        //
        inorder(root.right);
    }
}
