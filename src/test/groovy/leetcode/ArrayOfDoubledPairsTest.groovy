package leetcode


import spock.lang.Specification

class ArrayOfDoubledPairsTest extends Specification {

    ArrayOfDoubledPairs _test

    void setup() {
        _test = new ArrayOfDoubledPairs()
    }

    def "CanReorderDoubled"() {
        expect:
        _test.canReorderDoubled(a as int[]) == b

        where:
        a                           | b
        [2, 2, 4, 4]                | true
        [2, 2, 4, 6, 6, 8]          | false
        [2, 3, 4, 6, 7, 14, 16, 32] | true
        [2, 2, 4, 8]                | false
        [0, 0, 0, 0, 0, 1]          | false
        [1, 2, 1, 2, 1, 2, 2, 4]    | true
        [4, -2, 2, -4]              | true
        [0, 0, 0, 0]                | true

    }
}
