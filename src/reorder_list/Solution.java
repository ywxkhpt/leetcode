package reorder_list;
//分为三步
//第一步分割链表
//反转链表的后半部分
//合并两个链表

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        //第一步分割链表
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;

        //反转链表的后半部分
        ListNode l3 = reverseList(l2);

        //合并两个链表
        merge(l1,l3);
    }

    private ListNode reverseList(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        ListNode next = null;

        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode ret = l1;
        ListNode l1next = null;
        ListNode l2next = null;
        while(l1!=null && l2!=null){
            l1next = l1.next;
            l1.next = l2;
            l1 = l1next;
            l2next = l2.next;
            l2.next = l1;
            l2 = l2next;
        }

        return ret;
    }
}
