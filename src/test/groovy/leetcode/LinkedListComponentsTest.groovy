package leetcode

import util.ListNodeHelper

class LinkedListComponentsTest extends GroovyTestCase {
    LinkedListComponents _test

    void setUp() {
        super.setUp()
        _test = new LinkedListComponents()
    }

    void testNumComponents() {

        assert 2 == _test.numComponents(ListNodeHelper.genFromList([0, 1, 2, 3]), [0, 1, 3] as int[])

        assert 2 == _test.numComponents(ListNodeHelper.genFromList([0, 1, 2, 3, 4]), [0, 3, 1, 4] as int[])


    }
}
