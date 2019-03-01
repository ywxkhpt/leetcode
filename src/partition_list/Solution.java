package partition_list;

public class Solution {
    //使用两个链表一个连接小于的 一个链接大于等于的
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode pre1 = dummy1;
        ListNode pre2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                pre1.next = head;
                head = head.next;
                pre1 = pre1.next;
            } else {
                pre2.next = head;
                head = head.next;
                pre2 = pre2.next;
            }
        }
        pre2.next = null;
        pre1.next = dummy2.next;
        dummy2 = null;
        return dummy1.next;
    }
}