package sort_list;
//链表的归并排序
//step1 分 不同于数组直接计算 需要快慢指针找到中间位置
//step2 递归归并 递归基是只有一个结点或者为空
//step3 合并 返回合并好的头节点
public class Solution {
    public ListNode sortList(ListNode head) {
        //递归基
        if(head == null || head.next == null){
            return head;
        }

        //step1
        ListNode pre = null;
        ListNode slow = head,fast = head;
        while(fast != null && fast.next != null){ //以fast作为基准
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;//很重要 将链表断开

        //step2
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        //step3
        return merge(l1,l2);

    }

    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            }else{
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }

        while(l1 != null){
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }

        while(l2 != null){
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }

        return dummy.next;
    }
}
