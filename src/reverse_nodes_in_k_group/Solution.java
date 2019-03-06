package reverse_nodes_in_k_group;

public class Solution {
    //递归实现 递归返回的结点为调整顺序后的头节点
    //第一步 找出第k+1个结点
    //第二步 将第k+1个结点作为头节点递归调整顺序
    //第三步 将前k个结点调整顺序 返回头节点
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        int count = 0;
        ListNode cur = head;
        while(cur != null && count < k){//找出第k+1个结点
            cur = cur.next;
            count++;
        }
        if(count == k){ //一组有k个
            cur = reverseKGroup(cur,k);
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
