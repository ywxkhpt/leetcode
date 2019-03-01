package convert_sorted_list_to_binary_search_tree;
//将排序的链表转化为二叉搜索树
public class Solution {
    //递归实现 考察链表的二分查找
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return toBST(head,null);
    }

    public TreeNode toBST(ListNode head,ListNode tail){//二分查找
        if(head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head,slow);
        root.right = toBST(slow.next,tail);
        return root;
    }

}
