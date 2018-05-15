package leetcode

class FindAllDuplicatesInAnArrayTest extends GroovyTestCase {
    FindAllDuplicatesInAnArray _test

    void setUp() {
        super.setUp()
        _test = new FindAllDuplicatesInAnArray()
    }

    void testFindDuplicates() {
       assert  [10,1] == _test.findDuplicates([10,2,5,10,9,1,1,4,3,7] as int[])
    }
}
