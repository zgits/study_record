package data_structure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author
 * @date 2021年10月01日 23:23
 * @description 完全二叉树
 */
public class CompleteBinaryTree extends AbstractTree{


    List<Node> nodeList = new ArrayList<>();


    @Override
    public void add(int data) {
        Node addNode = new Node(data);
        nodeList.add(addNode);
        if (root == null) {
            root = addNode;
            return;
        }

        int index = (nodeList.size() - 1 - 1) / 2;
        if (nodeList.get(index).right != null) {
            nodeList.get(index + 1).left = addNode;
        } else if (nodeList.get(index).left != null) {
            nodeList.get(index).right = addNode;
        } else {
            nodeList.get(index).left = addNode;
        }

    }


    public static void main(String[] args) {

        int[] data = new Random().ints(0, 20).limit(15).toArray();
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree();
        for (int datum : data) {
            completeBinaryTree.add(datum);
        }
        TreeShow.show(completeBinaryTree.root);


    }

}
