package leetcode

import spock.lang.Specification

class FindSmallestLetterGreaterThanTargetTest extends Specification {
    FindSmallestLetterGreaterThanTarget _test

    void setup() {
        _test = new FindSmallestLetterGreaterThanTarget()
    }

    def "NextGreatestLetter"(char[] a, char b, char c) {
        expect:
        _test.nextGreatestLetter(a, b) == c

        where:
        a               | b   | c
        ["c", "f", "j"] | 'a' | 'c'
        ["c", "f", "j"] | 'c' | 'f'
        ["c", "f", "j"] | 'd' | 'f'
        ["c", "f", "j"] | 'g' | 'j'
        ["c", "f", "j"] | 'j' | 'c'
        ["c", "f", "j"] | 'k' | 'c'
    }
}
