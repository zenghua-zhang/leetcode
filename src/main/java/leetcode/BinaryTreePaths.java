package leetcode;

import java.util.ArrayList;
import java.util.List;
import model.TreeNode;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        if (root.left == null && root.right == null) {
            ret.add(String.valueOf(root.val));
        }

        List<String> lefts = binaryTreePaths(root.left);
        for (String str : lefts) {
            ret.add(root.val + "->" + str);
        }

        List<String> rights = binaryTreePaths(root.right);
        for (String str : rights) {
            ret.add(root.val + "->" + str);
        }

        return ret;
    }
}
