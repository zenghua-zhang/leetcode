package leetcode

class DecodeStringTest extends GroovyTestCase {
    DecodeString _test

    void setUp() {
        super.setUp()
        _test = new DecodeString()
    }


    void testDecodeString() {
        assert "aaa" == _test.decodeString("aaa")
        assert "abc" == _test.decodeString("abc")
        assert "aa" == _test.decodeString("2[a]")
        assert "abcabcabc" == _test.decodeString("3[abc]")
        assert "accaccacc" == _test.decodeString("3[a2[c]]")
        assert "abcabccdcdcdef" == _test.decodeString("2[abc]3[cd]ef")
        assert "aabcabccdcdcdef" == _test.decodeString("a2[abc]3[cd]ef")

    }
}
