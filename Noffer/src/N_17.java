import base.ListNode;

/**
 * @Author: zjf
 * @Date: 2019/7/11 19:22
 * @Description: 合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class N_17 {

    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode result=null;

        if(list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        if (list1.val<list2.val){
            result=list1;
            result.next=Merge(list1.next,list2);
        }else{
            result=list2;
            result.next=Merge(list1,list2.next);
        }
        return result;
    }
}
