package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.TreeNode;

public class PathSumII {
    public static void main(String[] args){
        PathSumII p = new PathSumII();
        TreeNode tr = new TreeNode(1);
        p.pathSum(tr, 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (null == root) {
            return  new ArrayList<List<Integer>>();
        }
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        LinkedList<Integer> tmpList = new LinkedList<Integer>();
        hasSum(root, resultList, tmpList, sum, 0);

        return resultList;
    }

    public void hasSum(TreeNode node, List<List<Integer>> resultList,
            LinkedList<Integer> tmpList, int sum, int i) {
        tmpList.add(node.val);
        if (i + node.val == sum && node.left == null && node.right == null) {
            resultList.add(new ArrayList<Integer>(tmpList));
        } else {
            if (null != node.left) {
                hasSum(node.left, resultList, tmpList, sum, i + node.val);
            }
            if (null != node.right) {
                hasSum(node.right, resultList, tmpList, sum, i + node.val);
            }
        }
        tmpList.pollLast();

        return;
    }
}
