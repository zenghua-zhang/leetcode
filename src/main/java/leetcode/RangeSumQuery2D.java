package leetcode;

import java.util.Arrays;

public class RangeSumQuery2D {
    public class NumMatrix {

        public int[][] sum;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) {
                sum = new int[0][0];
                return;
            }
            sum = new int[matrix.length][matrix[0].length];
            sum[0][0] = matrix[0][0];
            for (int col = 1; col < matrix[0].length; col++) {
                sum[0][col] = sum[0][col - 1] + matrix[0][col];
            }
            for (int row = 1; row < matrix.length; row++) {
                sum[row][0] = sum[row - 1][0] + matrix[row][0];
            }
            for (int row = 1; row < matrix.length; row++) {
                for (int col = 1; col < matrix[0].length; col++) {
                    sum[row][col] = matrix[row][col] + sum[row - 1][col] + sum[row][col - 1] - sum[row - 1][col - 1];
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 > row2 || col1 > col2 || row2 > sum.length || col2 > sum[0].length) {
                return 0;
            }
            if (row1 == 0 && col1 == 0) {
                return sum[row2][col2];
            }
            if (row1 == 0) {
                return sum[row2][col2] - sum[row2][col1 - 1];
            }
            if (col1 == 0) {
                return sum[row2][col2] - sum[row1 - 1][col2];
            }
            int ret = sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
            return ret;
        }
    }

    public static void main(String[] strs) {
        int[][] r = new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 } };
        int[][] w = new int[][] { { 3, 0, 1, 4, 2 } };

        NumMatrix m = (new RangeSumQuery2D()).new NumMatrix(r);

        int[][] k = m.sum;
        for (int i = 0; i < r.length; i++) {
            System.out.println(Arrays.toString(r[i]));
        }
        System.out.println();

        System.out.println(k.length);

        for (int i = 0; i < k.length; i++) {
            System.out.println(Arrays.toString(k[i]));
        }
        System.out.println();

        System.out.println(m.sumRegion(2, 1, 4, 3));
        System.out.println(m.sumRegion(1, 1, 2, 2));
        System.out.println(m.sumRegion(1, 2, 2, 4));
        System.out.println(m.sumRegion(0, 1, 2, 2));

    }
}
