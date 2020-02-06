package leetcode

class CombinationSumTest extends GroovyTestCase {

  private CombinationSum combinationSum
  private CombinationSumII combinationSum2

  void setUp() {
    super.setUp()
    combinationSum = new CombinationSum()
    combinationSum2 = new CombinationSumII()
  }

  void testCombinationSum() {
    def ret = combinationSum.combinationSum([2, 3, 6, 7] as int[], 7)

    assert ret.size() == 2
    assert ret.contains([7])
    assert ret.contains([2, 2, 3])
  }

  void testCombinationSum2() {


    def ret = combinationSum2.combinationSum2([10, 1, 2, 7, 6, 1, 5] as int[], 8)

    assert ret.size() == 4
    assert ret.contains([1, 7])
    assert ret.contains([1, 2, 5])
    assert ret.contains([2, 6])
    assert ret.contains([1, 1, 6])
  }
}
