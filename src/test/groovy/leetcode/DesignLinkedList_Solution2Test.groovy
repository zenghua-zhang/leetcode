package leetcode

class DesignLinkedList_Solution2Test extends GroovyTestCase {
  DesignLinkedList_Solution2.MyLinkedList _test

  void setUp() {
    super.setUp()
    def d = new DesignLinkedList_Solution2();
    _test = DesignLinkedList_Solution2.MyLinkedList.newInstance(d)

  }

  void testAddAndGet() {
    _test.addAtHead(1)

    verify([1])

    _test.addAtTail(2)
    verify([1, 2])

    _test.addAtHead(3)
    verify([3, 1, 2])

    _test.addAtTail(4)
    verify([3, 1, 2, 4])

  }

  void testTailAndGet() {
    _test.addAtTail(1)
    _test.addAtHead(2)

    verify([2, 1])
  }

  void testAddAtIndex() {
    _test.addAtIndex(0, 1)
    verify([1])

    _test.addAtIndex(1, 2)
    verify([1, 2])

    _test.addAtIndex(1, 3)
    verify([1, 3, 2])

    _test.addAtIndex(1, 4)
    verify([1, 4, 3, 2])


    _test.addAtIndex(4, 5)
    verify([1, 4, 3, 2, 5])
  }

  void testDeleteIndex() {
    _test.addAtTail(1)
    _test.addAtTail(2)
    _test.addAtTail(3)
    _test.addAtTail(4)
    _test.addAtTail(5)

    verify([1, 2, 3, 4, 5])

    _test.deleteAtIndex(0)
    verify([2, 3, 4, 5])

    _test.deleteAtIndex(4)
    verify([2, 3, 4, 5])

    _test.deleteAtIndex(2)
    verify([2, 3, 5])

    _test.deleteAtIndex(1)
    verify([2, 5])

    _test.deleteAtIndex(1)
    verify([2])

    _test.deleteAtIndex(0)
    verify([])

  }

  private void verify(List list) {
    list.eachWithIndex { int entry, int i ->
      assert _test.get(i) == entry
    }

    assert _test.get(list.size()) == -1

  }


}
