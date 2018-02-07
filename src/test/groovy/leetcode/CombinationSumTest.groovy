package leetcode

class CombinationSumTest extends GroovyTestCase {

    private CombinationSum combinationSum

    void setUp() {
        super.setUp()
        combinationSum = new CombinationSum()
    }

    void testCombinationSum() {
        def ret = combinationSum.combinationSum([2, 3, 6, 7] as int[], 7)

        assert ret.size() == 2
        assert ret.contains([7])
        assert ret.contains([2, 2, 3])
    }
}
