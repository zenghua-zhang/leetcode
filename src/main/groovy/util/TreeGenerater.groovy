package util

import model.TreeNode
import org.hamcrest.core.IsNull
import org.junit.Test
import static org.junit.Assert.*
import static org.hamcrest.Matchers.*

public class TreeGenerator {
    public static TreeNode gen(String str) {
        println str
    }

    public static TreeNode genTree(Integer[] ints) {
        def length = ints.length
        if (length < 1) {
            return null;
        }
        TreeNode[] treeNodes = new TreeNode[ints.length]
        ints.eachWithIndex { Integer entry, int i ->
            if (null == entry) {
                return;
            }
            TreeNode node = new TreeNode(entry)
            treeNodes[i] = node
        }
        treeNodes.eachWithIndex { TreeNode entry, int i ->
            if (null == entry) {
                return;
            }
            if (i * 2 + 1 < length) {
                entry.left = treeNodes[i * 2 + 1]
            }
            if (i * 2 + 2 < length) {
                entry.right = treeNodes[i * 2 + 2]
            }
        }

        return treeNodes[0]
    }

    @Test
    public void testGenTreeWithInts() {
        int[] ints = [1, 2, 3, 4, 5, 6]

        TreeNode root = TreeGenerator.genTree(ints)

        assertThat root.val, is(1)
        assertThat root.left.val, is(2)
        assertThat root.right.val, is(3)
        assertThat root.left.left.val, is(4)
        assertThat root.left.right.val, is(5)
        assertThat root.right.left.val, is(6)
    }

    @Test
    public void testGenTreeWithIntHasNull() {
        Integer[] ints = [1, 2, null, 3, null, null]
        TreeNode root = TreeGenerator.genTree(ints)

        assertThat root.val, is(1)
        assertThat root.left.val, is(2)
        assertThat root.left.left.val, is(3)
        assertThat root.left.right, nullValue()
        assertThat root.right, nullValue()

    }
}
