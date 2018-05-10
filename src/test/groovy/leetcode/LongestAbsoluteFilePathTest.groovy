package leetcode

class LongestAbsoluteFilePathTest extends GroovyTestCase {

    private LongestAbsoluteFilePath _test

    void setUp() {
        super.setUp()
        _test = new LongestAbsoluteFilePath()
    }

    void testLengthLongestPath() {
        _test.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext")
    }
}
