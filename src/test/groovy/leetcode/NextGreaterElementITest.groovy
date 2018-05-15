package leetcode

class NextGreaterElementITest extends GroovyTestCase {
    NextGreaterElementI _test

    void setUp() {
        super.setUp()
        _test = new NextGreaterElementI()
    }

    void testNextGreaterElement() {
        assert [-1, 3, -1] == _test.nextGreaterElement([4, 1, 2] as int[], [1, 3, 4, 2] as int[])

    }
}
