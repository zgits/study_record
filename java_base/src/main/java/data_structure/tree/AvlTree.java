package data_structure.tree;

import static java.lang.Math.max;

/**
 * @author
 * @date 2021年10月02日 12:59
 * @description 平衡二叉查找树
 */
public class AvlTree extends AbstractTree {
    @Override
    void add(int data) {
        root = insert(root, data);
    }


    public Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else {
            if (value < node.data) {
                // 将data插入左子树
                node.left = insert(node.left, value);

                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (getHeight(node.left) - getHeight(node.right) == 2) {
                    if (value < node.left.data) {
                        node = leftLeftRotation(node);
                    } else if (value > node.left.data) {
                        node = leftRightRotation(node);
                    }
                }
            } else if (value > node.data) {
                //将key插入右子树
                node.right = insert(node.right, value);
                if (getHeight(node.left) - getHeight(node.right) == -2) {
                    if (value > node.right.data) {
                        node = rightRightRotation(node);
                    } else if (value < node.right.data) {
                        node = rightLeftRotation(node);
                    }
                }
            }
            updateHeight(node);
        }
        return node;
    }


    /*
     * LL: 左左对应的情况(左单旋转)。
     *
     * 返回值: 旋转后的根节点
     */
    private Node leftLeftRotation(Node k2) {
        Node k1;

        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = max( getHeight(k2.left), getHeight(k2.right)) + 1;
        k1.height = max( getHeight(k1.left), k2.height) + 1;

        return k1;
    }

    /*
     * RR: 右右对应的情况(右单旋转)。
     *
     * 返回值: 旋转后的根节点
     */
    private Node rightRightRotation(Node k1) {
        Node k2;

        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = max( getHeight(k1.left), getHeight(k1.right)) + 1;
        k2.height = max( getHeight(k2.right), k1.height) + 1;

        return k2;
    }

    /*
     * LR: 左右对应的情况(左双旋转)。
     *
     * 返回值: 旋转后的根节点
     */
    private Node leftRightRotation(Node k3) {
        k3.left = rightRightRotation(k3.left);

        return leftLeftRotation(k3);
    }

    /*
     * RL: 右左对应的情况(右双旋转)。
     *
     * 返回值: 旋转后的根节点
     */
    private Node rightLeftRotation(Node k1) {
        k1.right = leftLeftRotation(k1.right);

        return rightRightRotation(k1);
    }


    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        } else {
            int leftH = getHeight(node.left);
            int rightH = getHeight(node.right);
            return max(leftH, rightH) + 1;
        }
    }

    private void updateHeight(Node node) {
        node.height = getHeight(node);
    }


    /**
     * 前序遍历
     *
     * @return
     */
    public void toString(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        toString(node.left);
        toString(node.right);
    }
}
