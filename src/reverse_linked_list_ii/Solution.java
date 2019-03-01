package reverse_linked_list_ii;
// 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
// dummy-> 1 -> 2 -> 3 -> 4 -> 5
// first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
// second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 0;i < m-1;i++){
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode now = start.next;
        for(int i = 0; i< n-m ;i++){ //一次移动相当于把now 放在m位置，其它的都向后移动一位
            start.next = now.next;
            now.next = pre.next;
            pre.next = now;
            now = start.next; //更新now的位置
        }
        return dummy.next;
    }

}
