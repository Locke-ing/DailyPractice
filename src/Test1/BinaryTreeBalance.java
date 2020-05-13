package Test1;
/*
题目描述：判断是否是平衡二叉树(平衡因子为0/1)
解题思路：计算左右子树的高度，判断是否平衡，通过递归算法实现。
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
public class BinaryTreeBalance {
    public boolean isBalance(TreeNode root){
        //判断根结点是否为null
        if (root == null){
            return true;
        }

        //计算左右子树的高度
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);

        //计算左右子树的高度差
        //Math.abs(x) 返回|x|
        if(Math.abs(leftHeight - rightHeight)>=1){
            return false;
        }

        //检查是否平衡
        return isBalance(root.left) && isBalance(root.right);
    }

    //计算树的高度
    public static int getTreeHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getTreeHeight(root.left),getTreeHeight(root.right))+1;
    }
}
