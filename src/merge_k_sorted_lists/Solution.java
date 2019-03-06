package merge_k_sorted_lists;

//可以用优先队列来辅助排序
//第一步 将数组中所有的链表结点放入优先队列中去
//第二步 从优先队列中取出顶部结点 连接到记录结点(用于返回)上去
//第三步 如果刚刚取出的结点有后继结点 则将后继结点取出 加入到优先队列中
import java.util.*;

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1,ListNode l2){
                if(l1.val < l2.val){
                    return -1;
                }else if(l1.val == l2.val){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        for(ListNode node : lists){
            if(node != null){
                queue.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            if(node.next != null){
                queue.add(node.next);
            }
            tail.next = node;
            tail = tail.next;
        }
        return dummy.next;
    }
}
