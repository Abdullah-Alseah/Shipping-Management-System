/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homork;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

public class Homork {

  static int[][] a = {
    { 1, 2, 2, 3, 5 },
    { 3, 2, 3, 4, 4 },
    { 2, 4, 5, 3, 1 },
    { 6, 7, 1, 4, 5 },
    { 5, 1, 1, 2, 4 },
  };
  static int[][] b = {
    { 1, 1, 1, 1, 1 },
    { 1, 1, 1, 1, 2 },
    { 1, 1, 3, 1, 1 },
    { 1, 1, 1, 1, 1 },
    { 1, 1, 1, 1, 1 },
  };

  static int m = a.length; 
  static int n = a[0].length; 
  static int[] x = { 1, -1, 0, 0 };
  static int[] y = { 0, 0, 1, -1 };

  public static void main(String[] args) {
    boolean[][] pacific = new boolean[m][n];
    boolean[][] atlantic = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      dfs1(i, 0, pacific);
      dfs1(i, n - 1, atlantic);
    }
    for (int j = 0; j < n; j++) {
      dfs1(0, j, pacific);
      dfs1(m - 1, j, atlantic);
    }

    System.out.print("Cells ");
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          System.out.print("(" + i + "،" + j + ") ");
        }
      }
    }
    System.out.println();
    boolean[][] pacific2 = new boolean[m][n];
    boolean[][] atlantic2 = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      dfs2(i, 0, pacific2);
      dfs2(i, n - 1, atlantic2);
    }
    for (int j = 0; j < n; j++) {
      dfs2(0, j, pacific2);
      dfs2(m - 1, j, atlantic2);
    }

    System.out.print("Cells");
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (pacific2[i][j] && atlantic2[i][j]) {
          System.out.print("(" + i + "،" + j + ") ");
        }
      }
    }
  }
  static void dfs1(int i, int j, boolean[][] ocean) {
    ocean[i][j] = true;
    if (b[i][j] == 3) return; 

    for (int d = 0; d < 4; d++) {
      int ni = i + x[d];
      int nj = j + y[d];
      if (ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
      if (ocean[ni][nj]) continue;
      if (a[ni][nj] < a[i][j]) continue; 
      if (a[ni][nj] == a[i][j] && b[i][j] != 2) continue; 
      dfs1(ni, nj, ocean);
    }
  }
  static void dfs2(int i, int j, boolean[][] ocean) {
    ocean[i][j] = true;

    if (b[i][j] == 3) return; 

    for (int d = 0; d < 4; d++) {
      int ni = i + x[d];
      int nj = j + y[d];
      if (ni < 0 || nj < 0||  ni >= m || nj >= n) continue;
      if (ocean[ni][nj]) continue;
      if (a[ni][nj] < a[i][j]) continue;
      if (a[ni][nj] == a[i][j] && b[i][j] != 2) continue;
      if (b[ni][nj] == 3) continue;
      dfs2(ni, nj, ocean);
    }
  }
}