package leetcode

import util.TreeGenerator

class BinaryTreeRightSideViewTest extends GroovyTestCase {

    BinaryTreeRightSideView binaryTreeRightSideView

    void setUp() {
        super.setUp()
        binaryTreeRightSideView = new BinaryTreeRightSideView()
    }

    void testRightSideView() {
        def root = TreeGenerator.genTree(1, 2, 3, null, 5, null, 4)

        assert [1, 3, 4] == binaryTreeRightSideView.rightSideView(root)


    }
}
