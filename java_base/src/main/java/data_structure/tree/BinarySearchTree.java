package data_structure.tree;

import java.util.Random;

/**
 * @author
 * @date 2021年10月02日 0:08
 * @description
 */
public class BinarySearchTree extends AbstractTree{


    @Override
    public void add(int data) {
        Node addNode = new Node(data);
        if (root == null) {
            root = addNode;
            return;
        }
        add(root, data);
    }

    private void add(Node node,int data) {
        Node addNode = new Node(data);

        if (data > node.data) {
            if (node.right == null) {
                node.right = addNode;
            } else {
                add(node.right, data);
            }
        } else if (data < node.data) {
            if (node.left == null) {
                node.left = addNode;
            } else {
                add(node.left, data);
            }
        } else {
            return;
        }
    }


    public void delete(int data) {
        delete0(this.root, data);
    }

    private void delete0(Node node,int data) {

        if (node == null) {
            return;
        }
        if (node.data == data) {
            delete1(node);
        } else if (node.data > data) {
            delete0(node.right, data);
        } else {
            delete0(node.left, data);
        }
    }


    public void delete1(Node targetNode) {

        if (targetNode.right == null) {
            targetNode = targetNode.left;
        } else if (targetNode.left == null) {
            targetNode = targetNode.right;
        } else {
            Node temp = targetNode;
            while (temp.left != null) {
                temp = temp.left;
            }
            Node left = targetNode.left;
            Node right = targetNode.right;
            targetNode = temp;
            targetNode.left = left;
            targetNode.right = right;
        }



    }



    public static void main(String[] args) {

        int[] data = new Random().ints(0, 20).limit(10).toArray();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int datum : data) {
            binarySearchTree.add(datum);
        }
        TreeShow.show(binarySearchTree.root);
    }

}
