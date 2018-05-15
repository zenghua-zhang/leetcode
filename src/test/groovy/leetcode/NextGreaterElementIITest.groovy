package leetcode

class NextGreaterElementIITest extends GroovyTestCase {
    NextGreaterElementII _test

    void setUp() {
        super.setUp()
        _test = new NextGreaterElementII()
    }

    void testNextGreaterElement() {
        assert [2, 3, 4, 5, -1] == _test.nextGreaterElements([1, 2, 3, 4, 5] as int[])
        assert [3, 4, -1, 3] == _test.nextGreaterElements([1, 3, 4, 2] as int[])
        assert [2, -1, 2] == _test.nextGreaterElements([1, 2, 1] as int[])
        assert [-1, -1, -1, -1, -1] == _test.nextGreaterElements([1, 1, 1, 1, 1] as int[])

    }
}
