import java.util.Stack;

/**
 * @Description: 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @Author: 幻夜~星辰
 * @Date: Created in 2019/4/10 21:23.
 */
public class N_5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result=stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}
