package leetcode

class FindAndReplacePatternTest extends GroovyTestCase {
    FindAndReplacePattern _test

    void setUp() {
        super.setUp()
        _test = new FindAndReplacePattern()

    }

    void testMatch() {
        assert !_test.match("xxz", "abb")
        assert !_test.match("xyz", "abb")
        assert !_test.match("xxx", "abb")

        assert _test.match("xxx", "aaa")
        assert _test.match("yzz", "abb")

    }

    void testFindAndReplacePattern() {
        assert _test.findAndReplacePattern(["abc", "deq", "mee", "aqq", "dkd", "ccc"] as String[], "abb") == ["mee", "aqq"]
    }
}
