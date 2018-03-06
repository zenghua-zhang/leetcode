package leetcode

class ValidTicTacToeStateTest extends GroovyTestCase {
    ValidTicTacToeState unit

    void setUp() {
        unit = new ValidTicTacToeState()
    }

    void testValidTicTacToe() {
        assert true == unit.validTicTacToe(["XOX", "O O", "XOX"] as String[])
        assert true == unit.validTicTacToe(["XOX", "OXO", "XOX"] as String[])
        assert true == unit.validTicTacToe(["   ", "   ", "   "] as String[])
        assert true == unit.validTicTacToe(["XXX", "O O", "   "] as String[])
    }
}
