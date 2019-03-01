package remove_duplicates_from_sorted_list;
//去重 重复的留一个

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next; //目前节点指向 目前结点的下一个的下一个
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
