import base.TreeNode;

/**
 * @Author: zjf
 * @Date: 2019/7/11 19:49
 * @Description: 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class N_19 {

    public void Mirror(TreeNode root) {
        TreeNode temp=null;
        if (root!=null){
            temp=root.left;
            root.left=root.right;
            root.right=temp;
            if(root.left!=null){
                Mirror(root.left);
            }
            if(root.right!=null){
                Mirror(root.right);
            }
        }

    }
}
