package leetcode

class DeleteAndEarnTest extends GroovyTestCase {
    DeleteAndEarn _test
    void setUp() {
        super.setUp()
        _test = new DeleteAndEarn()
    }

    void testDeleteAndEarn() {
        println _test.deleteAndEarn([2, 2, 3, 3, 3, 4] as int[])
    }
}
