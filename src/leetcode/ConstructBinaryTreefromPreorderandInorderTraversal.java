package leetcode;

import java.util.Arrays;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args){
        int[] a = new int[]{0,1,2,3,4};
        
        int[] b = Arrays.copyOfRange(a, 1, 2);
        System.out.println(Arrays.toString(b));
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0,
                inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int p_s, int p_e,
            int i_s, int i_e) {
        if (p_s > p_e || i_s > i_e) {
            return null;
        }
        int val = preorder[p_s];
        TreeNode node = new TreeNode(val);
        int pos = -1;
        for (int i = i_s; i <= i_e; i++) {
            if (inorder[i] == val) {
                pos = i;
                break;
            }
        }
        node.left = build(preorder,inorder,p_s+1,p_s+pos-i_s,i_s,pos-1);
        node.right = build(preorder,inorder,p_s+pos-i_s+1,p_e,pos+1,i_e);

        return node;
    }
}
