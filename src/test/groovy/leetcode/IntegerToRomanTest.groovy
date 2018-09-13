package leetcode

class IntegerToRomanTest extends GroovyTestCase {


    IntegerToRoman _test

    void setUp() {
        _test = new IntegerToRoman()
    }

    void testIntToRoman() {
        assert "M" == _test.intToRoman(1000)
        assert "MM" == _test.intToRoman(2000)
        assert "MMM" == _test.intToRoman(3000)

        assert "MMMCCC" == _test.intToRoman(3300)
        assert "MC" == _test.intToRoman(1100)
        assert "MMMCD" == _test.intToRoman(3400)
        assert "MCM" == _test.intToRoman(1900)
        assert "MMMDCCC" == _test.intToRoman(3800)

        assert "IX" == _test.intToRoman(9)
        assert "LVIII" == _test.intToRoman(58)
        assert "MCMXCIV" == _test.intToRoman(1994)
    }
}
