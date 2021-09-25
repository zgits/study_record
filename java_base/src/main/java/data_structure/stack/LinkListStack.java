package data_structure.stack;

import java.util.StringJoiner;

/**
 * @author
 * @date 2021年09月20日 21:19
 * @description
 */
public class LinkListStack {


    public int stackSize;

    public Node top;


    public LinkListStack() {
        this.stackSize = 0;
        this.top = null;
    }


    public void push(int value) {

        Node newTop = new Node(value);
        newTop.next = top;
        top = newTop;
        stackSize++;
    }



    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("栈空");


        }

        int value = top.data;

        top = top.next;
        stackSize--;
        return value;


    }


    public boolean isEmpty() {
        return stackSize == 0;
    }

    public int peek() {
        return top.data;
    }


    public void display() {
        StringJoiner data = new StringJoiner(",");
        Node cur = top;
        while (cur != null) {
            data.add(String.valueOf(cur.data));
            cur = cur.next;
        }
        System.out.println(data.toString());

    }


    public static void main(String[] args) {
        int[] datas = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,22,33,44,88};

        LinkListStack linkListStack = new LinkListStack();

        for (int i = 0; i < datas.length  ; i++) {

            linkListStack.push(datas[i]);
        }

        linkListStack.display();


        System.out.println(linkListStack.pop());
        System.out.println(linkListStack.pop());


        linkListStack.display();


        linkListStack.push(92);
        linkListStack.push(98);
        linkListStack.display();
    }

}
