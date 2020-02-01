package leetcode

import spock.lang.Specification

class ValidNumberTest extends Specification {
  ValidNumber _test

  void setup() {
    _test = new ValidNumber()
  }

  def "IsNumber"() {
    expect:
    _test.isNumber(a as String) == r

    where:
    a           | r
    "0"         | true
    "1.1.1"     | false
    "1e1"       | true
    "1.0e2"     | true
    "2e1e.0"    | false
    "2e1e2"     | false
    "+2e-1"     | true
    "95a54e53"  | false
    " 6e-1"     | true
    " -90e3   " | true
    "0"         | true
    " 0.1 "     | true
    "abc"       | false
    "1 a"       | false
    "2e10"      | true
    " -90e3   " | true
    " 1e"       | false
    "e3"        | false
    " 6e-1"     | true
    " 99e2.5 "  | false
    "53.5e93"   | true
    " --6 "     | false
    "-+3"       | false
    "95a54e53"  | false
    ".1"        | true
    "-.1"       | true
    "3."        | true
    " -."       | false

  }
}
