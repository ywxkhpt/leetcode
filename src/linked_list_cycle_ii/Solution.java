package linked_list_cycle_ii;

public class Solution {
    //第一步 设置快慢指针 找到在环上的相遇点 如果快指针到达了末尾 则没有环
    //第二步 一个指针又头开始 另一个指针从相遇点开始 同步向前 再次相遇就是环的起始点
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slowOther = head;
                while (slow != slowOther) {
                    slow = slow.next;
                    slowOther = slowOther.next;
                }
                return slow;
            }
        }
        return null;
    }
}
