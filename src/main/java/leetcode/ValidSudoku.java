package leetcode;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            boolean ret = validNums(pickNums(board, row, row, 0, 8));
            if (!ret) {
                return false;
            }
        }
        for (int cell = 0; cell < 9; cell++) {
            boolean ret = validNums(pickNums(board, 0, 8, cell, cell));
            if (!ret) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean ret = validNums(pickNums(board, 0 + i * 3, 2 + i * 3,0 + j * 3,  2 + j * 3));
                if (!ret) {
                    return false;
                }
            }
        }

        return true;
    }

    private char[] pickNums(char[][] board, int rowStart, int rowEnd, int cellStart, int cellEnd) {
        char[] nums = new char[9];
        int pos = 0;
        System.out.println(rowStart + "," + rowEnd + "," + cellStart + "," + cellEnd);

        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = cellStart; j <= cellEnd; j++) {
                System.out.println(pos);
                nums[pos] = board[i][j];
                pos++;
            }
        }

        return nums;
    }

    private boolean validNums(char[] nums) {
        int[] pos = new int[9];

        for (char num : nums) {
            if (num - '1' < 9 && num - '1' >= 0) {
                pos[num - '1']++;
            }
        }
        for (int i : pos) {
            if (i > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] strs) {
        String[] strs1 = { ".87654321", "2........", "3........", "4........", "5........", "6........", "7........",
                "8........", "9........" };
        char[][] board = new char[9][9];
        int p = 0;
        for (String s : strs1) {
            char[] cs = s.toCharArray();
            for (int i = 0; i < 9; i++) {
                board[p][i] = cs[i];
            }
            p++;
        }

        ValidSudoku vs = new ValidSudoku();

        System.out.println(vs.isValidSudoku(board));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
