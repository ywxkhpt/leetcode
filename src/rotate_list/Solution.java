package rotate_list;

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        int length = 0;
        while(tail.next !=  null){
            tail = tail.next;
            length++;
        }
        n = n % length;
        if(n == 0) return head;//等于0不用移动
        tail.next = dummy.next;//构成一个环
        n = length - n;//构成环后 头节点向右length - n 步
        ListNode pre = null;
        ListNode ret = dummy.next;
        while(n > 0){
            pre = ret;
            ret = ret.next;
            n--;
        }
        pre.next = null;//断开环
        return ret;
    }
}
