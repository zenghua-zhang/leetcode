package leetcode

class NumberOfSubarraysBoundedMaximumTest extends GroovyTestCase {
    NumberOfSubarraysBoundedMaximum unit

    void setUp() {
        unit = new NumberOfSubarraysBoundedMaximum()
    }

    void testNumSubarrayBoundedMax() {
        assert 19 == unit.numSubarrayBoundedMax([2, 3, 4, 1, 4, 0] as int[], 2, 4)

        assert 3 == unit.numSubarrayBoundedMax([2, 3, 4, 1, 4, 0] as int[], 2, 3)

        assert 18 == unit.numSubarrayBoundedMax([2, 3, 4, 1, 0, 4] as int[], 2, 4)

        assert 3 == unit.numSubarrayBoundedMax([2, 1, 4, 3] as int[], 2, 3)

        assert 0 == unit.numSubarrayBoundedMax([1, 1, 1, 1, 1, 1] as int[], 2, 3)


    }
}
