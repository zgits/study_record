import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zjf
 * @Date: 2019/7/11 21:10
 * @Description: 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class N_23 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> result=new ArrayList<Integer>();
        ArrayList<TreeNode> queue=new ArrayList<>();

        if (root==null){
            return result;
        }

        queue.add(root);
        while (queue.size()!=0){
            TreeNode temp=queue.remove(0);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
            result.add(temp.val);
        }
        return result;

    }
}
