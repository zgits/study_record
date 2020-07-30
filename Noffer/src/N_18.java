import base.TreeNode;

/**
 * @Author: zjf
 * @Date: 2019/7/11 19:32
 * @Description: 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class N_18 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root2==null){
            return false;
        }
        if(root1==null){
            return true;
        }

        if (root1.val==root2.val){
            return true;
        }

        return HasSubtree(root1.left,root2.left)&&HasSubtree(root1.right,root2.right);

    }
}
