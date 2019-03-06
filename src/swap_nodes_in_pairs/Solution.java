package swap_nodes_in_pairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        int count = 0;
        ListNode cur = head;
        while(cur != null && count < 2){//找出第3个结点
            cur = cur.next;
            count++;
        }
        if(count == 2){ //一组有2个
            cur = swapPairs(cur);
            ListNode next = null;
            while(count > 0){
                next = head.next;
                head.next = cur;
                cur = head;
                head = next;
                count--;
            }
            head = cur;
        }
        return head;
    }
}