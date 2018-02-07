package leetcode

import util.ListNodeHelper as helper

class OddEvenLinkedListTest extends GroovyTestCase {
    OddEvenLinkedList oddEvenLinkedList;

    void setUp() {
        oddEvenLinkedList = new OddEvenLinkedList()
    }

    void testOddEvenList() {
        def node = helper.genFromList([1, 2, 3, 4, 5] as List)

        def ret = oddEvenLinkedList.oddEvenList(node)

        def excepted = helper.genFromList([1, 3, 5, 2, 4] as List)

        assert excepted == ret
    }

    void testOddEvenList1() {
        def node = helper.genFromList([1, 2, 3, 4] as List)

        def ret = oddEvenLinkedList.oddEvenList(node)

        def excepted = helper.genFromList([1, 3, 2, 4] as List)

        assert excepted == ret
    }


    void testOddEvenList2() {
        def node = helper.genFromList([1] as List)

        def ret = oddEvenLinkedList.oddEvenList(node)

        def excepted = helper.genFromList([1] as List)

        assert excepted == ret
    }


    void testOddEvenList3() {
        def node = helper.genFromList([1, 2] as List)

        def ret = oddEvenLinkedList.oddEvenList(node)

        def excepted = helper.genFromList([1, 2] as List)

        assert excepted == ret
    }
}
