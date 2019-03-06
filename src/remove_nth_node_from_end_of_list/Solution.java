package remove_nth_node_from_end_of_list;

//双指针
//快指针先走n + 1步 然后两个指针同时走 当快指针到达末尾的时候 慢指针指向要删除结点的前一个结点
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int count = 0;
        while(count < n){
            fast = fast.next;
            count++;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode now = slow.next;
        slow.next = slow.next.next;
        now.next = null;
        return dummy.next;
    }
}
