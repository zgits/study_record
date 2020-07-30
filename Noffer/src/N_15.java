import base.ListNode;

/**
 * @Author: zjf
 * @Date: 2019/7/11 13:23
 * @Description: 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class N_15 {

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode temp=head;
        int count=0;
        while (head!=null){
            count++;
            head=head.next;
        }
        int index=1;
        int find=count-k+1;
        ListNode result=null;
        while (temp!=null){
            if(index==find){
                result=temp;
            }
            temp=temp.next;
            index++;
        }
        return result;
    }
}
