package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumRoottoLeafNumbers {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SumRoottoLeafNumbers f = new SumRoottoLeafNumbers();
        TreeNode r = new TreeNode(9);
        r.left = new TreeNode(2);
        r.right = new TreeNode(1);
        System.out.println(f.sumNumbers_2(r));

    }

    /**
     * using ergodic node trees to get sum -- solution 2
     * 
     * @param root
     * @return
     */
    public int sumNumbers_2(TreeNode root) {
        return generateSum(root,0);
    }

    private int generateSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null)
            return sum;
        return generateSum(root.left, sum) + generateSum(root.right, sum);
    }


    /**
     * using parent to get sum-- solution 1
     * 
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
        getParents(root, parentMap);

        List<TreeNode> leafNodes = new ArrayList<TreeNode>();
        findLeafs(root, leafNodes);

        List<Integer> numList = new ArrayList<Integer>();
        TreeNode parent = null;
        for (TreeNode leafNode : leafNodes) {
            StringBuilder sb = new StringBuilder();
            sb.append(leafNode.val);
            parent = parentMap.get(leafNode);
            while (null != parent) {
                sb.append(parent.val);
                parent = parentMap.get(parent);
            }
            numList.add(Integer.valueOf(sb.reverse().toString()));
        }

        Integer sum = 0;
        for (Integer l : numList) {
            sum += l;
        }

        return sum;
    }

    private void getParents(TreeNode node, Map<TreeNode, TreeNode> map) {
        if (null != node.left) {
            map.put(node.left, node);
            getParents(node.left, map);
        }
        if (null != node.right) {
            map.put(node.right, node);
            getParents(node.right, map);
        }
    }

    private void findLeafs(TreeNode node, List<TreeNode> list) {
        if (null != node.left) {
            findLeafs(node.left, list);
        }
        if (null != node.right) {
            findLeafs(node.right, list);
        }
        if (null == node.left && null == node.right) {
            list.add(node);
        }
    }
}
