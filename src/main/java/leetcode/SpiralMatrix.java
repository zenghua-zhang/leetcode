package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int xstart = 0, ystart = 0;
        int xend = matrix.length, yend = matrix[0].length;

        List<Integer> list = new ArrayList<Integer>();

        genM(0, 0, xend, yend, matrix, list);

        return list;
    }

    private void genM(int xstart, int ystart, int xend, int yend, int[][] matrix, List<Integer> list) {
        if (ystart > yend || xstart > xend) {
            return;
        }
        int t = xstart;
    }

    public static void main(String[] args) {
        int[][] a = new int[3][4];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = (int) ((Math.random()) * 100);
                // System.out.print(a[i][j] + "   i:" + i + ";j:" + j);
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

    }
}
