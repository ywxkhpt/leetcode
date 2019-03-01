package copy_list_with_random_pointer;
//链表带有随机指针 复制链表
import java.util.HashMap;
public class Solution {
    //第一步 将原链表的结点复制一份 连接到原链表上
    //第二步 根据 node.next.random = node.random.next
    //第三步 断开链表 进行恢复
    //第二种方法 使用HashMap存储原结点和复制结点的对应关系
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        //复制结点
        RandomListNode cur = head;
        while(cur!=null){
            RandomListNode node = new RandomListNode(cur.label);
            map.put(cur,node);
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
