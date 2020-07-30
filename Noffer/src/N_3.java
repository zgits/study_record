import base.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 从尾到头打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/4/10 20:52.
 */
public class N_3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> temp=new Stack<>();

        while (listNode!=null){
            temp.push(listNode.val);
            listNode=listNode.next;

        }
        ArrayList<Integer> result=new ArrayList<>();
        while (!temp.isEmpty()){
            result.add(temp.pop());
        }
        return result;


    }
}
