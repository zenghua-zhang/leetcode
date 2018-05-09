package leetcode;

public class ChampagneTower {

  public double champagneTower(int poured, int query_row, int query_glass) {
    TowerRow[] towerRows = new TowerRow[100];
    for (int i = 0; i < 100; i++) {
      towerRows[i] = new TowerRow(i);
    }
    towerRows[0].list[0] = poured;
    for (int i = 0; i < 100; i++) {
      double[] list = towerRows[i].list;
      for (int j = 0; j < list.length; j++) {
        double val = list[j];
        if (val > 1) {
          list[j] = 1;
          double mid = (val - 1) / 2;
          if (i < 99) {
            towerRows[i + 1].list[j] += mid;
            towerRows[i + 1].list[j + 1] += mid;
          }
        }

      }
    }

    return towerRows[query_row].list[query_glass];
  }


  private class TowerRow {

    private double[] list;
    private int rowNum;

    private TowerRow(int row) {
      this.rowNum = row;
      list = new double[row + 1];
    }
  }
}
