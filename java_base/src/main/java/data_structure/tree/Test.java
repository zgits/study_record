package data_structure.tree;

import java.util.Random;

/**
 * @author
 * @date 2021年10月02日 0:31
 * @description
 */
public class Test {


    public static void main(String[] args) {

        int[] data = new Random().ints(0, 20).distinct().limit(15).toArray();
        AbstractTree tree = new CompleteBinaryTree();
        for (int datum : data) {
            tree.add(datum);
        }
        System.out.println("完全二叉树");
        TreeShow.show((tree).root);


        System.out.println("二叉搜索树");
        tree = new BinarySearchTree();
        for (int datum : data) {
            tree.add(datum);
        }
        TreeShow.show((tree).root);


        System.out.println("平衡二叉树");
        tree = new AvlTree();
        for (int datum : data) {
            tree.add(datum);
        }
        TreeShow.show((tree).root);
        ((AvlTree)tree).toString(tree.root);;


    }


}
