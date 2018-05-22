package leetcode

class PyramidTransitionMatrixTest extends GroovyTestCase {
    PyramidTransitionMatrix _test

    void setUp() {
        super.setUp()
        _test = new PyramidTransitionMatrix()
    }

    void testPyramidTransition() {

        assert false ==  _test.pyramidTransition("XXXYX", ["XXX", "XXY", "XYX", "XYY", "YXZ"])
        assert true ==  _test.pyramidTransition("XYZ", ["XYD", "YZE", "DEA", "FFF"])
        assert true ==  _test.pyramidTransition("ABC", ["ABD","BCE","DEF","FFF"])
        assert false ==  _test.pyramidTransition("AABA",
                ["AAA", "AAB", "ABA", "ABB", "BAC"])
    }

}
