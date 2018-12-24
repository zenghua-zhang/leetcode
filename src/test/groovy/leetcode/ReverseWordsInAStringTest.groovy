package leetcode

import spock.lang.Specification

class ReverseWordsInAStringTest extends Specification {
    ReverseWordsInAString _test

    void setup() {
        _test = new ReverseWordsInAString()
    }

    def "ReverseWords"() {
        expect:
        _test.reverseWords(a) == b

        where:
        a                                | b
        "Reverse Words In    A String  " | "String A In Words Reverse"
        "Reverse Words In    A String"   | "String A In Words Reverse"
        "the sky is blue"                | "blue is sky the"
        "    "                           | ""
    }
}
