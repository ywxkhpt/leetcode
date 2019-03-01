package merge_two_sorted_lists;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while(l2 != null){
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
