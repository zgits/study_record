import java.util.Stack;

/**
 * @Author: zjf
 * @Date: 2019/7/11 20:16
 * @Description: 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class N_21 {


    Stack<Integer> result=new Stack<>();

    public void push(int node) {

        result.push(node);
    }

    public void pop() {

        result.pop();
    }

    public int top() {

        return result.peek();
    }

    public int min() {

        int number=top();
        while (result!=null){
            int temp=top();
            if(temp<number){
                number=temp;
            }
        }
        return number;
    }
}
