package leetcode;

import java.util.LinkedList;
import model.TreeNode;

public class SymmetricTree_Iteratively {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> leftList = new LinkedList<>();
        LinkedList<TreeNode> rightList = new LinkedList<>();
        leftList.push(root.left);
        rightList.add(root.right);
        while (!leftList.isEmpty() && !rightList.isEmpty()) {
            TreeNode left = leftList.poll();
            TreeNode right = rightList.poll();

            if (null == left && null == right) {
                continue;
            }
            if (null == left || null == right) {
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            leftList.add(left.left);
            leftList.add(left.right);
            rightList.add(right.right);
            rightList.add(right.left);
        }

        return true;
    }
}
