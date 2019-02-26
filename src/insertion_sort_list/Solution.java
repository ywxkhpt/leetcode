package insertion_sort_list;
//链表的插入排序
//辅助结点用来记录头的位置 需要记录每次插入排序后的尾节点 更新需要插入的结点
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);//辅助结点 记录头的位置

        ListNode pre = dummy; //插入排序的起始位置
        ListNode cur = head; //当前要插入的结点
        ListNode next = null; //下一个要插入的结点

        while(cur != null){
            next = cur.next;
            while(pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }

        return dummy.next;
    }
}
