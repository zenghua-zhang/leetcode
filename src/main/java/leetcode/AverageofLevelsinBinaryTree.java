package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageofLevelsinBinaryTree {

  public List<Double> averageOfLevels(TreeNode root) {
    LinkedList<TreeNode> nodeList = new LinkedList<>();
    LinkedList<Integer> posList = new LinkedList<>();

    nodeList.push(root);
    posList.push(1);

    List<Double> retList = new ArrayList<>();
    int total = 0, curr = 1;
    double sum = 0.0;
    while (!nodeList.isEmpty()) {
      TreeNode node = nodeList.removeLast();
      int nodePos = posList.removeLast();

      if (curr == nodePos) {
        sum = sum + node.val;
        total++;
      } else {
        retList.add(sum / total);
        sum = node.val;
        curr = nodePos;
        total = 1;
      }

      if (node.left != null) {
        nodeList.push(node.left);
        posList.push(nodePos + 1);
      }
      if (node.right != null) {
        nodeList.push(node.right);
        posList.push(nodePos + 1);
      }
    }
    retList.add(sum / total);

    return retList;
  }

}
