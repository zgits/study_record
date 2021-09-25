package data_structure.linkedlist;

import java.util.StringJoiner;

/**
 * @author
 * @date 2021年09月20日 14:44
 * @description
 */
public class singleLinkedList {


    public Node head;


    /**
     * 头插法
     * @param data
     */
    public void addFirst(int data) {

        Node cur = new Node(data);

        if (this.head == null) {
            this.head = cur;
            return;
        }

        cur.next = this.head;
        this.head = cur;


    }


    /**
     * 尾插法
     * @param data
     */
    public void addLast(int data) {
        Node node = new Node(data);


        if (this.head == null) {
            this.head = node;
            return;
        }



        // 查找尾结点
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }


        cur.next = node;


        return;
    }


    /**
     * 任意位置插入
     * @param index
     * @param data
     * @return
     */
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException("index 不合法");

        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        Node prev = findIndexSubOne(index);

        Node cur = new Node(data);


        cur.next = prev.next;
        prev.next = cur;


    }


    public Node findIndexSubOne(int index) {
        Node prev = this.head;
        while (index - 1 > 0) {
            prev = prev.next;
            index--;
        }
        return prev;
    }


    /**
     * 查找是否包含关键字
     * @param key
     * @return
     */
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {

            if (cur.data == key) {
                return true;
            }
            cur = cur.next;


        }
        return false;
    }


    /**
     * 删除第一个出现的key
     * @param key
     */
    public void remove(int key) {

        if (this.head.data == key) {
            this.head = this.head.next;
        }

        Node prev = searchPrev(key);
        if (prev != null) {
            prev.next = prev.next.next;
        }

    }


    /**
     * 找到值为key 的前一个节点
     * @param key
     * @return
     */
    public Node searchPrev(int key) {

        Node prev = this.head;

        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;

    }


    /**
     * 删除所有的key
     * @param key
     */
    public void removeAllKey(int key) {

    }


    /**
     * 获取链表长度
     * @return
     */
    public int size() {

        int count = 0;


        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;

    }


    public void display() {


        StringJoiner stringJoiner = new StringJoiner(",");
        Node cur = this.head;
        while (cur != null) {
            stringJoiner.add(String.valueOf(cur.data)
            );
            cur = cur.next;
        }
        System.out.println(stringJoiner.toString());

    }


    public void clear() {


        Node cur = this.head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = null;
            cur = next;
        }
        this.head = null;

    }


    public static void main(String[] args) {
        int[] datas = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,22,33,44,88};
        singleLinkedList singleLinkedList = new singleLinkedList();
        for (int data : datas) {
            singleLinkedList.addFirst(data);
        }
        singleLinkedList.display();

        singleLinkedList.addLast(85);
        singleLinkedList.display();


        singleLinkedList.addFirst(86);
        singleLinkedList.display();

        singleLinkedList.remove(44);
        singleLinkedList.display();



        singleLinkedList.addIndex(15,77);
        singleLinkedList.display();


        System.out.println(singleLinkedList.size());



    }

}
