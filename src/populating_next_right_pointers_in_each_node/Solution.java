package populating_next_right_pointers_in_each_node;


//完全二叉树 所有叶子结点都在同一层，
//记录每一层的最开始结点，每一层逐个更新结点的next指针，直到末尾（上层节点的下一个结点为空）
//更新每一层的开始结点，是上一层开始结点的左孩子
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode cur = root;//上一层结点
        while(cur.left != null){ //判断是否更新完毕
            TreeLinkNode leftTreeLinkNode = cur;//用来更新开始结点
            while(cur != null){//当前层是否更新完毕
                cur.left.next = cur.right;
                if(cur.next != null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            cur = leftTreeLinkNode.left;
        }
    }
}