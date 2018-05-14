package leetcode

import leetcode.NumberOfAtoms.Node

class NumberOfAtomsTest extends GroovyTestCase {
    NumberOfAtoms _test

    void setUp() {
        super.setUp()
        _test = new NumberOfAtoms()
    }

    void testParseMapSimple() {
        //assert _test.countOfAtoms("H2O") == "H2O"
        def root = new Node(_test)
        def node_H = new Node(_test, "H", 1)
        def node_O = new Node(_test, "O", 2)
        def node_Mg = new Node(_test, "Mg")

        root.addChild(node_H)
        root.addChild(node_O)
        root.addChild(node_Mg)

        assert _test.parseMap(root) == "HMgO2"
    }

    void testParseMapWithChildren() {
        def root = new Node(_test)
        def node_H = new Node(_test, "H", 2)
        def sub = new Node(_test, "", 3)
        def node_O = new Node(_test, "O", 2)
        def node_Mg = new Node(_test, "Mg")

        root.addChild(node_H)
        root.addChild(sub)

        sub.addChild(node_O)
        sub.addChild(node_Mg)

        assert _test.parseMap(root) == "H2Mg3O6"
    }

    void testGetDigit() {
        assert 12 == _test.getDigit(parseString("12HO23"))
        assert 1 == _test.getDigit(parseString("HO23"))
        assert 4 == _test.getDigit(parseString("4"))
        assert 1 == _test.getDigit(parseString(""))
    }

    void testGetAtom() {
        assert "O" == _test.getAtom(parseString("O2H3"))
        assert "" == _test.getAtom(parseString("2H3"))
        assert "Mg" == _test.getAtom(parseString("Mg3H3"))
    }

    void testGetNode() {
        Node root = new Node(_test)
        assert _test.addNodesToParent(root, parseString("O2H3")) == false
        assert _test.parseMap(root) == "H3O2"

        root = new Node(_test)
        assert _test.addNodesToParent(root, parseString("O2H3Mg")) == false
        assert _test.parseMap(root) == "H3MgO2"

        root = new Node(_test)
        assert _test.addNodesToParent(root, parseString("CBA")) == false
        assert _test.parseMap(root) == "ABC"

        root = new Node(_test)
        assert _test.addNodesToParent(root, parseString("CB)A")) == true
        assert _test.parseMap(root) == "BC"


        root = new Node(_test)
        Queue q = parseString("O2H)3Mg")
        assert _test.addNodesToParent(root, q) == true
        assert _test.parseMap(root) == "HO2"
        assert q == ['3', 'M', 'g']

    }

    void testParse() {
        assert _test.countOfAtoms("O2H3Mg") == "H3MgO2"
        assert _test.countOfAtoms("O2(H3Mg)") == "H3MgO2"
        assert _test.countOfAtoms("(H3Mg)O2") == "H3MgO2"
        assert _test.countOfAtoms("(H3Mg)2O2") == "H6Mg2O2"
        assert _test.countOfAtoms("(H3MgO7)2O2") == "H6Mg2O16"
        assert _test.countOfAtoms("(H)2O2") == "H2O2"
        assert _test.countOfAtoms("H2(O2)") == "H2O2"
    }

    Queue<Character> parseString(String str) {
        new LinkedList<>(Arrays.asList(str.toCharArray()))
    }
}
