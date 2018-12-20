package leetcode

import spock.lang.Specification

class ValidateStackSequencesTest extends Specification {
    ValidateStackSequences _test

    void setup() {
        _test = new ValidateStackSequences();
    }

    def "ValidateStackSequences"() {
        expect:
        _test.validateStackSequences(a as int[], b as int[]) == c

        where:
        a               | b               | c
        [1, 2, 3, 4, 5] | [4, 5, 3, 2, 1] | true
        [1, 2, 3, 4, 5] | [1, 2, 3, 4, 5] | true
        [1, 2, 3, 4, 5] | [4, 3, 5, 1, 2] | false
        [1, 0, 2]       | [2, 1, 0]       | false
        []              | []              | true
    }
}
