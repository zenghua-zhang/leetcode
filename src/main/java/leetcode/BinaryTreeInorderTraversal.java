package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import model.TreeNode;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Set<TreeNode> traveled = new HashSet<TreeNode>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tmp = queue.peekLast();
            if (tmp == null) {
                queue.removeLast();
                continue;
            }
            if (tmp.left == null || traveled.contains(tmp)) {
                ret.add(tmp.val);
                queue.removeLast();
                queue.add(tmp.right);
            } else {
                traveled.add(tmp);
                queue.add(tmp.left);
            }

        }

        return ret;

    }
}
