package data_structure.stack;

/**
 * @author
 * @date 2021年09月20日 20:50
 * @description
 */
public class ArrayStack {


    private int[] datas;

    private int top=-1;

    private int maxSize;


    public ArrayStack(int maxSize) {

        System.out.println(maxSize);
        datas = new int[maxSize];
        this.maxSize = maxSize;
    }


    public boolean isEmpty() {
        return top == -1;
    }


    public boolean isFull(){
        return top == maxSize - 1;
    }


    public void push(int value) {


        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        datas[++top] = value;
    }


    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }

        int value = datas[top--];

        return value;
    }


    public void display() {

        System.out.println("----------start------------");
        for (int i = top; i >= 0; i--) {
            System.out.println(i + ": " + datas[i]);
        }
        System.out.println("----------end------------");

    }




    public static void main(String[] args) {
        int[] datas = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,22,33,44,88};

        ArrayStack arrayStack = new ArrayStack(datas.length <<2);

        for (int i = 0; i < datas.length  ; i++) {

            arrayStack.push(datas[i]);
        }

        arrayStack.display();


        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());


        arrayStack.display();


        arrayStack.push(92);
        arrayStack.push(98);
        arrayStack.display();
    }


}
