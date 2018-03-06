package leetcode;

public class ValidTicTacToeState {

  public boolean validTicTacToe(String[] board) {
    if (board.length != 3 || board[0].length() != 3) {
      return false;
    }

    int numX = 0;
    int numO = 0;
    for (String s : board) {
      for (char c : s.toCharArray()) {
        if (c == 'O') {
          numO++;
        } else if (c == 'X') {
          numX++;
        }
      }
    }

    if (numO > numX) {
      return false;
    }
    if (numX - numO > 1) {
      return false;
    }

    int wonX = won(board, 'X');
    int wonO = won(board, 'O');

    if (wonO > 1) {
      return false;
    }
    if (wonX > 1 && (numO + numX) < 9) {
      return false;
    }
    if (wonO == 1 && wonX == 1) {
      return false;
    }

    if (wonX == 1 && numX - numO != 1) {
      return false;
    }

    if (wonO == 1 && numO - numX != 0) {
      return false;
    }

    return true;
  }

  private int won(String[] board, char c) {
    int wonNumber = 0;

    for (String s : board) {
      boolean win = true;
      for (char h : s.toCharArray()) {
        if (h != c) {
          win = false;
        }
      }
      if (win) {
        wonNumber++;
      }
    }

    for (int i = 0; i < 3; i++) {
      boolean win = true;
      for (String s : board) {
        if (s.charAt(i) != c) {
          win = false;
        }
      }
      if (win) {
        wonNumber++;
      }
    }

    String s0 = board[0], s1 = board[1], s2 = board[2];

    if (s0.charAt(0) == c && s1.charAt(1) == c && s2.charAt(2) == c) {
      wonNumber++;
    }

    if (s0.charAt(2) == c && s1.charAt(1) == c && s2.charAt(0) == c) {
      wonNumber++;
    }

    return wonNumber;
  }
}
