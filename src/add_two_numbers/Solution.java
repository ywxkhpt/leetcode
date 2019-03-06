package add_two_numbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        int flag = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + flag;
            flag = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + flag;
            flag = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + flag;
            flag = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = cur.next;
            l2 = l2.next;
        }


        if (flag != 0) {
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        Solution solution = new Solution();
        solution.addTwoNumbers(l1, l2);
    }
}
