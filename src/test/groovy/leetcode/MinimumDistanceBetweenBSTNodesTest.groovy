package leetcode

import model.TreeNode

class MinimumDistanceBetweenBSTNodesTest extends GroovyTestCase {
    MinimumDistanceBetweenBSTNodes testUnit

    void setUp() {
        super.setUp()
        testUnit = new MinimumDistanceBetweenBSTNodes()
    }

    void testMinDiffInBST() {
        def root = new TreeNode(4)
        def node2 = new TreeNode(2)
        def node1 = new TreeNode(1)
        def node3 = new TreeNode(3)
        def node6 = new TreeNode(6)


        root.left = node2
        root.right = node6

        node2.left = node1
        node2.right = node3

        println testUnit.minDiffInBST(root)


    }
}
