package leetcode;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0){
            return;
        }
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            int[] nint = matrix[i];
            int s = 0, e = len - 1;
            int tmp;
            while (s < e) {
                tmp = nint[s];
                nint[s] = nint[e];
                nint[e] = tmp;
                s++;
                e--;
            }
            matrix[i] = nint;
        }

        int row = 0, col = len - 2;
        while (col >= 0) {
            int tmpCol = col;
            while (tmpCol >= 0) {
                int tmp = matrix[row][tmpCol];
                matrix[row][tmpCol] = matrix[len - tmpCol][row - len];
                matrix[tmpCol][row] = tmp;
                tmpCol--;
            }
            row++;
            col--;
        }

    }
}
