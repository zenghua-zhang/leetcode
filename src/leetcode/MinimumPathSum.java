package leetcode;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;

        int[][] ret = new int[row][col];
        ret[0][0] = grid[0][0];
        for (int r = 1; r < row; r++) {
            ret[r][0] = ret[r - 1][0] + grid[r][0];
        }
        for (int c = 1; c < col; c++) {
            ret[0][c] = ret[0][c - 1] + grid[0][c];
        }

        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                ret[r][c] = Math.min(ret[r][c - 1], ret[r - 1][c]) + grid[r][c];
            }
        }

        return ret[row - 1][col - 1];
    }
}
