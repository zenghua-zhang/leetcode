package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.TreeNode;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        LinkedList<TreeNode> v = new LinkedList<TreeNode>();
        v.push(root);
        
        while(!v.isEmpty()){
            TreeNode node = v.pop();
            list.add(node.val);
            if(node.right!=null){
                v.push(node.right);
            }
            if(node.left != null){
                v.push(node.left);
            }
        }
        
        return list;
    }
}
