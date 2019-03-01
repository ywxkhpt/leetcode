package remove_duplicates_from_sorted_list_ii;
//去重 重复的全删除

public class Solution {
    //需要当前结点的值和后面的比较 直到一个不相同
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        while(head != null){
            while(head.next != null && head.val == head.next.val){ //一直到不相同 或者为空 此时head指向最后一个相同的
                head = head.next;
            }
            if(pre.next == head){//没有发现相同的
                pre = pre.next; //要向后移
            }else{//发现相同的
                pre.next = head.next; //不用向后移
            }
            head = head.next;
        }
        return dummy.next;
    }
}
