import base.ListNode;

/**
 * @Author: zjf
 * @Date: 2019/7/11 19:13
 * @Description: 反转链表
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class N_16 {

    public ListNode ReverseList(ListNode head) {

        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
